package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.entity.GameMutual;
import websx.spring.test.springtest.service.impl.GameCommentService;
import websx.spring.test.springtest.service.impl.GameMutualService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
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


    @RequestMapping(value = "/findByGid",method = RequestMethod.POST)
    public Map<String,Object> findByGidGameMutual(@PathParam("gid") Long gid){
        GameMutual gameMutual = gameMutualService.findByGidGameMutual(gid);
        return JsonUtils.getJson(gameMutual,gameMutual!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> findSaveGameMutual(@PathParam("gid") Long gid){
        GameMutual gameMutual=gameMutualService.findByGidGameMutual(gid);
        if (gameMutual != null) {
            gameMutual=null;
        }else {
            gameMutual= GameMutual.builder().gid(gid).collects((double) 0).comments((double) 0)
                    .grades(0).goods((double) 0).bads((double) 0).build();
            gameMutual=gameMutualService.saveGameMutual(gameMutual);
        }
        return JsonUtils.getJson(gameMutual,gameMutual!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> findUpdateGameMutual(@PathParam("gid") Long gid,
                                                   @PathParam("collects") Double collects,
                                                   @PathParam("comments") Double comments,
                                                   @PathParam("grades") Integer grades,
                                                   @PathParam("goods") Double goods,
                                                   @PathParam("bads") Double bads){
        GameMutual gameMutual=gameMutualService.findByGidGameMutual(gid);
        if (gameMutual != null) {
            gameMutual= GameMutual.builder().gid(gid!=null?gid:gameMutual.getGid()).collects(collects!=null?collects:gameMutual.getCollects())
                    .comments(comments!=null?comments:gameMutual.getComments()).grades(grades!=null?grades:gameMutual.getGrades())
                    .goods(goods!=null?goods:gameMutual.getGoods()).bads(bads!=null?bads:gameMutual.getBads()).build();
            gameMutual=gameMutualService.updateGameMutual(gameMutual);
        }else {
            gameMutual=null;
        }
        return JsonUtils.getJson(gameMutual,gameMutual!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> findDeleteGameMutual(@PathParam("gid") Long gid){
        GameMutual gameMutual=gameMutualService.deleteGameMutual(gid);
        return JsonUtils.getJson(gameMutual,gameMutual!=null?0:1);
    }
}
