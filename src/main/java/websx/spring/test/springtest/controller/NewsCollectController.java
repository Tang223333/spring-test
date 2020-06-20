package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.service.impl.NewsCollectService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
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

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdNewsCollect(@PathParam("id") Long id){
        NewsCollect newsCollect = newsCollectService.findByIdNewsCollect(id);
        return JsonUtils.getJson(newsCollect,newsCollect!=null?0:1);
    }

    @RequestMapping(value = "/findByNid",method = RequestMethod.POST)
    public Map<String,Object> findByNidNewsCollect(@PathParam("nid") Long nid){
        List<NewsCollect> newsCollects = newsCollectService.findByNidNewsCollect(nid);
        return JsonUtils.getJson(newsCollects,newsCollects!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidNewsCollect(@PathParam("aid") Long aid){
        List<NewsCollect> newsCollects = newsCollectService.findByAidNewsCollect(aid);
        return JsonUtils.getJson(newsCollects,newsCollects!=null?0:1);
    }

    @RequestMapping(value = "/findByNidAid",method = RequestMethod.POST)
    public Map<String,Object> findByNidAidNewsCollect(@PathParam("nid") Long nid,
                                                   @PathParam("aid") Long aid){
        NewsCollect newsCollects = newsCollectService.findByNidAidNewsCollect(nid,aid);
        return JsonUtils.getJson(newsCollects,newsCollects!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveNewsCollect(@PathParam("aid") Long aid,
                                              @PathParam("nid") Long nid){
        NewsCollect newsCollect=newsCollectService.findByNidAidNewsCollect(nid,aid);
        if (newsCollect != null) {
            newsCollect=null;
        }else {
            newsCollect=NewsCollect.builder().aid(aid).nid(nid).time(new Date()).build();
            newsCollect=newsCollectService.saveNewsCollect(newsCollect);
        }
        return JsonUtils.getJson(newsCollect,newsCollect!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteNewsCollect(@PathParam("id") Long id){
        NewsCollect newsCollect = newsCollectService.deleteNewsCollect(id);
        return JsonUtils.getJson(newsCollect,newsCollect!=null?0:1);
    }
}
