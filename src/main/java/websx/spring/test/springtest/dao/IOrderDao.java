package websx.spring.test.springtest.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Order;

import java.util.List;

@Repository
public interface IOrderDao {

    @Select("select * from orders;")
    List<Order> findAllOrder();

    @Insert("insert into orders(aid,gid,type,time) values (#{aid},#{gid},#{type},#{time});")
    void saveOrder(Order order);
}
