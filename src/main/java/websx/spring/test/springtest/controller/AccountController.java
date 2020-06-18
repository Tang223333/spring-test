package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    private Map<String,Object> findAllAccount(){
        List<Account> allAccount = accountService.findAllAccount();
        return JsonUtils.getJson(allAccount,allAccount!=null?0:1);
    }
}
