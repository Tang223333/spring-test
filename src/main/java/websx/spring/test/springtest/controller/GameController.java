package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.GameService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/game")
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllGame(){
        List<Game> allGame = gameService.findAllGame();
        return JsonUtils.getJson(allGame,allGame!=null?0:1);
    }
}
