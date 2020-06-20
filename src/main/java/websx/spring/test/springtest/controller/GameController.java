package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.*;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.sql.Date;
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

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdGame(@PathParam("id") Long id){
        Game byId = gameService.findByIdGame(id);
        return JsonUtils.getJson(byId,(byId!=null)?0:1);
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    public Map<String,Object> findByNameGame(@PathParam("name") String name){
        name="%"+name+"%";
        List<Game> games = gameService.findByNameGame(name);
        return JsonUtils.getJson(games,(games!=null)?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveGame(@PathParam("name") String name,
                                       @PathParam("describes") String describes,
                                       @PathParam("pType") Integer pType,
                                       @PathParam("developer") String developer,
                                       @PathParam("publisher") String publisher,
                                       @PathParam("team") String team,
                                       @PathParam("time") Date time){
        Long i=new java.util.Date().getTime();
        Game game=Game.builder().name(name).describes(describes).videos("video_"+i).imgs("img_"+i).types("type_"+i).pType(1).developer(developer)
                .publisher(publisher).team(team).time(time).build();
        game=gameService.saveGame(game);
        return JsonUtils.getJson(game,(game!=null)?0:1);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Map<String,Object> updateGame(@PathParam("id") Long id,
                                         @PathParam("name") String name,
                                         @PathParam("describes") String describes,
                                         @PathParam("pType") Integer pType,
                                         @PathParam("developer") String developer,
                                         @PathParam("publisher") String publisher,
                                         @PathParam("team") String team,
                                         @PathParam("time") Date time){
        Game game=gameService.findByIdGame(id);
        if (game != null) {
            game=Game.builder().id(game.getId()).name(name).describes(describes).pType(pType).developer(developer).publisher(publisher).team(team).time(time).build();
            game=gameService.updateGame(game);
            return JsonUtils.getJson(game,(game!=null)?0:1);
        }else {
            return JsonUtils.getJson(game,1);
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteGame(@PathParam("id") Long id){
        Game game=gameService.deleteGame(id);
        return JsonUtils.getJson(game,(game!=null)?0:1);
    }
}
