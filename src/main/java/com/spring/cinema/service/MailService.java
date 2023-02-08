package com.spring.cinema.service;

import com.itextpdf.text.DocumentException;
import com.spring.cinema.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private JavaMailSender emailSender;
    private PdfService pdfService;

    @Autowired
    public MailService(JavaMailSender emailSender, PdfService pdfService) {
        this.emailSender = emailSender;
        this.pdfService = pdfService;
    }

    public void sendOrderConfirmationMessage(
            String recepientMail, Order order) throws MessagingException, DocumentException {

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("cursjustcodeit@gmail.com");
        helper.setTo(recepientMail);

        helper.setSubject("Rezervarea ta la filmul " +order.getTicketList().get(0).getProjection().getMovie().getMovieName());
        helper.setText("Ai atasate cele " +order.getTicketList().size()+ " bilete pentru fimul " +order.getTicketList().get(0).getProjection().getMovie().getMovieName());
        helper.addAttachment("ticket.pdf", pdfService.generateTicketPdf(order));
        emailSender.send(message);

    }
}