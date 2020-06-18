package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.service.impl.ImgService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/img")
@RestController
public class ImgController {

    @Autowired
    private ImgService imgService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllVideo(){
        List<Img> allImg = imgService.findAllImg();
        return JsonUtils.getJson(allImg,allImg!=null?0:1);
    }
}
