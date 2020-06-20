package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.ConcernForum;
import websx.spring.test.springtest.service.impl.ConcernForumService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/concernForum")
@RestController
public class ConcernForumController {
    @Autowired
    private ConcernForumService concernForumService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllConcernForum(){
        List<ConcernForum> allConcernForum = concernForumService.findAllConcernForum();
        return JsonUtils.getJson(allConcernForum,allConcernForum!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdConcernForum(@PathParam("id") Long id){
        ConcernForum byIdConcernForum = concernForumService.findByIdConcernForum(id);
        return JsonUtils.getJson(byIdConcernForum,byIdConcernForum!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidConcernForum(@PathParam("aid") Long aid){
        List<ConcernForum> byAidGidConcernForum = concernForumService.findByAidGidConcernForum(aid);
        return JsonUtils.getJson(byAidGidConcernForum,byAidGidConcernForum!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveConcernForum(@PathParam("aid") Long aid,
                                               @PathParam("gid") Long gid){
        ConcernForum concernForum=ConcernForum.builder().aid(aid).gid(gid).time(new Date()).build();
        concernForum=concernForumService.saveConcernForum(concernForum);
        return JsonUtils.getJson(concernForum,concernForum!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteConcernForum(@PathParam("id") Long id){
        ConcernForum byIdConcernForum = concernForumService.deleteConcernForum(id);
        return JsonUtils.getJson(byIdConcernForum,byIdConcernForum!=null?0:1);
    }
}