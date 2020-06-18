package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.mapper.IAccountMapper;
import websx.spring.test.springtest.service.IAccountService;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountMapper iAccountMapper;

    @Override
    public List<Account> findAllAccount() {
        return iAccountMapper.findAllAccount();
    }
}
