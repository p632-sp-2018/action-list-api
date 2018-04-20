package com.actionlistapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomSort {
    private String direction;
    private String orderBy;

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("orderBy")
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
