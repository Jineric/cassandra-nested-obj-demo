package com.jineric.cassandranestedobj.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

//@Table("Orders")
//public class Order {
//    @NotBlank
//    @PrimaryKey
//    private Order.Key key;
//
//    @NotBlank
//    @Column("order_lines")
//    private List<OrderLine> orderLines;
//
//    public Order(@NotBlank Order.Key key, @NotBlank List<OrderLine> orderLines) {
//        this.key = key;
//        this.orderLines = orderLines;
//    }
//
//    public Order() {
//    }
//
//    public Key getKey() {
//        return key;
//    }
//
//    public void setKey(Key key) {
//        this.key = key;
//    }
//
//    public List<OrderLine> getOrderLines() {
//        return orderLines;
//    }
//
//    public void setOrderLines(List<OrderLine> orderLines) {
//        this.orderLines = orderLines;
//    }
//
//    @PrimaryKeyClass
//    public static class Key implements Serializable {
//        @PrimaryKeyColumn(name = "order_number", ordinal = 0, type = PARTITIONED)
//        private String orderNumber;
//
//        @PrimaryKeyColumn(name = "store_number", ordinal = 1, type = PARTITIONED)
//        private String storeNumber;
//
//        @PrimaryKeyColumn(name = "purchase_order_number", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
//        private String purchaseOrderNumber;
//
//        public Key(String orderNumber, String storeNumber, String purchaseOrderNumber) {
//            this.orderNumber = orderNumber;
//            this.storeNumber = storeNumber;
//            this.purchaseOrderNumber = purchaseOrderNumber;
//        }
//
//        public String getOrderNumber() {
//            return orderNumber;
//        }
//
//        public void setOrderNumber(String orderNumber) {
//            this.orderNumber = orderNumber;
//        }
//
//        public String getStoreNumber() {
//            return storeNumber;
//        }
//
//        public void setStoreNumber(String storeNumber) {
//            this.storeNumber = storeNumber;
//        }
//
//        public String getPurchaseOrderNumber() {
//            return purchaseOrderNumber;
//        }
//
//        public void setPurchaseOrderNumber(String purchaseOrderNumber) {
//            this.purchaseOrderNumber = purchaseOrderNumber;
//        }
//    }
//}

@Table("Orders")
public class Order {
    @NotBlank
    @Column("order_lines")
    private List<OrderLine> orderLines;

    @NotBlank
//    @PrimaryKey
    @PrimaryKeyColumn(name = "order_number", ordinal = 0, type = PARTITIONED)
    private String orderNumber;

    @NotBlank
//    @PrimaryKey
    @PrimaryKeyColumn(name = "store_number", ordinal = 1, type = PARTITIONED)
    private String storeNumber;

    @NotBlank
//    @PrimaryKey
    @PrimaryKeyColumn(name = "purchase_order_number", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private String purchaseOrderNumber;

    public Order(@NotBlank List<OrderLine> orderLines, @NotBlank String orderNumber, @NotBlank String storeNumber, @NotBlank String purchaseOrderNumber) {
        this.orderLines = orderLines;
        this.orderNumber = orderNumber;
        this.storeNumber = storeNumber;
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Order() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}