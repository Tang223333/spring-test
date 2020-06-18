package websx.spring.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.mapper.IAccountMapper;
import websx.spring.test.springtest.entity.Account;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private IAccountMapper accountDao;

    @Override
    public List<Account> findAllAccount(){
        return accountDao.findAllAccount();
    }

    @Override
    public Account findByIdAccount(Long id){
        return accountDao.findByIdAccount(id);
    }

    @Override
    public Account findByUIdAccount(Long uid){
        return accountDao.findByUIdAccount(uid);
    }

    @Override
    public Account findByNameAccount(String name) {
        return accountDao.findByNameAccount(name);
    }

    @Override
    public Account findByEmailAccount(String email) {
        return accountDao.findByEmailAccount(email);
    }

    @Override
    public Account findByPhoneAccount(String phone) {
        return accountDao.findByPhoneAccount(phone);
    }

    @Override
    public Account saveAccount(Account account){
        accountDao.saveAccount(account);
        account=null;
        account=findByIdAccount(findAllAccount().get(accountDao.findAllAccount().size()-1).getId());
        return account;
    }

    @Override
    public Account updateAccount(Account account){
        accountDao.updateAccount(account);
        account=findByIdAccount(account.getId());
        return account;
    }

    @Override
    public Account deleteAccount(Long id){
        Account account=findByIdAccount(id);
        accountDao.deleteAccount(id);
        return account;
    }
}
