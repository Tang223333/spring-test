package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.entity.GameMutual;
import websx.spring.test.springtest.service.impl.DisposeService;
import websx.spring.test.springtest.service.impl.GameMutualService;
import websx.spring.test.springtest.service.impl.GameService;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.sql.Date;
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

    @RequestMapping("/create")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> create(@PathParam("name") String name,
                                     @PathParam("describes") String describes,
                                     @PathParam("pType") Integer pType,
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
            game=Game.builder().name(name).describes(describes).pType(pType).publisher(publisher).developer(developer).team(team)
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
        Game game=gameService.findByIdGame(id);
        Dispose dispose=disposeService.findAllByGidDispose(game.getId());
        GameMutual gameMutual=gameMutualService.findByGidGameMutual(game.getId());
        game.setStatus(0);
        game=gameService.updateGame(game);
        return JsonUtils2.getJson3(game,dispose,gameMutual,error_code,reason);
    }
}
