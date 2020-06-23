package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.UserService;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.sql.Date;
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
    public Map<String,Object> create(@PathParam("name") String  name,
                                     @PathParam("password") String  password,
                                     @PathParam("email") String  email,
                                     @PathParam("phone") String  phone){
        Account account=accountService.findByNameAccount(name);
        User user=User.builder().sex(2).birthday(null).build();
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
                    account.setName(name);
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
