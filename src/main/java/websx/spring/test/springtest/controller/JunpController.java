package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class JunpController {

    @Autowired
    private GameService gameService;
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private ForumService forumService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public String toLogin(){
        return "web/login";
    }

    @RequestMapping("/register")
    public String toRegister(){
        return "web/register";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "web/index";
    }

    @RequestMapping("/404")
    public String to404(){
        return "web/404";
    }

    @RequestMapping("/one")
    public String toone(){
        return "web/one";
    }
    @RequestMapping("/news")
    public String toNews(){
        return "web/news";
    }

    @RequestMapping("/games")
    public String toGames(){
        return "web/games";
    }

    @RequestMapping("/forums")
    public String toForums(){
        return "web/forums";
    }

    @RequestMapping("/invitations")
    public String toInvitations(){
        return "web/invitations";
    }

    @RequestMapping("/gameComments")
    public String toGameComments(){
        return "web/gameComments";
    }

    @RequestMapping("/invitationComments")
    public String toInvitationComment(){
        return "web/invitationComments";
    }

    @RequestMapping("/invitationCollects")
    public String toInvitationCollect(){
        return "web/invitationCollects";
    }

    @RequestMapping("/gameCollects")
    public String toGameCollect(){
        return "web/gameCollects";
    }

    @RequestMapping("/newsCollects")
    public String toNewsCollect(){
        return "web/newsCollects";
    }

    @RequestMapping("/forumConcerns")
    public String toForumConcern(){
        return "web/forumConcern";
    }

    @RequestMapping("/imgs")
    public String toImgs(){
        return "web/imgs";
    }

    @RequestMapping("/videos")
    public String toVideos(){
        return "web/videos";
    }

    @RequestMapping("/types")
    public String toTypes(){
        return "web/types";
    }

    @RequestMapping("/game_one")
    public String toGameOne(Long id, Model model){
        Game byIdGame = gameService.findByIdGame(id);
        if (byIdGame != null) {
            model.addAttribute("gid",byIdGame.getId());
            return "web/game_ones";
        }else {
            return "web/index_v5";
        }
    }

    @RequestMapping("/fenye")
    public String toFenYe(){
        return "web/fenye";
    }

    @RequestMapping("/forum")
    public String toForum(){
        return "web/forum_main";
    }

    @RequestMapping("/invitation")
    public String toInvitation(@PathParam("fid") Long fid, Model model){
        Forum forum=forumService.findByIdForum(fid);
        if (forum != null) {
            model.addAttribute("fid",forum.getId());
            return "web/blog";
        }else {
            return "web/forum_main";
        }
    }

    @RequestMapping("/invitation_one")
    public String toInvitationOne(@PathParam("iid") Long iid, Model model){
        Invitation invitation=invitationService.findByIdInvitation(iid);
        if (invitation != null) {
            model.addAttribute("iid",invitation.getId());
            return "web/article";
        }else {
            return "web/blog";
        }
    }

    @RequestMapping("/news_main")
    public String toNewsMain(@PathParam("nid") Long nid,Model model){
        News news=newsService.findByIdNews(nid);
        if (news != null) {
            model.addAttribute("nid",news.getId());
            return "web/news_article";
        }else {
            return "web/news_main";
        }
    }

    @RequestMapping("/CollectConcern")
    public String toCollectConcern(@PathParam("aid") Long aid,Model model){
        Account account=accountService.findByIdAccount(aid);
        if (account != null) {
            System.out.println(account.getId());
            model.addAttribute("aid",account.getId());
            return "web/CollectConcern";
        }else {
            return "web/index_v5";
        }
    }

}
