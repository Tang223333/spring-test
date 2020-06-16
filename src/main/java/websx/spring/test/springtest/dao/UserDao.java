package websx.spring.test.springtest.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user;")
    List<User> findAllUser();

    @Select("select * from user where id=#{id};")
    User findByIdUser(Integer id);
}
