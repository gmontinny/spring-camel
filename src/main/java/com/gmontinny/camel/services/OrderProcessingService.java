package com.gmontinny.camel.services;

import com.gmontinny.camel.model.Order;
import com.gmontinny.camel.model.OrderLine;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProcessingService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public Order process(final List<OrderLine> orderLines) {
        Order order = producerTemplate.requestBody(
                "direct:processOrder", orderLines, Order.class);

        return order;
    }

}
