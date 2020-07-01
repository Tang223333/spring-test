package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.UserService;
import websx.spring.test.springtest.utils.JsonUtils;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/pasUp",method = RequestMethod.POST)
    public Map<String,Object>  pasUp(@PathParam("id") Long id,
                                     @PathParam("oldPas") String oldPas,
                                     @PathParam("newPas") String newPas,
                                     @PathParam("newPas2") String newPas2){
        Account account=accountService.findByIdAccount(id);
        if (oldPas.equals("")||newPas.equals("")||newPas2.equals("")) {
            return JsonUtils2.getJson(account,1,"晴天写完数据");
        }else {
            if (newPas.equals(newPas2)){
                if (account.getPassword().equals(oldPas)){
                    account.setPassword(newPas2);
                    account=accountService.updateAccount(account);
                    return JsonUtils2.getJson(account,0,"密码修改成功");
                }else {
                    return JsonUtils2.getJson(account,1,"旧密码错误");
                }
            }else {
                return JsonUtils2.getJson(account,1,"两次密码不同");
            }
        }
    }

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
    public Map<String,Object> saveAccount(@PathParam("uid")Long uid,
                                          @PathParam("name") String name,
                                          @PathParam("password") String password,
                                          @PathParam("email") String email,
                                          @PathParam("phone") String phone,
                                          @PathParam("type") Integer type,
                                          @PathParam("logo") String logo){
        Account account=accountService.findByUidAccount(uid);
        if (account == null) {
            account=accountService.findByNameAccount(name);
        }
        if (account == null) {
            account=accountService.findByEmailAccount(email);
        }
        if (account == null) {
            account=accountService.findByPhoneAccount(phone);
        }
        if (account != null) {
            account=null;
        }else {
            account=Account.builder().uid(uid).name(name!=null?name:account.getName()).status(0).password(password!=null?password:account.getPassword())
                    .email(email!=null?email:account.getEmail()).phone(phone!=null?phone:account.getPhone())
                    .time(new java.util.Date()).type(type!=null?type:1).logo(logo!=null?logo:account.getLogo()).build();
            account = accountService.saveAccount(account);
        }
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateAccount(@PathParam("id") Long id,
                                            @PathParam("uid") Long uid,
                                            @PathParam("name") String name,
                                            @PathParam("password") String password,
                                            @PathParam("email") String email,
                                            @PathParam("phone") String phone,
                                            @PathParam("type") Integer type,
                                            @PathParam("status") Integer status,
                                            @PathParam("logo") String logo){
        Account account=accountService.findByIdAccount(id);
        if (account != null) {
            account.setType(type!=null?type:account.getType());
            account.setStatus(status!=null?status:account.getStatus());
            account.setPhone(phone!=null?phone:account.getPhone());
            account.setEmail(email!=null?phone:account.getEmail());
            account.setName(name!=null?phone:account.getName());
            account.setPassword(password!=null?phone:account.getPassword());
            account.setLogo(logo!=null?phone:account.getLogo());
            account.setTime(new java.util.Date());
            account = accountService.updateAccount(account);
        }else {
           account=null;
        }
        return JsonUtils.getJson(account,account!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteAccount(@PathParam("id") Long id){
        Account account=accountService.deleteAccount(id);
        return JsonUtils.getJson(account,(account!=null)?0:1);
    }
}
