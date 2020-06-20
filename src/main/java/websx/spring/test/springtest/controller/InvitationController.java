package websx.spring.test.springtest.controller;

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

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveInvitation(@PathParam("fid") Long fid,
                                             @PathParam("aid") Long aid,
                                             @PathParam("content") String content,
                                             @PathParam("imgs") String imgs,
                                             @PathParam("videos") String videos,
                                             @PathParam("ip") String ip,
                                             @PathParam("goods") Integer goods,
                                             @PathParam("bads") Integer bads){
        Invitation invitation= Invitation.builder().fid(fid).aid(aid).content(content).imgs(imgs).videos(videos).ip(ip).time(new Date()).goods(goods).bads(bads).build();
        invitation=invitationService.saveInvitation(invitation);
        return JsonUtils.getJson(invitation,invitation!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateInvitation(@PathParam("id") Long id,
                                               @PathParam("fid") Long fid,
                                               @PathParam("aid") Long aid,
                                               @PathParam("content") String content,
                                               @PathParam("imgs") String imgs,
                                               @PathParam("videos") String videos,
                                               @PathParam("ip") String ip,
                                               @PathParam("goods") Integer goods,
                                               @PathParam("bads") Integer bads){
        Invitation invitation=invitationService.findByIdInvitation(id);
        if (invitation != null) {
            invitation= Invitation.builder().id(invitation.getId()).fid(fid).aid(aid).content(content).videos(videos).imgs(imgs).ip(ip).time(new Date()).goods(goods).bads(bads).build();
            invitation=invitationService.updateInvitation(invitation);
            return JsonUtils.getJson(invitation,invitation!=null?0:1);
        }else {
            return JsonUtils.getJson(invitation,1);
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteInvitation(@PathParam("id") Long id){
        Invitation Invitation = invitationService.deleteInvitation(id);
        return JsonUtils.getJson(Invitation,Invitation!=null?0:1);
    }
}
