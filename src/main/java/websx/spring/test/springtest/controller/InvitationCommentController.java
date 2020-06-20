package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.InvitationComment;
import websx.spring.test.springtest.service.impl.InvitationCommentService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/invitationComment")
@RestController
public class InvitationCommentController {

    @Autowired
    private InvitationCommentService invitationCommentService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllInvitationComment(){
        List<InvitationComment> allInvitationMutual = invitationCommentService.findAllInvitationComment();
        return JsonUtils.getJson(allInvitationMutual,allInvitationMutual!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdInvitationComment(@PathParam("id") Long id){
        InvitationComment InvitationComment = invitationCommentService.findByIdInvitationComment(id);
        return JsonUtils.getJson(InvitationComment,InvitationComment!=null?0:1);
    }

    @RequestMapping(value = "/findByIid",method = RequestMethod.POST)
    public Map<String,Object> findByGidInvitationComment(@PathParam("iid") Long iid){
        List<InvitationComment> InvitationComments = invitationCommentService.findByIidInvitationComment(iid);
        return JsonUtils.getJson(InvitationComments,InvitationComments!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidInvitationComment(@PathParam("aid") Long aid){
        List<InvitationComment> InvitationComments = invitationCommentService.findByIidInvitationComment(aid);
        return JsonUtils.getJson(InvitationComments,InvitationComments!=null?0:1);
    }

    @RequestMapping(value = "/findByIidAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidInvitationComment(@PathParam("iid") Long iid,
                                                         @PathParam("aid") Long aid){
        InvitationComment InvitationComments = invitationCommentService.findByIidAidInvitationComment(iid,aid);
        return JsonUtils.getJson(InvitationComments,InvitationComments!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveInvitationComment(@PathParam("iid") Long iid,
                                                    @PathParam("aid") Long aid,
                                                    @PathParam("content") String content,
                                                    @PathParam("ip") String ip){
        Long i=new Date().getTime();
        InvitationComment invitationComment=invitationCommentService.findByIidAidInvitationComment(iid,aid);
        if (invitationComment != null) {
            invitationComment=null;
        }else {
            invitationComment= InvitationComment.builder().iid(iid).aid(aid).content(content)
                    .imgs("img_"+i).videos("video_"+i).ip(ip).time(new Date()).build();
            invitationComment=invitationCommentService.saveInvitationComment(invitationComment);
        }
        return JsonUtils.getJson(invitationComment,invitationComment!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateInvitationComment(@PathParam("id") Long id,
                                                      @PathParam("iid") Long iid,
                                                      @PathParam("aid") Long aid,
                                                      @PathParam("content") String content,
                                                      @PathParam("ip") String ip){
        InvitationComment invitationComment=invitationCommentService.findByIdInvitationComment(id);
        if (invitationComment != null) {
            invitationComment= InvitationComment.builder().id(invitationComment.getId()).iid(iid!=null?iid:invitationComment.getIid())
                    .aid(aid!=null?aid:invitationComment.getAid()).time(new Date())
                    .content(content!=null?content:invitationComment.getContent()).ip(ip!=null?ip:invitationComment.getIp()).build();
            invitationComment=invitationCommentService.updateInvitationComment(invitationComment);
        }else {
            invitationComment=null;
        }
        return JsonUtils.getJson(invitationComment,invitationComment!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteInvitationComment(@PathParam("id") Long id){
        InvitationComment InvitationComment = invitationCommentService.deleteInvitationComment(id);
        return JsonUtils.getJson(InvitationComment,InvitationComment!=null?0:1);
    }
}
