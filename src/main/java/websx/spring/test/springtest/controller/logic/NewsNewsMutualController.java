package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.News;
import websx.spring.test.springtest.entity.NewsAll;
import websx.spring.test.springtest.entity.NewsMutual;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.NewsMutualService;
import websx.spring.test.springtest.service.impl.NewsService;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.util.*;

@RequestMapping("/NewsNM")
@RestController
public class NewsNewsMutualController extends BaseController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsMutualService newsMutualService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/create")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("aid") Long aid,
                                     @PathParam("title") String title,
                                     @PathParam("writer") String writer,
                                     @PathParam("content") String content,
                                     @PathParam("ip") String ip,
                                     @PathParam("status") Integer status,
                                     @PathParam("goods") Double goods,
                                     @PathParam("bads") Double bads,
                                     @PathParam("views") Double views) throws Exception {
        System.out.println(aid);
        if (aid != null) {

        }else {
            throw new Exception();
        }
        Long i=new Date().getTime();
        News news=newsService.findByTitleNews(title);
        NewsMutual newsMutual=NewsMutual.builder().views(views!=null?views:(double)0).goods(goods!=null?goods:(double)0).bads(bads!=null?bads:(double)0).build();
        if (news != null) {
            error_code=1006;
            reason="新闻标题重复";
            news=null;
            newsMutual=null;
        }else {
            error_code=0;
            reason="请求成功";
            news=News.builder().aid(aid).title(title).writer(writer).content(content).ip(ip).status(status!=null?status:1).time(new Date()).videos("video_"+i).imgs("img_"+i).build();
            news=newsService.saveNews(news);
            newsMutual.setNid(news.getId());
            newsMutual = newsMutualService.saveNewsMutual(newsMutual);
        }
        return JsonUtils2.getJson2(news,newsMutual,error_code,reason);
    }

    @RequestMapping("/findAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAll(){
        List<News> news=newsService.findAllNews();
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
        map.put("count",newsAlls.size());
        map.put("data",newsAlls);
        return map;
    }

    @RequestMapping("/findOne")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findOne(@PathParam("nid") Long nid){
        News news=newsService.findByIdNews(nid);
        NewsMutual newsMutual=newsMutualService.findByNidNewsMutual(news.getId());
        Account account=accountService.findByIdAccount(news.getAid());
        NewsAll newsAll=new NewsAll();
        newsAll.setId(news.getId());
        newsAll.setAid(news.getAid());
        newsAll.setName(account.getName());
        newsAll.setLogo(account.getLogo());
        newsAll.setTitle(news.getTitle());
        newsAll.setWriter(news.getWriter());
        newsAll.setTime(news.getTime());
        newsAll.setContent(news.getContent());
        newsAll.setVideos(news.getVideos());
        newsAll.setImgs(news.getImgs());
        newsAll.setIp(news.getIp());
        newsAll.setStatus(news.getStatus());
        newsAll.setViews(newsMutual.getViews());
        newsAll.setGoods(newsMutual.getGoods());
        newsAll.setBads(newsMutual.getBads());
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",1);
        map.put("data",newsAll);
        return map;
    }

    @RequestMapping("/delete")
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
