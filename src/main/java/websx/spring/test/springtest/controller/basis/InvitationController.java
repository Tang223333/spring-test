package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.*;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.*;

@RequestMapping("/invitation")
@RestController
public class InvitationController {

    @Autowired
    private InvitationService invitationService;
    @Autowired
    private ForumService forumService;
    @Autowired
    private ImgService imgService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllInvitation(){
        List<Invitation> allInvitationMutual = invitationService.findAllInvitation();
        return JsonUtils.getJson(allInvitationMutual,allInvitationMutual!=null?0:1);
    }

    @RequestMapping("/findAll2")
    public Map<String,Object> findAll2Invitation(){
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

    @RequestMapping(value = "/findByFid2")
    public Map<String,Object> findByFid2Invitation(@PathParam("fid") Long fid,Integer page){
        System.out.println(fid);
        System.out.println(page);
        List<Invitation> invitations=invitationService.findByFidInvitation(fid);
        List<Invitation> allInvitationMutual = invitationService.findByFid2Invitation(fid,page);
        List<InvitationAll> invitationAlls=new ArrayList<>();
        for (int i = 0; i < allInvitationMutual.size(); i++) {
            Account account=accountService.findByIdAccount(allInvitationMutual.get(i).getAid());
            Forum forum=forumService.findByIdForum(allInvitationMutual.get(i).getFid());
            InvitationAll invitationAll=new InvitationAll();
            invitationAll.setId(invitations.get(i).getId());
            invitationAll.setFid(invitations.get(i).getFid());
            invitationAll.setAid(invitations.get(i).getAid());
            invitationAll.setForumName(forum.getName());
            invitationAll.setForumLogo(forum.getLogo());
            invitationAll.setAccountName(account.getName());
            invitationAll.setAccountLogo(account.getLogo());
            invitationAll.setContent(invitations.get(i).getContent());
            invitationAll.setGoods(invitations.get(i).getGoods());
            invitationAll.setBads(invitations.get(i).getBads());
            invitationAll.setCollects(invitations.get(i).getCollects());
            invitationAll.setComments(invitations.get(i).getComments());
            invitationAll.setTime(invitations.get(i).getTime());
            invitationAll.setImgs(invitations.get(i).getImgs());
            invitationAll.setVideos(invitations.get(i).getVideos());
            invitationAll.setIp(invitations.get(i).getIp());
            invitationAlls.add(invitationAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",invitations.size());
        map.put("data",invitationAlls);
        return map;
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
                                             @PathParam("ip") String ip,
                                             @PathParam("goods") Integer goods,
                                             @PathParam("bads") Integer bads,
                                             @PathParam("collects") Integer collects,
                                             @PathParam("comments") Integer comments){
        System.out.println("fadfasdf");
        Long i=new Date().getTime();
        Invitation invitation=invitationService.findByFidAidInvitation(fid,aid);
        Forum forum=forumService.findByIdForum(fid);
        if (forum!=null&&invitation != null) {
            invitation=null;
        }else {
            invitation= Invitation.builder()
                    .fid(fid).aid(aid).content(content).ip(ip)
                    .imgs("img_"+i).videos("video_"+i).time(new Date())
                    .goods(goods!=null?goods:0).bads(bads!=null?bads:0)
                    .collects(collects!=null?collects:0).comments(comments!=null?comments:0).build();
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
                    .collects(collects!=null?collects:invitation.getCollects()).comments(comments!=null?comments:invitation.getComments())
                    .videos(invitation.getVideos()).imgs(invitation.getImgs()).build();
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
