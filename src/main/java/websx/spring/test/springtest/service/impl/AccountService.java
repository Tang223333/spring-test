package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.mapper.IAccountMapper;
import websx.spring.test.springtest.mapper.IUserMapper;
import websx.spring.test.springtest.service.IAccountService;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountMapper iAccountMapper;
    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public List<Account> findAllAccount() {
        return iAccountMapper.findAllAccount();
    }

    @Override
    public Account findByIdAccount(Long id) {
        return iAccountMapper.findByIdAccount(id);
    }

    @Override
    public Account findByUidAccount(Long uid) {
        return iAccountMapper.findByUidAccount(uid);
    }

    @Override
    public Account findByNameAccount(String name) {
        return iAccountMapper.findByNameAccount(name);
    }

    @Override
    public Account findByEmailAccount(String email) {
        return iAccountMapper.findByEmailAccount(email);
    }

    @Override
    public Account findByPhoneAccount(String phone) {
        return iAccountMapper.findByPhoneAccount(phone);
    }

    @Override
    public Account saveAccount(Account account) {
        iAccountMapper.saveAccount(account);
        account=iAccountMapper.findAllAccount().get(iAccountMapper.findAllAccount().size()-1);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        iAccountMapper.updateAccount(account);
        account=findByIdAccount(account.getId());
        return account;
    }

    @Override
    public Account deleteAccount(Long id) {
        Account account=findByIdAccount(id);
        iAccountMapper.deleteAccount(id);
        return account;
    }

}
