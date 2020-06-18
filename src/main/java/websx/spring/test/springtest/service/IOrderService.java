package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Order;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IOrderService {

    List<Order> findAllOrder();

    Order saveOrder(Order order);
}
