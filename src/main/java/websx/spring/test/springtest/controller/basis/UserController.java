package websx.spring.test.springtest.controller.basis;

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

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findByNameUser(@PathParam("name") String name){
        System.out.println(name);
        List<User> byIdUser = userService.findByNameUser(name);
        return JsonUtils.getJson(byIdUser,byIdUser!=null?0:1);
    }

    @RequestMapping(value = "/findByNumber",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findByNumberUser(@PathParam("number") String number){
        User byIdUser = userService.findByNumberUser(number);
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
        User user=userService.findByNumberUser(number);
        if (user != null) {
            user=null;
        }else {
            user=User.builder().name(name).number(number).address(address).sex(sex).birthday(birthday).style(style).build();
            user = userService.saveUser(user);
        }
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
        User user=null;
        if (number.equals("")) {
            user=userService.findByIdUser(id);
        }else {
            user=userService.findByNumberUser(number);
        }
        if (user != null&&user.getId()==id) {
            user=User.builder().id(user.getId()).name(name!=null?name:user.getName()).number(number!=null?number:user.getNumber())
                    .address(address!=null?address:user.getAddress()).sex(sex!=null?sex:user.getSex())
                    .birthday(birthday!=null?birthday:user.getBirthday()).style(style!=null?style:user.getStyle()).build();
            user = userService.updateUser(user);
        }
        return JsonUtils.getJson(user,user!=null?0:1);
    }

    @RequestMapping("/delete")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> deleteUser(@PathParam("id") Long id){
        User user = userService.deleteUser(id);
        return JsonUtils.getJson(user,user!=null?0:1);
    }

}
