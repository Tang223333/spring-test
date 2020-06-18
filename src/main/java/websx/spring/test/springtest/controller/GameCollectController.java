package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.GameCollect;
import websx.spring.test.springtest.service.impl.GameCollectService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/gameCollect")
@RestController
public class GameCollectController {

    @Autowired
    private GameCollectService gameCollectService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllGameCollect(){
        List<GameCollect> allGameCollect = gameCollectService.findAllGameCollect();
        return JsonUtils.getJson(allGameCollect,allGameCollect!=null?0:1);
    }
}
