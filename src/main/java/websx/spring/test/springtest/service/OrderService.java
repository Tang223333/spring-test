package websx.spring.test.springtest.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.dao.IOrderDao;
import websx.spring.test.springtest.entity.Order;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    public IOrderDao iOrderDao;

    public List<Order> findAllOrder(){
       return iOrderDao.findAllOrder();
    }

    public Order saveOrder(Order order){
        iOrderDao.saveOrder(order);
        Order order1=iOrderDao.findAllOrder().get(iOrderDao.findAllOrder().size()-1);
        return order1;
    }
}
