package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Account;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.GameCommentService;
import websx.spring.test.springtest.service.impl.GameService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/gameComment")
@RestController
public class GameCommentController {

    @Autowired
    private GameCommentService gameCommentService;
    @Autowired
    private GameService gameService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllGameComment(){
        List<GameComment> allGameMutual = gameCommentService.findAllGameComment();
        return JsonUtils.getJson(allGameMutual,allGameMutual!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdGameComment(@PathParam("id") Long id){
        GameComment gameComment = gameCommentService.findByIdGameComment(id);
        return JsonUtils.getJson(gameComment,gameComment!=null?0:1);
    }

    @RequestMapping(value = "/findByGid",method = RequestMethod.POST)
    public Map<String,Object> findByGidGameComment(@PathParam("gid") Long gid){
        List<GameComment> gameComments = gameCommentService.findByGidGameComment(gid);
        return JsonUtils.getJson(gameComments,gameComments!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidGameComment(@PathParam("aid") Long aid){
        List<GameComment> gameComments = gameCommentService.findByGidGameComment(aid);
        return JsonUtils.getJson(gameComments,gameComments!=null?0:1);
    }

    @RequestMapping(value = "/findByAidGid",method = RequestMethod.POST)
    public Map<String,Object> findByAidGidGameComment(@PathParam("aid") Long aid,
                                                      @PathParam("gid") Long gid){
        GameComment gameComments = gameCommentService.findByAidGidGameComment(aid,gid);
        return JsonUtils.getJson(gameComments,gameComments!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveGameComment(@PathParam("gid") Long gid,
                                              @PathParam("aid") Long aid,
                                              @PathParam("content") String content,
                                              @PathParam("goodOrBad") Integer goodOrBad,
                                              @PathParam("grade") Integer grade,
                                              @PathParam("ip") String ip){
        Game game= gameService.findByIdGame(gid);
        Account account=accountService.findByIdAccount(aid);
        if (account!=null&&game!=null){
            GameComment gameComment= GameComment.builder().aid(aid).gid(gid)
                    .content(content).goodOrBad(goodOrBad!=null?goodOrBad:0)
                    .grade(grade!=null?grade:0).ip(ip).time(new Date()).build();
            gameComment=gameCommentService.saveGameComment(gameComment);
            return JsonUtils.getJson(gameComment,gameComment!=null?0:1);
        }else {
            return JsonUtils.getJson("",1);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateGameComment(@PathParam("id") Long id,
                                                @PathParam("gid") Long gid,
                                                @PathParam("aid") Long aid,
                                                @PathParam("content") String content,
                                                @PathParam("goodOrBad") Integer goodOrBad,
                                                @PathParam("grade") Integer grade,
                                                @PathParam("ip") String ip){
        GameComment gameComment=gameCommentService.findByIdGameComment(id);
        if (gameComment != null) {
            gameComment= GameComment.builder().id(gameComment.getId()).aid(aid!=null?aid:gameComment.getAid()).gid(gid!=null?gid:gameComment.getGid())
                    .content(content!=null?content:gameComment.getContent()).goodOrBad(goodOrBad!=null?goodOrBad:gameComment.getGoodOrBad())
                    .grade(grade!=null?grade:gameComment.getGrade()).ip(ip!=null?ip:gameComment.getIp()).time(new Date()).build();
            gameComment=gameCommentService.updateGameComment(gameComment);
            return JsonUtils.getJson(gameComment,gameComment!=null?0:1);
        }else {
            return JsonUtils.getJson(gameComment,1);
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteGameComment(@PathParam("id") Long id){
        GameComment gameComment = gameCommentService.deleteGameComment(id);
        return JsonUtils.getJson(gameComment,gameComment!=null?0:1);
    }

}
