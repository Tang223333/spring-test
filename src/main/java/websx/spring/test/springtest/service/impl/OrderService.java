package websx.spring.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.mapper.IOrderMapper;
import websx.spring.test.springtest.entity.Order;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    public IOrderMapper iOrderDao;

    @Override
    public List<Order> findAllOrder(){
       return iOrderDao.findAllOrder();
    }

    @Override
    public Order saveOrder(Order order){
        iOrderDao.saveOrder(order);
        Order order1=iOrderDao.findAllOrder().get(iOrderDao.findAllOrder().size()-1);
        return order1;
    }
}
