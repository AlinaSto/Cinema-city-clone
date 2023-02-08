package com.spring.cinema.dto;

import java.util.ArrayList;
import java.util.List;

public class AddCinemaRoomDTO {

    private int noOfRows;
    private int noOfCols;
    private List<ExtraPriceDTO> extraPrices;

    public AddCinemaRoomDTO(int noOfRows, int noOfCols, List<ExtraPriceDTO> extraPrices) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.extraPrices = extraPrices;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfCols() {
        return noOfCols;
    }

    public void setNoOfCols(int noOfCols) {
        this.noOfCols = noOfCols;
    }

    public List<ExtraPriceDTO> getExtraPrices() {
        if(this.extraPrices == null){
            this.extraPrices = new ArrayList<>();
        }
        return extraPrices;
    }

    public void setExtraPrices(List<ExtraPriceDTO> extraPrices) {
        this.extraPrices = extraPrices;
    }
}