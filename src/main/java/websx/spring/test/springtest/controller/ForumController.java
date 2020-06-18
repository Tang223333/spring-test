package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Forum;
import websx.spring.test.springtest.service.impl.ForumService;
import websx.spring.test.springtest.utils.JsonUtils;

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
}
