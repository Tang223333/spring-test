package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Repository
public interface IUserMapper {

    @Select("select * from user;")
    List<User> findAllUser();

    @Select("select * from user where id=#{id};")
    User findByIdUser(Long id);

    @Insert("insert into user(name,number,address,sex,birthday,gameNum,logo,style,time) values(#{name},#{number},#{address},#{sex},#{birthday},#{gameNum},#{logo},#{style},#{time});")
    void saveUser(User user);

    @Delete("delete from user where id=#{id};")
    void deleteUser(Long id);

    @Update("update user set name=#{name},number=#{number},address=#{address},sex=#{sex},birthday=#{birthday},gameNum=#{gameNum},logo=#{logo},style=#{style} where id=#{id};")
    void updateUser(User user);
}
