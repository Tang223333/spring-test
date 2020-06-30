package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.entity.UserAccount;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.UserService;
import websx.spring.test.springtest.utils.JsonUtils;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/UserAndAccount")
@RestController
public class UserAccountController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/create")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("username") String  username,
                                     @PathParam("number") String number,
                                     @PathParam("address") String address,
                                     @PathParam("sex") Integer sex,
                                     @PathParam("birthday") Date birthday,
                                     @PathParam("style") String style,
                                     @PathParam("accountName") String  accountName,
                                     @PathParam("password") String  password,
                                     @PathParam("email") String  email,
                                     @PathParam("phone") String  phone,
                                     @PathParam("type") Integer type,
                                     @PathParam("logo") String logo){
        Account account=accountService.findByNameAccount(username);
        User user=userService.findByNumberUser(number);
        if (user != null) {
            error_code=1011;
            reason="身份证号已使用";
            return JsonUtils2.getJson2(user,account,error_code,reason);
        }else {
            user=User.builder().name(username).number(number).address(address).sex(sex).birthday(birthday).style(style).build();
        }
        if (account == null) {
            account=accountService.findByEmailAccount(email);
            if (account == null) {
                account=accountService.findByPhoneAccount(phone);
                if (account == null) {
                    error_code=0;
                    reason="创建成功";
                    user=userService.saveUser(user);
                    account=Account.builder().build();
                    account.setPassword(password);
                    account.setEmail(email);
                    account.setPhone(phone);
                    account.setName(accountName);
                    account.setType(type!=null?type:1);
                    account.setTime(new java.util.Date());
                    account.setStatus(0);
                    account.setLogo(logo);
                    account.setUid(user.getId());
                    account=accountService.saveAccount(account);
                }else {
                    error_code=1003;
                    reason="手机号已被使用";
                }
            }else {
                error_code=1002;
                reason="邮箱已被使用";
            }
        }else {
            error_code=1001;
            reason="用户名已存在";
        }
        return JsonUtils2.getJson2(user,account,error_code,reason);
    }

    @RequestMapping("/update")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("id") Long  id,
                                     @PathParam("username") String  username,
                                     @PathParam("number") String number,
                                     @PathParam("address") String address,
                                     @PathParam("sex") Integer sex,
                                     @PathParam("birthday") Date birthday,
                                     @PathParam("style") String style,
                                     @PathParam("accountName") String  accountName,
                                     @PathParam("password") String  password,
                                     @PathParam("email") String  email,
                                     @PathParam("phone") String  phone,
                                     @PathParam("type") Integer type,
                                     @PathParam("logo") String logo){
        Account account=accountService.findByIdAccount(id);
        User user=userService.findByIdUser(account.getUid());
        System.out.println(user);
        user.setName(username!=null?username:user.getName());
        user.setNumber(number!=null?number:user.getNumber());
        user.setAddress(address!=null?address:user.getAddress());
        System.out.println(sex);
        user.setSex(sex!=null?sex:user.getSex());
        user.setBirthday(birthday!=null?birthday:user.getBirthday());
        user.setStyle(style!=null?style:user.getStyle());
        account.setName(accountName!=null?accountName:account.getName());
        account.setPassword(password!=null?password:account.getPassword());
        account.setEmail(email!=null?email:account.getEmail());
        account.setPhone(phone!=null?phone:account.getPhone());
        account.setType(type!=null?type:account.getType());
        account.setLogo(logo!=null?logo:account.getLogo());
        user=userService.updateUser(user);
        account=accountService.updateAccount(account);
        return JsonUtils.getJson2(user,account,(user!=null&&account!=null)?0:1);
    }

    @RequestMapping("/find")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> find(@PathParam("id") Long id){
        Account account=accountService.findByIdAccount(id);
        User user=userService.findByIdUser(account.getUid());
        if (account != null&&user!=null&&account.getUid()==user.getId()) {
            error_code=0;
            reason="请求成功";
        }
        return JsonUtils2.getJson2(user,account,error_code,reason);
    }

    @RequestMapping("/findAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAll(Integer page,Integer limit){
        List<Account> accountsall=accountService.findAllAccount();
        List<Account> accounts=accountService.findAll2Account(page,limit);
        List<UserAccount> userAccounts=new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            User user=userService.findByIdUser(accounts.get(i).getUid());
            UserAccount userAccount=new UserAccount();
            userAccount.setId(user.getId());
            userAccount.setName(user.getName());
            userAccount.setNumber(user.getNumber());
            userAccount.setAddress(user.getAddress());
            userAccount.setSex(user.getSex());
            userAccount.setBirthday(user.getBirthday());
            userAccount.setStyle(user.getStyle());
            userAccount.setAccountName(accounts.get(i).getName());
            userAccount.setPassword(accounts.get(i).getPassword());
            userAccount.setEmail(accounts.get(i).getEmail());
            userAccount.setPhone(accounts.get(i).getPhone());
            userAccount.setTime(accounts.get(i).getTime());
            userAccount.setType(accounts.get(i).getType());
            userAccount.setStatus(accounts.get(i).getStatus());
            userAccount.setLogo(accounts.get(i).getLogo());
            userAccounts.add(userAccount);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",accountsall.size());
        map.put("data",userAccounts);
        return map;
    }

    @RequestMapping("/delete")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("id") Long id){
        Account account=accountService.findByIdAccount(id);
        User user=userService.findByIdUser(account.getUid());
        if (user != null) {
            error_code=0;
            reason="用户删除成功";
            accountService.deleteAccount(account.getId());
            userService.deleteUser(id);
        }else {
            error_code=1004;
            reason="该用户不存在";
        }
        return JsonUtils2.getJson2(user,account,error_code,reason);
    }
}
