package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Account;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IAccountService {

    List<Account> findAllAccount();

    List<Account> findAll2Account(Integer page,Integer limit);

    Account findByIdAccount(Long id);

    Account findByUidAccount(Long uid);

    Account findByNameAccount(String name);

    Account findByEmailAccount(String email);

    Account findByPhoneAccount(String phone);

    Account saveAccount(Account account);

    Account updateAccount(Account account);

    Account deleteAccount(Long id);
}
