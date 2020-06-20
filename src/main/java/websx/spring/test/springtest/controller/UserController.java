package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.impl.UserService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAllUser(){
        List<User> allUser = userService.findAllUser();
        return JsonUtils.getJson(allUser,allUser!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findByIdUser(@PathParam("id") Long id){
        User byIdUser = userService.findByIdUser(id);
        return JsonUtils.getJson(byIdUser,byIdUser!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> saveUser(@PathParam("name") String name,
                                       @PathParam("number") String number,
                                       @PathParam("address") String address,
                                       @PathParam("sex") Integer sex,
                                       @PathParam("birthday") Date birthday,
                                       @PathParam("style") String style){
        User user=User.builder().name(name).number(number).address(address).sex(sex).birthday(birthday).style(style).build();
        user = userService.saveUser(user);
        return JsonUtils.getJson(user,user!=null?0:1);
    }

    @RequestMapping("/update")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> updateUser(@PathParam("id") Long id,
                                         @PathParam("name") String name,
                                         @PathParam("number") String number,
                                         @PathParam("address") String address,
                                         @PathParam("sex") Integer sex,
                                         @PathParam("birthday") Date birthday,
                                         @PathParam("style") String style){
        User user=User.builder().id(id).name(name).number(number).address(address).sex(sex).birthday(birthday).style(style).build();
        user = userService.updateUser(user);
        return JsonUtils.getJson(user,user!=null?0:1);
    }

    @RequestMapping("/delete")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> deleteUser(@PathParam("id") Long id){
        User user = userService.deleteUser(id);
        return JsonUtils.getJson(user,user!=null?0:1);
    }

}
