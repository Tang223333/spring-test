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

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/getAll")
    public Map<String,Object>  findAllUser(){
        List<User> allUser = userService.findAllUser();
        return JsonUtils.getJson(allUser,allUser!=null?0:1);
    }

    @RequestMapping("/findById")
    public Map<String,Object> findByIdUser(@PathParam(value = "id") Long id){
        User byIdUser = userService.findByIdUser(id);
        return JsonUtils.getJson(byIdUser,byIdUser!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST )
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> updateUser(@PathParam(value = "id") Long id,
                                         @PathParam(value = "name") String name,
                                         @PathParam(value = "number") String number,
                                         @PathParam(value = "address") String address,
                                         @PathParam(value = "sex") Integer sex,
                                         @PathParam(value = "birthday") Date birthday,
                                         @PathParam(value = "gameNum") Integer gameNum,
                                         @PathParam(value = "logo") String logo,
                                         @PathParam(value = "style") String style){
        User user=User.builder().id(id).name(name).number(number).address(address).sex(sex).birthday(birthday).gameNum(gameNum)
                .logo(logo).style(style).build();
        System.out.println(user);
        user = userService.updateUser(user);
        return JsonUtils.getJson(user,user!=null?0:1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public Map<String,Object> deleteUser(@PathParam(value = "id") Long id){
        User byIdUser = userService.findByIdUser(id);
        Account byUIdAccount = accountService.findByUIdAccount(byIdUser.getId());
        byUIdAccount.setType(0);
        Account account = accountService.updateAccount(byUIdAccount);
        return JsonUtils.getJson("",account.getType()==0?0:1);
    }

}
