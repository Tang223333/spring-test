package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.News;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.service.impl.ImgService;
import websx.spring.test.springtest.service.impl.NewsService;
import websx.spring.test.springtest.service.impl.VideoService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdNews(@PathParam("id") Long id){
        News byIdNews = newsService.findByIdNews(id);
        return JsonUtils.getJson(byIdNews,byIdNews!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidNews(@PathParam("aid") Long aid){
        List<News> byAidNews = newsService.findByAidNews(aid);
        return JsonUtils.getJson(byAidNews,byAidNews!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveNews(@PathParam("aid") Long aid,
                                       @PathParam("title") String title,
                                       @PathParam("writer") String writer,
                                       @PathParam("content") String content,
                                       @PathParam("ip") String ip){
        Long i=new Date().getTime();
        News news=News.builder().aid(aid).title(title).writer(writer).content(content).ip(ip).imgs("img_"+i).videos("video_"+i).time(new Date()).build();
        news = newsService.saveNews(news);
        return JsonUtils.getJson(news,news!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateNews(@PathParam("id") Long id,
                                         @PathParam("aid") Long aid,
                                         @PathParam("title") String title,
                                         @PathParam("writer") String writer,
                                         @PathParam("content") String content,
                                         @PathParam("ip") String ip){
        News news=newsService.findByIdNews(id);
        if (news != null) {
            if (aid != null) {
                news.setAid(aid);
            }
            if (title != null) {
                news.setTitle(title);
            }
            if (writer != null) {
                news.setWriter(writer);
            }
            if (content != null) {
                news.setContent(content);
            }
            if (ip != null) {
                news.setIp(ip);
            }
        }
        news = newsService.updateNews(news);
        return JsonUtils.getJson(news,news!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteNews(@PathParam("id") Long id){
        News news=newsService.deleteNews(id);
        return JsonUtils.getJson(news,news!=null?0:1);
    }
}
