package com.jineric.cassandranestedobj.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class OrderLine {

    @Column(value = "sku_number")
    private String skuNumber;

    @Column(value = "qty")
    private String qty;

    public OrderLine(String skuNumber, String qty) {
        this.skuNumber = skuNumber;
        this.qty = qty;
    }

    public String getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
