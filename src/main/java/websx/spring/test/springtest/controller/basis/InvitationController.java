package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Invitation;
import websx.spring.test.springtest.service.impl.InvitationService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/invitation")
@RestController
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllInvitation(){
        List<Invitation> allInvitationMutual = invitationService.findAllInvitation();
        return JsonUtils.getJson(allInvitationMutual,allInvitationMutual!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdInvitation(@PathParam("id") Long id){
        Invitation Invitation = invitationService.findByIdInvitation(id);
        return JsonUtils.getJson(Invitation,Invitation!=null?0:1);
    }

    @RequestMapping(value = "/findByFid",method = RequestMethod.POST)
    public Map<String,Object> findByFidInvitation(@PathParam("fid") Long fid){
        List<Invitation> Invitations = invitationService.findByFidInvitation(fid);
        return JsonUtils.getJson(Invitations,Invitations!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidInvitation(@PathParam("aid") Long aid){
        List<Invitation> Invitations = invitationService.findByAidInvitation(aid);
        return JsonUtils.getJson(Invitations,Invitations!=null?0:1);
    }

    @RequestMapping(value = "/findByFidAid",method = RequestMethod.POST)
    public Map<String,Object> findByFidAidInvitation(@PathParam("fid") Long fid,
                                                     @PathParam("aid") Long aid){
        Invitation Invitations = invitationService.findByFidAidInvitation(fid,aid);
        return JsonUtils.getJson(Invitations,Invitations!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveInvitation(@PathParam("fid") Long fid,
                                             @PathParam("aid") Long aid,
                                             @PathParam("content") String content,
                                             @PathParam("ip") String ip){
        Long i=new Date().getTime();
        Invitation invitation=invitationService.findByFidAidInvitation(fid,aid);
        if (invitation != null) {
            invitation=null;
        }else {
            invitation= Invitation.builder().fid(fid).aid(aid).content(content).ip(ip).imgs("img_"+i).videos("video_"+i).time(new Date()).goods(0).bads(0).collects(0).comments(0).build();
            invitation=invitationService.saveInvitation(invitation);
        }
        return JsonUtils.getJson(invitation,invitation!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateInvitation(@PathParam("id") Long id,
                                               @PathParam("fid") Long fid,
                                               @PathParam("aid") Long aid,
                                               @PathParam("content") String content,
                                               @PathParam("ip") String ip,
                                               @PathParam("goods") Integer goods,
                                               @PathParam("bads") Integer bads,
                                               @PathParam("collects") Integer collects,
                                               @PathParam("comments") Integer comments){
        Invitation invitation=invitationService.findByIdInvitation(id);
        if (invitation != null) {
            invitation= Invitation.builder().id(invitation.getId()).fid(fid!=null?fid:invitation.getFid()).aid(aid!=null?aid:invitation.getAid())
                    .content(content!=null?content:invitation.getContent()).ip(ip!=null?ip:invitation.getIp()).time(new Date())
                    .goods(goods!=null?goods:invitation.getGoods()).bads(bads!=null?bads:invitation.getBads())
                    .collects(collects!=null?collects:invitation.getCollects()).comments(comments!=null?comments:invitation.getComments()).build();
            invitation=invitationService.updateInvitation(invitation);
        }else {
        }
        return JsonUtils.getJson(invitation,invitation!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteInvitation(@PathParam("id") Long id){
        Invitation Invitation = invitationService.deleteInvitation(id);
        return JsonUtils.getJson(Invitation,Invitation!=null?0:1);
    }
}
