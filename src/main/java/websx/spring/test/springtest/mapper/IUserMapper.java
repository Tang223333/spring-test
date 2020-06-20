package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Repository
public interface IUserMapper {

    @Select("select * from user;")
    List<User> findAllUser();

    @Select("select * from user where id=#{id};")
    User findByIdUser(Long id);

    @Select("select * from user where name=#{name};")
    User findByNameUser(String name);

    @Select("select * from user where number=#{number};")
    User findByNumberUser(String number);

    @Insert("insert into user(name,number,address,sex,birthday,style) values(#{name},#{number},#{address},#{sex},#{birthday},#{style});")
    void saveUser(User user);

    @Update("update user set name=#{name},number=#{number},address=#{address},sex=#{sex},birthday=#{birthday},style=#{style} where id=#{id};")
    void update(User user);

    @Delete("delete from user where id=#{id};")
    void delete(Long id);

}
