package com.jineric.cassandranestedobj.controller;

import com.jineric.cassandranestedobj.model.Order;
import com.jineric.cassandranestedobj.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        Iterable<Order> result = orderRepository.findAll();
        List<Order> orderList = new ArrayList<Order>();
        result.forEach(orderList::add);
        return orderList;
    }

    @GetMapping("stores/{storeNumber}/orders/{orderNumber}")
    public List<Order> getOrder(@PathVariable String storeNumber, @PathVariable String orderNumber) {
        List<Order> order = orderRepository.findAllByOrderNumberAndStoreNumber(orderNumber, storeNumber);
//        List<Order> order = orderRepository.findAllByKeyOrderNumberAndKeyStoreNumber(orderNumber, storeNumber);
        return order;
    }

    @GetMapping("stores/{storeNumber}/orders/{orderNumber}/purchaseordernumbers/{purchaseOrderNumber}")
    public Order getOrder(@PathVariable String storeNumber, @PathVariable String orderNumber, @PathVariable String purchaseOrderNumber) {
        Order order = orderRepository.findByOrderNumberAndStoreNumberAndPurchaseOrderNumber(orderNumber, storeNumber, purchaseOrderNumber);
//        Order order = orderRepository.findByKeyOrderNumberAndKeyStoreNumberAndKeyPurchaseOrderNumber(orderNumber, storeNumber, purchaseOrderNumber);
        return order;
    }

//    @DeleteMapping(value = "/orders/{id}", produces = "application/json; charset=utf-8")
//    public String deleteOrders(@PathVariable String id) {
//        Boolean result = orderRepository.existsById(id);
//        orderRepository.deleteById(id);
//        return "{ \"success\" : " + (result ? "true" : "false") + " }";
//    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order newOrder) {
        System.out.println(newOrder);
//        Order order = new Order(newOrder.getKey(), newOrder.getOrderLines());
        Order order = new Order(newOrder.getOrderLines(), newOrder.getOrderNumber(), newOrder.getStoreNumber(), newOrder.getPurchaseOrderNumber());
        orderRepository.save(order);
        return order;
    }
}
