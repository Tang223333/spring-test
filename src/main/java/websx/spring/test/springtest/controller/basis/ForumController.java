package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
public class ForumController{

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

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    public Map<String,Object> findByNameForm(@PathParam("name") String name){
        Forum byIdForum = forumService.findByNameForum(name);
        return JsonUtils.getJson(byIdForum,byIdForum!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveForum(@PathParam("aid") Long aid,
                                        @PathParam("name") String name,
                                        @PathParam("logo") String logo,
                                        @PathParam("ip") String ip,
                                        @PathParam("concerns") Integer concerns,
                                        @PathParam("invitations") Integer invitations,
                                        @PathParam("views") Integer views){
        System.out.println(logo);
        Forum forum=forumService.findByNameForum(name);
        if (forum != null) {
            forum=null;
        }else {
            forum=Forum.builder().aid(aid).concerns(concerns!=null?concerns:0).invitations(invitations!=null?invitations:0)
                    .views(views!=null?views:0).name(name).logo(logo).ip(ip).build();
            forum = forumService.saveForum(forum);
        }
        return JsonUtils.getJson(forum,forum!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> updateForum(@PathParam("id") Long id,
                                          @PathParam("aid") Long aid,
                                          @PathParam("concerns") Integer concerns,
                                          @PathParam("invitations") Integer invitations,
                                          @PathParam("views") Integer views,
                                          @PathParam("name") String name,
                                          @PathParam("logo") String logo,
                                          @PathParam("ip") String ip) throws Exception {
        Forum forum=forumService.findByIdForum(id);
        if (forum != null) {
            forum=Forum.builder().id(forum.getId()).aid(aid!=null?aid:forum.getAid()).concerns(concerns!=null?concerns:forum.getConcerns())
                    .invitations(invitations!=null?invitations:forum.getInvitations()).views(views!=null?views:forum.getViews())
                    .name(name!=null?name:forum.getName()).logo(logo!=null?logo:forum.getLogo()).ip(ip!=null?ip:forum.getIp()).build();
            forum=forumService.updateForum(forum);
        }else {
            forum=null;
        }
        return JsonUtils.getJson(forum,forum!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteForum(@PathParam("id") Long id){
        Forum forum=forumService.deleteForum(id);
        return JsonUtils.getJson(forum,forum!=null?0:1);
    }
}
