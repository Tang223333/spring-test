package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.News;
import websx.spring.test.springtest.service.impl.NewsService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/news")
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllNews(){
        List<News> allNews = newsService.findAllNews();
        return JsonUtils.getJson(allNews,allNews!=null?0:1);
    }
}
