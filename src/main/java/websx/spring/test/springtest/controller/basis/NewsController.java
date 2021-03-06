package websx.spring.test.springtest.controller.basis;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.News;
import websx.spring.test.springtest.entity.NewsAll;
import websx.spring.test.springtest.entity.NewsMutual;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.NewsMutualService;
import websx.spring.test.springtest.service.impl.NewsService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.*;

@RequestMapping("/news")
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsMutualService newsMutualService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllNews(){
        List<News> allNews = newsService.findAllNews();
        return JsonUtils.getJson(allNews,allNews!=null?0:1);
    }

    @RequestMapping("/findAll2")
    public Map<String,Object> findAll2News(Integer page){
        List<News> allNews = newsService.findAllNews();
        List<News> news=newsService.findAll2News(page);
        List<NewsAll> newsAlls=new ArrayList<>();
        for (int i = 0; i < news.size(); i++) {
            NewsMutual newsMutual=newsMutualService.findByNidNewsMutual(news.get(i).getId());
            Account account=accountService.findByIdAccount(news.get(i).getAid());
            NewsAll newsAll=new NewsAll();
            newsAll.setId(news.get(i).getId());
            newsAll.setAid(news.get(i).getAid());
            newsAll.setName(account.getName());
            newsAll.setLogo(account.getLogo());
            newsAll.setTitle(news.get(i).getTitle());
            newsAll.setWriter(news.get(i).getWriter());
            newsAll.setTime(news.get(i).getTime());
            newsAll.setContent(news.get(i).getContent());
            newsAll.setVideos(news.get(i).getVideos());
            newsAll.setImgs(news.get(i).getImgs());
            newsAll.setIp(news.get(i).getIp());
            newsAll.setStatus(news.get(i).getStatus());
            newsAll.setViews(newsMutual.getViews());
            newsAll.setGoods(newsMutual.getGoods());
            newsAll.setBads(newsMutual.getBads());
            newsAlls.add(newsAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",allNews.size());
        map.put("data",newsAlls);
        return map;
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

    @RequestMapping(value = "/findByTitle",method = RequestMethod.POST)
    public Map<String,Object> findByTitleNews(@PathParam("title") String title){
        News byAidNews = newsService.findByTitleNews(title);
        return JsonUtils.getJson(byAidNews,byAidNews!=null?0:1);
    }

    @RequestMapping(value = "/findByLikeTitle",method = RequestMethod.POST)
    public Map<String,Object> findByLikeTitleNews(@PathParam("title") String title){
        title="%"+title+"%";
        List<News> byAidNews = newsService.findByLikeTitleNews(title);
        return JsonUtils.getJson(byAidNews,byAidNews!=null?0:1);
    }

    @RequestMapping(value = "/findByAidTitle",method = RequestMethod.POST)
    public Map<String,Object> findByAidTitleNews(@PathParam("aid") Long aid,
                                                 @PathParam("title") String title){
        News byAidNews = newsService.findByAidTitleNews(aid,title);
        return JsonUtils.getJson(byAidNews,byAidNews!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveNews(@PathParam("aid") Long aid,
                                       @PathParam("title") String title,
                                       @PathParam("writer") String writer,
                                       @PathParam("content") String content,
                                       @PathParam("ip") String ip){
        Long i=new Date().getTime();
        News news=newsService.findByAidTitleNews(aid,title);
        if (news != null) {
            news=null;
        }else {
            news=News.builder().aid(aid).title(title).writer(writer).content(content).ip(ip)
                    .imgs("img_"+i).videos("video_"+i).time(new Date()).status(1).build();
            news = newsService.saveNews(news);
        }
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
            news=News.builder().id(news.getId()).aid(aid!=null?aid:news.getAid()).title(title!=null?title:news.getTitle())
                    .writer(writer!=null?writer:news.getWriter()).time(news.getTime()).videos(news.getVideos()).imgs(news.getImgs()).status(news.getStatus()).content(content!=null?content:news.getContent())
                    .ip(ip!=null?ip:news.getIp()).build();
            news = newsService.updateNews(news);
        }else {
            news=null;
        }
        return JsonUtils.getJson(news,news!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteNews(@PathParam("id") Long id){
        News news=newsService.deleteNews(id);
        return JsonUtils.getJson(news,news!=null?0:1);
    }
}
