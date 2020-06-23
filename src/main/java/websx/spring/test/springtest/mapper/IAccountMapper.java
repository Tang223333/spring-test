package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Account;

import java.util.List;

@Repository
public interface IAccountMapper {

    @Select("select * from account;")
    List<Account> findAllAccount();

    @Select("select * from account where id=#{id};")
    Account findByIdAccount(Long id);

    @Select("select * from account where uid=#{uid};")
    Account findByUidAccount(Long uid);

    @Select("select * from account where name=#{name};")
    Account findByNameAccount(String name);

    @Select("select * from account where email=#{email};")
    Account findByEmailAccount(String email);

    @Select("select * from account where phone=#{phone};")
    Account findByPhoneAccount(String phone);

    @Insert("insert into account(uid,name,password,email,phone,time,type,logo,status) values" +
            "(#{uid},#{name},#{password},#{email},#{phone},#{time},#{type},#{logo},#{status});")
    void saveAccount(Account account);

    @Update("update account set name=#{name},password=#{password},email=#{email},phone=#{phone},time=#{time},type=#{type},logo=#{logo},status=#{status} where id=#{id};")
    void updateAccount(Account account);

    @Delete("delete from account where id=#{id};")
    void deleteAccount(Long id);

}
