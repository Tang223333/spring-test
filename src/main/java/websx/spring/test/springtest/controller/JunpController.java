package websx.spring.test.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JunpController {

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

}
