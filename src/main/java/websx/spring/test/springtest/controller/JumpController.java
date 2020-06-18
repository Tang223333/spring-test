package websx.spring.test.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @GetMapping("/showIndex")
    public String showPage(){
//        Model model
//        model.addAttribute("msg","Thymeleaf");
        return "one";
    }

    @RequestMapping("/this")
    public String showPa(){
        return "index";
    }

    @RequestMapping("/show")
    public String showPageStatic(){
        return "index2.html";
    }
}
