package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.DisposeService;
import websx.spring.test.springtest.service.impl.GameService;
import websx.spring.test.springtest.service.impl.TypeVideoImgService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/game")
@RestController
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private TypeVideoImgService typeVideoImgService;
    @Autowired
    private DisposeService disposeService;

    @RequestMapping("/findAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAllGame(){
        List<Game> allGame = gameService.findAllGame();
        List<Dispose> disposes=new ArrayList<>();
        for (int i = 0; i < allGame.size(); i++) {
            disposes.add(disposeService.findByGidDispose(allGame.get(i).getId()));
            List<Img> byKeyImg = typeVideoImgService.findByKeyImg(allGame.get(i).getImg()+"");
            List<Video> byKeyVideo = typeVideoImgService.findByKeyVideo(allGame.get(i).getVideo()+"");
            List<Type> byKeyType = typeVideoImgService.findByKeyType(allGame.get(i).getType()+"");
            List<String> strings=new ArrayList<>();
            for (int j = 0; j < byKeyImg.size(); j++) {
                strings.add(byKeyImg.get(i).getValue());
            }
            allGame.get(i).setImg(strings);
            strings=new ArrayList<>();
            for (int j = 0; j < byKeyVideo.size(); j++) {
                strings.add(byKeyVideo.get(i).getValue());
            }
            allGame.get(i).setVideo(strings);
            strings=new ArrayList<>();
            for (int j = 0; j < byKeyType.size(); j++) {
                strings.add(byKeyType.get(i).getValue());
            }
            allGame.get(i).setType(strings);
        }
        return JsonUtils.getJson2(allGame,disposes,(allGame!=null&&disposes!=null)?0:1);
    }

    @RequestMapping("/findById")
    public Map<String,Object> findByIdGame(@PathParam("id") Long id){
        Game byIdGame = gameService.findByIdGame(id);
        return JsonUtils.getJson(byIdGame,byIdGame!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> saveGame( @PathParam("name") String name,
                                        @PathParam("money") Double money,
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
        Game game=Game.builder().name(name).money(money).describes(describes).pType(pType).developer(developer)
                .publisher(publisher).team(team).time(new Date(new java.util.Date().getTime())).grade(0).build();
        game = gameService.saveGame(game);
        Dispose dispose=Dispose.builder().gid(game.getId()).storeDown(storeDown).handlerDown(handlerDown).ramDown(ramDown).gpuDown(gpuDown)
                .systemDown(systemDown).deviceDown(deviceDown).systemUp(systemUp).handlerUp(handlerUp).ramUp(ramUp).gpuUp(gpuUp)
                .storeUp(storeUp).deviceUp(deviceUp).care(care).build();
        dispose = disposeService.saveDispose(dispose);
        return JsonUtils.getJson2(game,dispose,(game!=null&&dispose!=null)?0:1);
    }
}
