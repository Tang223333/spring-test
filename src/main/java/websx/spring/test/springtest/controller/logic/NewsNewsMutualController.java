package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.News;
import websx.spring.test.springtest.entity.NewsMutual;
import websx.spring.test.springtest.service.impl.NewsMutualService;
import websx.spring.test.springtest.service.impl.NewsService;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.Map;

@RequestMapping("/NewsNM")
@RestController
public class NewsNewsMutualController extends BaseController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsMutualService newsMutualService;

    @RequestMapping("create")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("aid") Long aid,
                                     @PathParam("title") String title,
                                     @PathParam("writer") String writer,
                                     @PathParam("content") String content,
                                     @PathParam("ip") String ip){
        Long i=new Date().getTime();
        News news=newsService.findByTitleNews(title);
        NewsMutual newsMutual=NewsMutual.builder().views((double) 0).goods((double) 0).bads((double) 0).build();
        if (news != null) {
            error_code=1006;
            reason="新闻标题重复";
            news=null;
            newsMutual=null;
        }else {
            error_code=0;
            reason="请求成功";
            news=News.builder().aid(aid).title(title).writer(writer).content(content).ip(ip).status(1).time(new Date()).videos("video_"+i).imgs("img_"+i).build();
            news=newsService.saveNews(news);
            newsMutual.setNid(news.getId());
            newsMutual = newsMutualService.saveNewsMutual(newsMutual);
        }
        return JsonUtils2.getJson2(news,newsMutual,error_code,reason);
    }

    @RequestMapping("delete")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("id") Long id){
        News news= null;
        NewsMutual newsMutual= null;
        try {
            news = newsService.findByIdNews(id);
            news.setStatus(0);
            news=newsService.updateNews(news);
            newsMutual = newsMutualService.findByNidNewsMutual(news.getId());
            error_code=0;
            reason="请求成功";
        } catch (Exception e) {
            error_code=1007;
            reason="错误";
            news= null;
            newsMutual= null;
        } finally {
            return JsonUtils2.getJson2(news,newsMutual,error_code,reason);
        }
    }
}