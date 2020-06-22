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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/View")
@RestController
public class ViewController extends BaseController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @Autowired
    private GameCommentService gameCommentService;
    @Autowired
    private GameCollectService gameCollectService;
    @Autowired
    private GameService gameService;
    @Autowired
    private NewsCollectService newsCollectService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private InvitationCommentService invitationCommentService;
    @Autowired
    private InvitationCollectService invitationCollectService;
    @Autowired
    private ForumService forumService;
    @Autowired
    private ConcernForumService concernForumService;

    @RequestMapping("/UserAndAccount")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> viewsUserAndAccount(@PathParam("id") Long id) {
        Account account = null;
        User user = null;
        try {
            account = accountService.findByIdAccount(id);
            user = userService.findByIdUser(account.getUid());
            error_code = 0;
            reason = "请求成功";
        } catch (Exception e) {
            account = null;
            user = null;
            error_code = 1010;
            reason = "id不存在";
        }
        return JsonUtils2.getJson2(user, account, error_code, reason);
    }

    @RequestMapping("/GameCollect")
    public Map<String, Object> viewsGameCollect(@PathParam("id") Long id) {
        List<GameCollect> gameCollects = gameCollectService.findByAidGameCollect(id);
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < gameCollects.size(); i++) {
            games.add(gameService.findByIdGame(gameCollects.get(i).getGid()));
        }
        error_code = 0;
        reason = "请求成功";
        return JsonUtils2.getJson2(gameCollects, games, error_code, reason);
    }

    @RequestMapping("/NewsCollect")
    public Map<String, Object> viewsNewsCollect(@PathParam("id") Long id) {
        List<NewsCollect> newsCollects = newsCollectService.findByAidNewsCollect(id);
        List<News> news = new ArrayList<>();
        for (int i = 0; i < newsCollects.size(); i++) {
            news.add(newsService.findByIdNews(newsCollects.get(i).getNid()));
        }
        error_code = 0;
        reason = "请求成功";
        return JsonUtils2.getJson2(newsCollects, news, error_code, reason);
    }

    @RequestMapping("/InvitationCollect")
    public Map<String, Object> viewsInvitationCollect(@PathParam("id") Long id) {
        List<InvitationCollect> invitationCollects = invitationCollectService.findByAidInvitationCollect(id);
        List<Invitation> invitations = new ArrayList<>();
        for (int i = 0; i < invitationCollects.size(); i++) {
            invitations.add(invitationService.findByIdInvitation(invitationCollects.get(i).getIid()));
        }
        error_code = 0;
        reason = "请求成功";
        return JsonUtils2.getJson2(invitationCollects, invitations, error_code, reason);
    }

    @RequestMapping("/GameComment")
    public Map<String, Object> viewsGameComment(@PathParam("id") Long id) {
        List<GameComment> gameComments = gameCommentService.findByAidGameComment(id);
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < gameComments.size(); i++) {
            games.add(gameService.findByIdGame(gameComments.get(i).getGid()));
        }
        error_code = 0;
        reason = "请求成功";
        return JsonUtils2.getJson2(gameComments, games, error_code, reason);
    }

    @RequestMapping("/InvitationComment")
    public Map<String, Object> viewsInvitationComment(@PathParam("id") Long id) {
        List<InvitationComment> invitationComments = invitationCommentService.findByAidInvitationComment(id);
        List<Invitation> invitations = new ArrayList<>();
        for (int i = 0; i < invitationComments.size(); i++) {
            invitations.add(invitationService.findByIdInvitation(invitationComments.get(i).getIid()));
        }
        error_code = 0;
        reason = "请求成功";
        return JsonUtils2.getJson2(invitationComments, invitations, error_code, reason);
    }

    @RequestMapping("/ForumConcern")
    public Map<String, Object> viewsForumConcern(@PathParam("id") Long id) {
        List<ConcernForum> concernForums = concernForumService.findByAidConcernForum(id);
        List<Forum> forums = new ArrayList<>();
        for (int i = 0; i < concernForums.size(); i++) {
            forums.add(forumService.findByIdForum(concernForums.get(i).getFid()));
        }
        error_code = 0;
        reason = "请求成功";
        return JsonUtils2.getJson2(concernForums, forums, error_code, reason);
    }
}
