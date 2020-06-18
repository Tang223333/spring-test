package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.entity.GameMutual;
import websx.spring.test.springtest.service.impl.GameCommentService;
import websx.spring.test.springtest.service.impl.GameMutualService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/gameMutual")
@RestController
public class GameMutualController {

    @Autowired
    private GameMutualService gameMutualService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllGameMutual(){
        List<GameMutual> allGameMutual = gameMutualService.findAllGameMutual();
        return JsonUtils.getJson(allGameMutual,allGameMutual!=null?0:1);
    }
}
