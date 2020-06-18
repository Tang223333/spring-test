package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Account;

import java.util.List;

@Repository
public interface IAccountMapper {

    @Select("select * from account;")
    List<Account> findAllAccount();
}
