package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.entity.GameAll;
import websx.spring.test.springtest.entity.GameMutual;
import websx.spring.test.springtest.service.impl.DisposeService;
import websx.spring.test.springtest.service.impl.GameMutualService;
import websx.spring.test.springtest.service.impl.GameService;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/GameDM")
@RestController
public class GameDisposeMutualController extends BaseController {

    @Autowired
    private GameService gameService;
    @Autowired
    private DisposeService disposeService;
    @Autowired
    private GameMutualService gameMutualService;

    @RequestMapping("/findAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAll(){
        List<Game> games=gameService.findAllGame();
        List<GameAll> gameAlls=new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            GameMutual gameMutual=gameMutualService.findByGidGameMutual(games.get(i).getId());
            Dispose dispose=disposeService.findAllByGidDispose(games.get(i).getId());
            GameAll gameAll=new GameAll();
            gameAll.setId(games.get(i).getId());
            gameAll.setName(games.get(i).getName());
            gameAll.setDescribes(games.get(i).getDescribes());
            gameAll.setDeveloper(games.get(i).getDeveloper());
            gameAll.setPublisher(games.get(i).getPublisher());
            gameAll.setTeam(games.get(i).getTeam());
            gameAll.setTime(games.get(i).getTime());
            gameAll.setStatus(games.get(i).getStatus());
            gameAll.setVideos(games.get(i).getVideos());
            gameAll.setImgs(games.get(i).getImgs());
            gameAll.setTypes(games.get(i).getTypes());
            gameAll.setPType(games.get(i).getPType());
            gameAll.setCollects(gameMutual.getCollects());
            gameAll.setComments(gameMutual.getComments());
            gameAll.setGoods(gameMutual.getGoods());
            gameAll.setBads(gameMutual.getBads());
            gameAll.setGrades(gameMutual.getGrades());
            gameAll.setSystemDown(dispose.getSystemDown());
            gameAll.setHandlerDown(dispose.getHandlerDown());
            gameAll.setRamDown(dispose.getRamDown());
            gameAll.setGpuDown(dispose.getGpuDown());
            gameAll.setStoreDown(dispose.getStoreDown());
            gameAll.setDeviceDown(dispose.getDeviceDown());
            gameAll.setSystemUp(dispose.getSystemUp());
            gameAll.setHandlerUp(dispose.getHandlerUp());
            gameAll.setRamUp(dispose.getRamUp());
            gameAll.setGpuUp(dispose.getGpuUp());
            gameAll.setStoreUp(dispose.getStoreUp());
            gameAll.setDeviceUp(dispose.getDeviceUp());
            gameAll.setCare(dispose.getCare());
            gameAlls.add(gameAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",gameAlls.size());
        map.put("data",gameAlls);
        return map;
    }

    @RequestMapping("/create")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("name") String name,
                                     @PathParam("describes") String describes,
                                     @PathParam("ptype") Integer pType,
                                     @PathParam("developer") String developer,
                                     @PathParam("publisher") String publisher,
                                     @PathParam("team") String team,
                                     @PathParam("systemDown") String systemDown,
                                     @PathParam("handlerDown") String handlerDown,
                                     @PathParam("ramDown") String ramDown,
                                     @PathParam("gpuDown") String gpuDown,
                                     @PathParam("storeDown") String storeDown,
                                     @PathParam("deviceDown") String deviceDown,
                                     @PathParam("systemUp") String systemUp,
                                     @PathParam("handlerUp") String handlerUp,
                                     @PathParam("ramUp") String ramUp,
                                     @PathParam("gpuUp") String gpuUp,
                                     @PathParam("storeUp") String storeUp,
                                     @PathParam("deviceUp") String deviceUp,
                                     @PathParam("care") String care){
        Long i=new java.util.Date().getTime();
        Game game=gameService.findByNameGame(name);
        Dispose dispose=Dispose.builder().systemDown(systemDown).handlerDown(handlerDown).ramDown(ramDown)
                .gpuDown(gpuDown).storeDown(storeDown).deviceDown(deviceDown).systemUp(systemUp)
                .handlerUp(handlerUp).ramUp(ramUp).gpuUp(gpuUp).storeUp(storeUp)
                .deviceUp(deviceUp).care(care).build();
        GameMutual gameMutual=GameMutual.builder().bads((double) 0).goods((double) 0).grades(0).comments((double) 0).collects((double) 0).build();
        if (game != null) {
            error_code=1005;
            reason="游戏名重复";
            game=null;
            dispose=null;
            gameMutual=null;
        }else {
            error_code=0;
            reason="请求成功";
            game=Game.builder().name(name).describes(describes).status(1).pType(1).publisher(publisher).developer(developer).team(team)
                    .time(new Date(new java.util.Date().getTime())).videos("video_"+i).imgs("img_"+i).types("type_"+i).status(1).build();
            game=gameService.saveGame(game);
            dispose.setGid(game.getId());
            gameMutual.setGid(game.getId());
            dispose=disposeService.saveDispose(dispose);
            gameMutual=gameMutualService.saveGameMutual(gameMutual);
        }
        return JsonUtils2.getJson3(game,dispose,gameMutual,error_code,reason);
    }

    @RequestMapping("/delete")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("id") Long id){
        System.out.println(id);
        Game game=gameService.findByIdGame(id);
        Dispose dispose=disposeService.findAllByGidDispose(game.getId());
        GameMutual gameMutual=gameMutualService.findByGidGameMutual(game.getId());
        game.setStatus(0);
        game=gameService.updateGame(game);
        return JsonUtils2.getJson3(game,dispose,gameMutual,error_code,reason);
    }
}
