package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.controller.BaseController;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.*;
import websx.spring.test.springtest.utils.JsonUtils2;

import javax.websocket.server.PathParam;
import java.util.*;

@RequestMapping("/Comment")
@RestController
public class CommentController extends BaseController {

    @Autowired
    private InvitationCommentService invitationCommentService;
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private ImgService imgService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private GameCommentService gameCommentService;
    @Autowired
    private GameMutualService gameMutualService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private GameService gameService;

    @RequestMapping("/GameCFindALl")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> GameCFindAll(){
        List<GameComment> gameComments=gameCommentService.findAllGameComment();
        List<GameCommentAll> gameCommentAlls=new ArrayList<>();
        for (int i = 0; i < gameComments.size(); i++) {
            Account account=accountService.findByIdAccount(gameComments.get(i).getAid());
            Game game=gameService.findByIdGame(gameComments.get(i).getGid());
            GameCommentAll gameCommentAll=new GameCommentAll();
            gameCommentAll.setId(gameComments.get(i).getId());
            gameCommentAll.setGid(gameComments.get(i).getGid());
            gameCommentAll.setGameName(game.getName());
            gameCommentAll.setAid(gameComments.get(i).getAid());
            gameCommentAll.setAccountName(account.getName());
            gameCommentAll.setAccountLogo(account.getLogo());
            gameCommentAll.setContent(gameComments.get(i).getContent());
            gameCommentAll.setGoodOrBad(gameComments.get(i).getGoodOrBad());
            gameCommentAll.setGrade(gameComments.get(i).getGrade());
            gameCommentAll.setIp(gameComments.get(i).getIp());
            gameCommentAll.setTime(gameComments.get(i).getTime());
            gameCommentAlls.add(gameCommentAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",gameCommentAlls.size());
        map.put("data",gameCommentAlls);
        return map;
    }

    @RequestMapping("/InvitationCFindALl")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> InvitationCFindAll(Integer page,Integer limit){
        List<InvitationComment> invitationComments=invitationCommentService.findAll2InvitationComment(page,limit);
        List<InvitationCommentAll> invitationCommentAlls=new ArrayList<>();
        for (int i = 0; i < invitationComments.size(); i++) {
            Account account=accountService.findByIdAccount(invitationComments.get(i).getAid());
            Invitation invitation=invitationService.findByIdInvitation(invitationComments.get(i).getIid());
            InvitationCommentAll invitationCommentAll=new InvitationCommentAll();
            invitationCommentAll.setId(invitationComments.get(i).getId());
            invitationCommentAll.setIid(invitationComments.get(i).getIid());
            invitationCommentAll.setInvitationContent(invitation.getContent());
            invitationCommentAll.setAid(invitationComments.get(i).getAid());
            invitationCommentAll.setAccountName(account.getName());
            invitationCommentAll.setAccountLogo(account.getLogo());
            invitationCommentAll.setContent(invitationComments.get(i).getContent());
            invitationCommentAll.setImgs(invitationComments.get(i).getImgs());
            invitationCommentAll.setVideos(invitationComments.get(i).getVideos());
            invitationCommentAll.setIp(invitationComments.get(i).getIp());
            invitationCommentAll.setTime(invitationComments.get(i).getTime());
            invitationCommentAlls.add(invitationCommentAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",invitationCommentAlls.size());
        map.put("data",invitationCommentAlls);
        return map;
    }

    @RequestMapping("/InvitationCommentOn")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> InvitationCommentOn(@PathParam("iid") Long iid,
                                                  @PathParam("aid") Long aid,
                                                  @PathParam("content") String content,
                                                  @PathParam("ip") String ip){
        Invitation invitation=null;
        InvitationComment invitationComment=null;
        try {
            invitationComment=invitationCommentService.findByIidAidInvitationComment(iid,aid);
            System.out.println(invitationComment);
            invitation = invitationService.findByIdInvitation(iid);
            System.out.println(invitation);
            if (invitationComment != null) {
                throw new Exception();
            }else {
                Long i=new Date().getTime();
                invitationComment= InvitationComment.builder().iid(iid).aid(aid).content(content).ip(ip).time(new Date()).videos("video_"+i).imgs("img_"+i).build();
                invitationComment=invitationCommentService.saveInvitationComment(invitationComment);
                invitation.setComments(invitation.getComments()+1);
                reason="评论发送成功";
            }
            invitation=invitationService.updateInvitation(invitation);
            error_code=0;
        } catch (Exception e) {
            invitation=null;
            invitationComment=null;
            error_code=1008;
            reason="您已评论过";
        }finally {
            return JsonUtils2.getJson2(invitation,invitationComment,error_code,reason);
        }
    }

    @RequestMapping("/InvitationCommentOff")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> InvitationCommentOff(@PathParam("iid") Long iid,
                                                   @PathParam("aid") Long aid){
        Invitation invitation=null;
        InvitationComment invitationComment=null;
        try {
            invitationComment=invitationCommentService.findByIidAidInvitationComment(iid,aid);
            invitation = invitationService.findByIdInvitation(iid);
            if (invitation != null) {
                imgService.deleteByKeyImg(invitationComment.getImgs()+"");
                videoService.deleteByKeyVideo(invitationComment.getVideos()+"");
                invitationComment=invitationCommentService.deleteInvitationComment(invitationComment.getId());
                invitation.setComments(invitation.getComments()-1);
                reason="评论撤回成功";
            }else {
               throw new Exception();
            }
            invitation=invitationService.updateInvitation(invitation);
            error_code=0;
        } catch (Exception e) {
            invitation=null;
            invitationComment=null;
            error_code=1009;
            reason="您还没评论呢";
        }finally {
            return JsonUtils2.getJson2(invitation,invitationComment,error_code,reason);
        }
    }

    @RequestMapping("/GameCommentOn")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> GameCommentOn(@PathParam("gid") Long gid,
                                            @PathParam("aid") Long aid,
                                            @PathParam("content") String content,
                                            @PathParam("goodOrBad") Integer goodOrBad,
                                            @PathParam("grade") Integer grade,
                                            @PathParam("ip") String ip){
        GameMutual gameMutual=null;
        GameComment gameComment=null;
        try {
            System.out.println(gid);
            System.out.println(aid);
            System.out.println(content);
            gameComment=gameCommentService.findByAidGidGameComment(aid,gid);
            System.out.println(gameComment);
            gameMutual = gameMutualService.findByGidGameMutual(gid);
            if (gameComment != null) {
                throw new Exception();
            }else {
                gameComment= GameComment.builder().gid(gid).aid(aid).content(content).ip(ip).time(new Date()).goodOrBad(goodOrBad).grade(grade).build();
                gameComment=gameCommentService.saveGameComment(gameComment);
                gameMutual.setComments(gameMutual.getComments()+1);

                reason="评论发送成功";
            }
            gameMutual=gameMutualService.updateGameMutual(gameMutual);
            error_code=0;
        } catch (Exception e) {
            gameMutual=null;
            gameComment=null;
            error_code=1008;
            reason="您已评论过";
        }finally {
            return JsonUtils2.getJson2(gameComment,gameMutual,error_code,reason);
        }
    }

    @RequestMapping("/GameCommentOff")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> GameCommentOff(@PathParam("gid") Long gid,
                                             @PathParam("aid") Long aid){
        GameMutual gameMutual=null;
        GameComment gameComment=null;
        try {
            System.out.println(gid);
            System.out.println(aid);
            gameComment=gameCommentService.findByAidGidGameComment(aid,gid);
            gameMutual = gameMutualService.findByGidGameMutual(gid);
            if (gameComment != null) {
                gameComment=gameCommentService.deleteGameComment(gameComment.getId());
                reason="评论撤回成功";
            }else {
                throw new Exception();
            }
            gameMutual=gameMutualService.updateGameMutual(gameMutual);
            error_code=0;
        } catch (Exception e) {
            gameMutual=null;
            gameComment=null;
            error_code=1008;
            reason="您还没评论呢";
        }finally {
            return JsonUtils2.getJson2(gameComment,gameMutual,error_code,reason);
        }
    }
}
