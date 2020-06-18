package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.service.impl.NewsCollectService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/newsCollect")
@RestController
public class NewsCollectController {

    @Autowired
    private NewsCollectService newsCollectService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllNewsCollect(){
        List<NewsCollect> allNewsCollect = newsCollectService.findAllNewsCollect();
        return JsonUtils.getJson(allNewsCollect,allNewsCollect!=null?0:1);
    }
}
