package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.ConcernForum;
import websx.spring.test.springtest.entity.GameCollect;
import websx.spring.test.springtest.service.impl.GameCollectService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
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

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdGameCollect(@PathParam("id") Long id){
        GameCollect gameCollect = gameCollectService.findByIdGameCollect(id);
        return JsonUtils.getJson(gameCollect,gameCollect!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidGameCollect(@PathParam("aid") Long aid){
        List<GameCollect> gameCollects = gameCollectService.findByAidGameCollect(aid);
        return JsonUtils.getJson(gameCollects,gameCollects!=null?0:1);
    }

    @RequestMapping(value = "/findByGid",method = RequestMethod.POST)
    public Map<String,Object> findByGidGameCollect(@PathParam("gid") Long gid){
        List<GameCollect> gameCollects = gameCollectService.findByGidGameCollect(gid);
        return JsonUtils.getJson(gameCollects,gameCollects!=null?0:1);
    }

    @RequestMapping(value = "/findByAidGid",method = RequestMethod.POST)
    public Map<String,Object> findByAidGidGameCollect(@PathParam("aid") Long aid,
                                                      @PathParam("gid") Long gid){
        GameCollect gameCollects = gameCollectService.findByAidGidGameCollect(aid,gid);
        return JsonUtils.getJson(gameCollects,gameCollects!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveGameCollect(@PathParam("aid") Long aid,
                                              @PathParam("gid") Long gid){
        GameCollect gameCollect=gameCollectService.findByAidGidGameCollect(aid,gid);
        if (gameCollect != null) {
            gameCollect=null;
        }else {
            gameCollect=GameCollect.builder().aid(aid).gid(gid).time(new Date()).build();
            gameCollect=gameCollectService.saveGameCollect(gameCollect);
        }
        return JsonUtils.getJson(gameCollect,gameCollect!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteGameCollect(@PathParam("id") Long id){
        GameCollect gameCollect = gameCollectService.deleteGameCollect(id);
        return JsonUtils.getJson(gameCollect,gameCollect!=null?0:1);
    }
}
