package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Order;
import websx.spring.test.springtest.service.OrderService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getmap")
    public Map<String,Object> getOrderMap(){
        List<Order> allOrder = orderService.findAllOrder();
        return JsonUtils.getJson(allOrder,allOrder!=null?0:1);
    }

    @RequestMapping("/save")
    public Map<String,Object> saveOrder(){
        Order order = null;
        order = orderService.saveOrder(Order.builder().aid((long) 1).gid((long) 1).time(new Date(new java.util.Date().getTime())).type(2).build());
        return JsonUtils.getJson(order,order!=null?0:1);
    }
}
