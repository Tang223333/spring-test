package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.ConcernForum;
import websx.spring.test.springtest.service.impl.ConcernForumService;
import websx.spring.test.springtest.utils.JsonUtils;

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
}
