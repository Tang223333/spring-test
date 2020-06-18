package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Order;

import java.util.List;

@Repository
public interface IOrderMapper {

    @Select("select * from orders;")
    List<Order> findAllOrder();

    @Insert("insert into orders(aid,gid,type,time) values (#{aid},#{gid},#{type},#{time});")
    void saveOrder(Order order);
}
