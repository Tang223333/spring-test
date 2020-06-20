package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Forum;
import websx.spring.test.springtest.service.impl.ForumService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/forum")
@RestController
public class ForumController {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllForum(){
        List<Forum> allForum = forumService.findAllForum();
        return JsonUtils.getJson(allForum,allForum!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdForm(@PathParam("id") Long id){
        Forum byIdForum = forumService.findByIdForum(id);
        return JsonUtils.getJson(byIdForum,byIdForum!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidForum(@PathParam("aid") Long aid){
        List<Forum> forums = forumService.findByAidForum(aid);
        return JsonUtils.getJson(forums,forums!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveForum(@PathParam("aid") Long aid,
                                        @PathParam("concerns") Integer concerns,
                                        @PathParam("invitations") Integer invitations,
                                        @PathParam("views") Integer views,
                                        @PathParam("name") String name,
                                        @PathParam("logo") String logo,
                                        @PathParam("ip") String ip){
        Forum forum=Forum.builder().aid(aid).concerns(concerns).invitations(invitations).views(views).name(name).logo(logo).ip(ip).build();
        forum = forumService.saveForum(forum);
        return JsonUtils.getJson(forum,forum!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateForum(@PathParam("id") Long id,
                                          @PathParam("aid") Long aid,
                                          @PathParam("concerns") Integer concerns,
                                          @PathParam("invitations") Integer invitations,
                                          @PathParam("views") Integer views,
                                          @PathParam("name") String name,
                                          @PathParam("logo") String logo,
                                          @PathParam("ip") String ip){
        Forum forum=forumService.findByIdForum(id);
        if (forum != null) {
            forum=Forum.builder().id(id).aid(aid).concerns(concerns).invitations(invitations).views(views).name(name).logo(logo).ip(ip).build();
            return JsonUtils.getJson(forum,forum!=null?0:1);
        }else {
            return JsonUtils.getJson(forum,1);
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteForum(@PathParam("id") Long id){
        Forum forum=forumService.deleteForum(id);
        return JsonUtils.getJson(forum,forum!=null?0:1);
    }
}
