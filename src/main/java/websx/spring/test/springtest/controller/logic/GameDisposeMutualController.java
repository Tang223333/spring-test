package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.*;
import websx.spring.test.springtest.utils.JsonUtils;
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
    @Autowired
    private GameCommentService gameCommentService;
    @Autowired
    private ImgService imgService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("/find20")
    public Map<String,Object> find20(){
        List<Game> games=gameService.find20Game();
        for (int i = 0; i < games.size(); i++) {
            List<Img> imgs=imgService.findByKeyImg(games.get(i).getImgs()+"");
            if (imgs.size()>0&&imgs!=null) {
                games.get(i).setImgs(imgs.get(0).getValue());
            }else {
                games.get(i).setImgs("");
            }
        }
        return JsonUtils.getJson(games,(games!=null)?0:1);
    }

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

    @RequestMapping("/findOne")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findOne(Long id){
        Game games=gameService.findByIdGame(id);
        GameAll gameAll=new GameAll();
        GameMutual gameMutual=gameMutualService.findByGidGameMutual(games.getId());
        Dispose dispose=disposeService.findAllByGidDispose(games.getId());
        List<Img> imgs=imgService.findByKeyImg(games.getImgs()+"");
        List<Video> videos=videoService.findByKeyVideo(games.getVideos()+"");
        List<Type> types=typeService.findByKeyType(games.getTypes()+"");
        gameAll.setId(games.getId());
        gameAll.setName(games.getName());
        gameAll.setDescribes(games.getDescribes());
        gameAll.setDeveloper(games.getDeveloper());
        gameAll.setPublisher(games.getPublisher());
        gameAll.setTeam(games.getTeam());
        gameAll.setTime(games.getTime());
        gameAll.setStatus(games.getStatus());
        gameAll.setVideos(videos);
        gameAll.setImgs(imgs);
        gameAll.setTypes(types);
        gameAll.setPType(games.getPType());
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
        Map<String,Object> map=new HashMap<>();
        List<GameComment> gameComments=gameCommentService.findByGidGameComment(id);
        List<GameCommentAll> gameCommentAlls=new ArrayList<>();
        for (int i = 0; i < gameComments.size(); i++) {
            GameCommentAll gameCommentAll=new GameCommentAll();
            gameCommentAll.setId(gameComments.get(i).getId());
            gameCommentAll.setGid(gameAll.getId());
            gameCommentAll.setGameName(gameAll.getName());
            Account account=accountService.findByIdAccount(gameComments.get(i).getAid());
            if (account!=null){
                gameCommentAll.setAid(account.getId());
                gameCommentAll.setAccountName(account.getName());
                gameCommentAll.setAccountLogo(account.getLogo());
            }
            gameCommentAll.setContent(gameComments.get(i).getContent());
            gameCommentAll.setGoodOrBad(gameComments.get(i).getGoodOrBad());
            gameCommentAll.setGrade(gameComments.get(i).getGrade());
            gameCommentAll.setIp(gameComments.get(i).getIp());
            gameCommentAll.setTime(gameComments.get(i).getTime());
            gameCommentAlls.add(gameCommentAll);
        }
        map.put("code",0);
        map.put("msg","");
        map.put("count",gameCommentAlls);
        map.put("data",gameAll);
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
