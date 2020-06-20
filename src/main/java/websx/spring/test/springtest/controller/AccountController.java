package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.UserService;
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
        List<Account> allAccount = accountService.findAllAccount();
        return JsonUtils.getJson(allAccount,allAccount!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdAccount(@PathParam("id") Long id){
        Account account = accountService.findByIdAccount(id);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/findByUid",method = RequestMethod.POST)
    public Map<String,Object> findByUidAccount(@PathParam("uid") Long uid){
        Account account = accountService.findByUidAccount(uid);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    public Map<String,Object> findByNameAccount(@PathParam("name") String name){
        Account account = accountService.findByNameAccount(name);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/findByEmail",method = RequestMethod.POST)
    public Map<String,Object> findByEmailAccount(@PathParam("email") String email){
        Account account = accountService.findByEmailAccount(email);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/findByPhone",method = RequestMethod.POST)
    public Map<String,Object> findByPhoneAccount(@PathParam("phone") String phone){
        Account account = accountService.findByPhoneAccount(phone);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveAccount(@PathParam("name") String name,
                                          @PathParam("password") String password,
                                          @PathParam("email") String email,
                                          @PathParam("phone") String phone,
                                          @PathParam("type") Integer type,
                                          @PathParam("logo") String logo,
                                          @PathParam("username") String username,
                                          @PathParam("number") String number,
                                          @PathParam("address") String address,
                                          @PathParam("sex") Integer sex,
                                          @PathParam("birthday") Date birthday,
                                          @PathParam("style") String style){
        User user=User.builder().name(username).number(number).address(address).sex(sex).birthday(birthday).style(style).build();
        user = userService.saveUser(user);
        Account account=Account.builder().uid(user.getId()).name(name).password(password).email(email)
                .phone(phone).time(new java.util.Date()).type(type!=null?type:1).logo(logo).build();
        account = accountService.saveAccount(account);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateAccount(@PathParam("id") Long id,
                                            @PathParam("name") String name,
                                            @PathParam("password") String password,
                                            @PathParam("email") String email,
                                            @PathParam("phone") String phone,
                                            @PathParam("type") Integer type,
                                            @PathParam("logo") String logo){
        Account account=accountService.findByIdAccount(id);
        account.setType(type!=null?type:account.getType());
        account.setPhone(phone);
        account.setEmail(email);
        account.setName(name);
        account.setPassword(password);
        account.setLogo(logo);
        account.setTime(new java.util.Date());
        account = accountService.updateAccount(account);
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteAccount(@PathParam("id") Long id){
        Account account=accountService.deleteAccount(id);
        User user = userService.deleteUser(account.getUid());
        return JsonUtils.getJson2(account,user,(account!=null&&user!=null)?0:1);
    }
}