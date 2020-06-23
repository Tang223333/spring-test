package websx.spring.test.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JunpController {

    @RequestMapping("/login")
    public String toLogin(){
        return "web/login";
    }

    @RequestMapping("/register")
    public String toRegister(){
        return "web/register";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "web/index";
    }

}
