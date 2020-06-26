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

@RequestMapping("/CollectConcern")
@RestController
public class CollectConcernController extends BaseController {

    @Autowired
    private NewsCollectService newsCollectService;
    @Autowired
    private NewsMutualService newsMutualService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private GameCollectService gameCollectService;
    @Autowired
    private GameMutualService gameMutualService;
    @Autowired
    private InvitationCollectService invitationCollectService;
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private ConcernForumService concernForumService;
    @Autowired
    private ForumService forumService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private GameService gameService;

    @RequestMapping("/newsCfindAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> newsCfindAll(){
        List<NewsCollect> newsCollects=newsCollectService.findAllNewsCollect();
        List<NewsCollectAll> newsCollectAlls=new ArrayList<>();
        for (int i = 0; i < newsCollects.size(); i++) {
            News news=newsService.findByIdNews(newsCollects.get(i).getNid());
            Account account=accountService.findByIdAccount(newsCollects.get(i).getAid());
            NewsCollectAll newsCollect=new NewsCollectAll();
            newsCollect.setId(newsCollects.get(i).getId());
            newsCollect.setNid(newsCollects.get(i).getNid());
            newsCollect.setNewsTitle(news.getTitle());
            newsCollect.setNewsWriter(news.getWriter());
            newsCollect.setNewsContent(news.getContent());
            newsCollect.setAid(newsCollects.get(i).getAid());
            newsCollect.setAccountName(account.getName());
            newsCollect.setAccountLogo(account.getLogo());
            newsCollect.setTime(newsCollects.get(i).getTime());
            newsCollectAlls.add(newsCollect);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",newsCollectAlls.size());
        map.put("data",newsCollectAlls);
        return map;
    }

    @RequestMapping("/gameCfindAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> gameCfindAll(){
        List<GameCollect> gameCollects=gameCollectService.findAllGameCollect();
        List<GameCollectAll> gameCollectAlls=new ArrayList<>();
        for (int i = 0; i < gameCollects.size(); i++) {
            Game game=gameService.findByIdGame(gameCollects.get(i).getGid());
            Account account=accountService.findByIdAccount(gameCollects.get(i).getAid());
            GameCollectAll gameCollectAll=new GameCollectAll();
            gameCollectAll.setId(gameCollects.get(i).getId());
            gameCollectAll.setGid(gameCollects.get(i).getGid());
            gameCollectAll.setGameName(game.getName());
            gameCollectAll.setGameDeveloper(game.getDeveloper());
            gameCollectAll.setGamePublisher(game.getPublisher());
            gameCollectAll.setGameTeam(game.getTeam());
            gameCollectAll.setAid(gameCollects.get(i).getAid());
            gameCollectAll.setAccountName(account.getName());
            gameCollectAll.setAccountLogo(account.getLogo());
            gameCollectAll.setTime(gameCollects.get(i).getTime());
            gameCollectAlls.add(gameCollectAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",gameCollectAlls.size());
        map.put("data",gameCollectAlls);
        return map;
    }

    @RequestMapping("/invitationCfindAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> invitationCfindAll(){
        List<InvitationCollect> invitationCollects=invitationCollectService.findAllInvitationCollect();
        List<InvitationCollectAll> invitationCollectAlls=new ArrayList<>();
        for (int i = 0; i < invitationCollects.size(); i++) {
            Invitation invitation=invitationService.findByIdInvitation(invitationCollects.get(i).getIid());
            Account account=accountService.findByIdAccount(invitationCollects.get(i).getAid());
            InvitationCollectAll invitationCollectAll=new InvitationCollectAll();
            invitationCollectAll.setId(invitationCollects.get(i).getId());
            invitationCollectAll.setIid(invitationCollects.get(i).getIid());
            invitationCollectAll.setInvitationContent(invitation.getContent());
            invitationCollectAll.setAid(invitationCollects.get(i).getAid());
            invitationCollectAll.setAccountName(account.getName());
            invitationCollectAll.setAccountLogo(account.getLogo());
            invitationCollectAll.setTime(invitationCollects.get(i).getTime());
            invitationCollectAlls.add(invitationCollectAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",invitationCollectAlls.size());
        map.put("data",invitationCollectAlls);
        return map;
    }

    @RequestMapping("/forumCfindAll")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> forumCfindAll(){
        List<ConcernForum> concernForums=concernForumService.findAllConcernForum();
        List<ConcernForumAll> concernForumAlls=new ArrayList<>();
        for (int i = 0; i < concernForums.size(); i++) {
            Forum forum=forumService.findByIdForum(concernForums.get(i).getFid());
            Account account=accountService.findByIdAccount(concernForums.get(i).getAid());
            ConcernForumAll newsCollectAll=new ConcernForumAll();
            newsCollectAll.setId(concernForums.get(i).getId());
            newsCollectAll.setFid(concernForums.get(i).getFid());
            newsCollectAll.setForumName(forum.getName());
            newsCollectAll.setForumLogo(forum.getLogo());
            newsCollectAll.setAid(concernForums.get(i).getAid());
            newsCollectAll.setAccountName(account.getName());
            newsCollectAll.setAccountLogo(account.getLogo());
            newsCollectAll.setTime(concernForums.get(i).getTime());
            concernForumAlls.add(newsCollectAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",concernForumAlls.size());
        map.put("data",concernForumAlls);
        return map;
    }


    @RequestMapping("/NewsOnOrOff")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> newsOnCollect(@PathParam("nid") Long nid,
                                            @PathParam("aid") Long aid){
        NewsMutual byNidNewsMutual=null;
        NewsCollect newsCollect=null;
        try {
            byNidNewsMutual = newsMutualService.findByNidNewsMutual(nid);
            newsCollect=newsCollectService.findByNidAidNewsCollect(nid,aid);
            if (newsCollect != null) {
                newsCollect=newsCollectService.deleteNewsCollect(newsCollect.getId());
                byNidNewsMutual.setViews(byNidNewsMutual.getViews()-1);
                reason="新闻取消收藏成功";
            }else {
                newsCollect=NewsCollect.builder().nid(nid).aid(aid).time(new Date()).build();
                newsCollect=newsCollectService.saveNewsCollect(newsCollect);
                byNidNewsMutual.setViews(byNidNewsMutual.getViews()+1);
                reason="新闻收藏成功";
            }
            byNidNewsMutual=newsMutualService.updateNewsMutual(byNidNewsMutual);
            error_code=0;
        } catch (Exception e) {
            newsCollect=null;
            byNidNewsMutual=null;
            error_code=1007;
            reason="失败";
        }finally {
            return JsonUtils2.getJson2(newsCollect,byNidNewsMutual,error_code,reason);
        }
    }

    @RequestMapping("/GameOnOrOff")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> gameOnCollect(@PathParam("gid") Long gid,
                                            @PathParam("aid") Long aid){
        GameMutual gameMutual=null;
        GameCollect gameCollect=null;
        try {
            gameMutual = gameMutualService.findByGidGameMutual(gid);
            gameCollect = gameCollectService.findByAidGidGameCollect(aid,gid);
            if (gameCollect != null) {
                gameCollect=gameCollectService.deleteGameCollect(gameCollect.getId());
                gameMutual.setCollects(gameMutual.getCollects()-1);
                reason="游戏取消收藏成功";
            }else {
                gameCollect=GameCollect.builder().gid(gid).aid(aid).time(new Date()).build();
                gameCollect=gameCollectService.saveGameCollect(gameCollect);
                gameMutual.setCollects(gameMutual.getCollects()+1);
                reason="游戏收藏成功";
            }
            gameMutual=gameMutualService.updateGameMutual(gameMutual);
            error_code=0;
        } catch (Exception e) {
            gameMutual=null;
            gameCollect=null;
            error_code=1007;
            reason="失败";
        }finally {
            return JsonUtils2.getJson2(gameCollect,gameMutual,error_code,reason);
        }
    }

    @RequestMapping("/InvitationOnOrOff")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> InvitationOnCollect(@PathParam("iid") Long iid,
                                            @PathParam("aid") Long aid){
        Invitation invitation=null;
        InvitationCollect invitationCollect=null;
        try {
            invitation = invitationService.findByIdInvitation(iid);
            invitationCollect=invitationCollectService.findByAidIidInvitationCollect(aid,iid);
            if (invitationCollect != null) {
                invitationCollect=invitationCollectService.deleteInvitationCollect(invitationCollect.getId());
                invitation.setCollects(invitation.getCollects()-1);
                reason="帖子取消收藏成功";
            }else {
                invitationCollect=InvitationCollect.builder().iid(iid).aid(aid).time(new Date()).build();
                invitationCollect=invitationCollectService.saveInvitationCollect(invitationCollect);
                invitation.setCollects(invitation.getCollects()+1);
                reason="帖子收藏成功";
            }
            invitation=invitationService.updateInvitation(invitation);
            error_code=0;
        } catch (Exception e) {
            invitation=null;
            invitationCollect=null;
            error_code=1007;
            reason="收藏或取消收藏失败";
        }finally {
            return JsonUtils2.getJson2(invitationCollect,invitation,error_code,reason);
        }
    }

    @RequestMapping("/ForumOnOrOff")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> ForumOnConcern(@PathParam("fid") Long fid,
                                             @PathParam("aid") Long aid){
        Forum forum=null;
        ConcernForum concernForum=null;
        try {
            forum = forumService.findByIdForum(fid);
            concernForum=concernForumService.findByAidFidConcernForum(aid,fid);
            if (concernForum != null) {
                concernForum=concernForumService.deleteConcernForum(concernForum.getId());
                forum.setConcerns(forum.getConcerns()-1);
                reason="论坛取消关注成功";
            }else {
                concernForum=ConcernForum.builder().fid(fid).aid(aid).time(new Date()).build();
                concernForum=concernForumService.saveConcernForum(concernForum);
                forum.setConcerns(forum.getConcerns()+1);
                reason="论坛关注成功";
            }
            forum=forumService.updateForum(forum);
            error_code=0;
        } catch (Exception e) {
            forum=null;
            concernForum=null;
            error_code=1007;
            reason="收藏或取消收藏失败";
        }finally {
            return JsonUtils2.getJson2(forum,concernForum,error_code,reason);
        }
    }
}
