package com.jineric.cassandranestedobj.repository;

import com.jineric.cassandranestedobj.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {
//    List<Order> findAllByKeyOrderNumberAndKeyStoreNumber(String orderNumber, String storeNumber);
    List<Order> findAllByOrderNumberAndStoreNumber(String orderNumber, String storeNumber);

//    Order findByKeyOrderNumberAndKeyStoreNumberAndKeyPurchaseOrderNumber(String orderNumber, String storeNumber, String purchaseOrderNumber);
    Order findByOrderNumberAndStoreNumberAndPurchaseOrderNumber(String orderNumber, String storeNumber, String purchaseOrderNumber);
//
//    Order deleteByOrderNumberAndStoreNumberAndPurcahseOrderNumber(String orderNumber, String storeNumber, String purchaseOrderNumber);
//
//    List<Order> deleteByOrderNumberAndStoreNumber(String orderNumber, String storeNumber);
}
