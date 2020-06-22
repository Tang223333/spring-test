package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/IVT")
@RestController
public class ImgVideoTypeController extends BaseController {

    @Autowired
    private ImgService imgService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private GameService gameService;
    @Autowired
    private GameMutualService gameMutualService;
    @Autowired
    private GameCommentService gameCommentService;
    @Autowired
    private DisposeService disposeService;

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsMutualService newsMutualService;

    @Autowired
    private InvitationService invitationService;
    @Autowired
    private InvitationCommentService invitationCommentService;

    @RequestMapping("/Game")
    public Map<String,Object> Games(@PathParam("id") Long id){
        Game game=gameService.findByIdGame(id);
        Dispose dispose=disposeService.findAllByGidDispose(id);
        GameMutual gameMutual=gameMutualService.findByGidGameMutual(id);
        List<GameComment> gameComments = gameCommentService.findByGidGameComment(id);
        List<Img> imgs=imgService.findByKeyImg(game.getImgs()+"");
        List<Video> videos=videoService.findByKeyVideo(game.getVideos()+"");
        List<Type> types=typeService.findByKeyType(game.getTypes()+"");
        game.setVideos(videos);
        game.setImgs(imgs);
        game.setTypes(types);
        error_code=0;
        reason="请求成功";
        return JsonUtils2.getJson4(game,dispose,gameMutual,gameComments,error_code,reason);
    }

    @RequestMapping("/News")
    public Map<String,Object> News(@PathParam("id") Long id){
        News news=newsService.findByIdNews(id);
        NewsMutual newsMutual=newsMutualService.findByNidNewsMutual(id);
        List<Img> imgs=imgService.findByKeyImg(news.getImgs()+"");
        List<Video> videos=videoService.findByKeyVideo(news.getVideos()+"");
        news.setImgs(imgs);
        news.setVideos(videos);
        error_code=0;
        reason="请求成功";
        return JsonUtils2.getJson2(news,newsMutual,error_code,reason);
    }

    @RequestMapping("/Invitation")
    private Map<String,Object> Invitation(@PathParam("id") Long id){
        Invitation invitation=invitationService.findByIdInvitation(id);
        List<Img> imgs=imgService.findByKeyImg(invitation.getImgs()+"");
        List<Video> videos=videoService.findByKeyVideo(invitation.getVideos()+"");
        invitation.setImgs(imgs);
        invitation.setVideos(videos);
        List<InvitationComment> invitationComments=invitationCommentService.findByIidInvitationComment(id);
        for (int i = 0; i < invitationComments.size(); i++) {
            imgs=new ArrayList<>();
            videos=new ArrayList<>();
            imgs=imgService.findByKeyImg(invitationComments.get(i).getImgs()+"");
            videos=videoService.findByKeyVideo(invitationComments.get(i).getVideos()+"");
            invitationComments.get(i).setImgs(imgs);
            invitationComments.get(i).setVideos(videos);
        }
        error_code=0;
        reason="请求成功";
        return JsonUtils2.getJson2(invitation,invitationComments,error_code,reason);
    }
}
