package com.spring.cinema.controller;

import com.itextpdf.text.DocumentException;
import com.spring.cinema.dto.OrderDTO;
import com.spring.cinema.model.Order;
import com.spring.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public Order buyTicket(@RequestBody OrderDTO orderDTO) throws MessagingException, DocumentException {
        return orderService.buyTicket(orderDTO);
    }
}