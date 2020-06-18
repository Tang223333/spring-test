package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.AccountService;
import websx.spring.test.springtest.service.UserService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllAccount(){
        List<Account> accounts=accountService.findAllAccount();
        return JsonUtils.getJson(accounts,accounts != null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdAccount(@PathParam(value = "id") Integer id){
        Account account=accountService.findByIdAccount((long)id);
        return JsonUtils.getJson(account,account != null?0:1);
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    public Map<String,Object> findByNameAccount(@PathParam(value = "name") String name){
        Account account=accountService.findByNameAccount(name);
        return JsonUtils.getJson(account,account != null?0:1);
    }

    @RequestMapping(value = "/findByEmail",method = RequestMethod.POST)
    public Map<String,Object> findByEmailAccount(@PathParam(value = "email") String email){
        Account account=accountService.findByEmailAccount(email);
        return JsonUtils.getJson(account,account != null?0:1);
    }

    @RequestMapping(value = "/findByPhone",method = RequestMethod.POST)
    public Map<String,Object> findByPhoneAccount(@PathParam(value = "phone") String phone){
        Account account=accountService.findByPhoneAccount(phone);
        return JsonUtils.getJson(account,account != null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public Map<String,Object> saveAccount(@PathParam(value = "sex") Integer sex,
                                          @PathParam(value = "birthday") Date birthday,
                                          @PathParam(value = "name") String name,
                                          @PathParam(value = "password") String password,
                                          @PathParam(value = "email") String email,
                                          @PathParam(value = "phone") String phone){
        Account account=Account.builder().name(name).password(password).email(email).phone(phone).time(new Date(new java.util.Date().getTime())).type(1).build();
        User user = userService.saveUser(User.builder().gameNum(0).sex(sex).birthday(birthday).time(new Date(new java.util.Date().getTime())).build());
        account.setUid(user.getId());
        account = accountService.saveAccount(account);
        return JsonUtils.getJson(account,account != null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateAccount(@PathParam(value = "id") Long id,
                                            @PathParam(value = "name") String name,
                                            @PathParam(value = "password") String password,
                                            @PathParam(value = "email") String email,
                                            @PathParam(value = "phone") String phone){
        Account account=accountService.findByIdAccount(id);
        account.setName(name);
        account.setPassword(password);
        account.setEmail(email);
        account.setPhone(phone);
        Account account1 = accountService.updateAccount(account);
        return JsonUtils.getJson(account1,account1 != null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public Map<String,Object> deleteAccount(@PathParam(value = "id") Long id) throws Exception {
        Account account= null;
        User user = null;
        account = accountService.deleteAccount(id);
        user = userService.deleteUser(account.getUid());
        return JsonUtils.getJson2(account,user,(account!=null&&user!=null)?0:1);
    }
}
