package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.UserService;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class LoginAndRegisterController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLoginName(@PathParam("name") String name,
                              @PathParam("email") String email,
                              @PathParam("phone") String phone,
                              @PathParam("password") String password,
                              Model model){
        Account account=null;
        if (name != null) {
            account = accountService.findByNameAccount(name);
        }
        if (email != null) {
            account = accountService.findByEmailAccount(email);
        }
        if (phone != null) {
            account = accountService.findByPhoneAccount(phone);
        }
        if (account != null) {
            if (account.getPassword().equals(password)) {
                model.addAttribute("msg","登录成功");
                if (account.getType()!=1) {
                    return "web/index_v5";
                }else {
                    return "web/index";
                }
            }else {
                model.addAttribute("msg","密码错误");
                return "web/login";
            }
        }else {
            model.addAttribute("msg","用户名或邮或箱手机号不存在");
            return "web/login";
        }
    }

    @RequestMapping(value = "/toRegister",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public String create(@PathParam("name") String  name,
                         @PathParam("password") String  password,
                         @PathParam("email") String  email,
                         @PathParam("phone") String  phone,
                         Model model){
        Account account=accountService.findByNameAccount(name);
        User user=User.builder().sex(2).birthday(null).build();
        if (account == null) {
            account=accountService.findByEmailAccount(email);
            if (account == null) {
                account=accountService.findByPhoneAccount(phone);
                if (account == null) {
                    user=userService.saveUser(user);
                    account=Account.builder().build();
                    account.setPassword(password);
                    account.setEmail(email);
                    account.setPhone(phone);
                    account.setName(name);
                    account.setUid(user.getId());
                    account.setType(1);
                    account=accountService.saveAccount(account);
                    model.addAttribute("msg","创建成功");
                    return "web/login";
                }else {
                    model.addAttribute("msg","手机号已被使用");
                    return "web/register";
                }
            }else {
                model.addAttribute("msg","邮箱已被使用");
                return "web/register";
            }
        }else {
            model.addAttribute("msg","用户名已存在");
            return "web/register";
        }
    }
}
