package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Repository
public interface IUserMapper {

    @Select("select * from user;")
    List<User> findAllUser();
}
