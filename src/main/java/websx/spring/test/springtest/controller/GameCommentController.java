package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.service.impl.GameCommentService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/gameComment")
@RestController
public class GameCommentController {

    @Autowired
    private GameCommentService gameCommentService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllGameComment(){
        List<GameComment> allGameMutual = gameCommentService.findAllGameComment();
        return JsonUtils.getJson(allGameMutual,allGameMutual!=null?0:1);
    }
}
