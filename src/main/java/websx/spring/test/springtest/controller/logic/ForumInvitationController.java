package websx.spring.test.springtest.controller.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.*;
import websx.spring.test.springtest.service.impl.AccountService;
import websx.spring.test.springtest.service.impl.ForumService;
import websx.spring.test.springtest.service.impl.InvitationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ForumI")
@RestController
public class ForumInvitationController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ForumService forumService;
    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/findAllF")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAllF(){
        List<Forum> forums=forumService.findAllForum();
        List<ForumAll> forumAlls=new ArrayList<>();
        for (int i = 0; i < forums.size(); i++) {
            Account account=accountService.findByIdAccount(forums.get(i).getAid());
            ForumAll forumAll=new ForumAll();
            forumAll.setId(forums.get(i).getId());
            forumAll.setAid(forums.get(i).getAid());
            forumAll.setAccountName(account.getName());
            forumAll.setAccountLogo(account.getLogo());
            forumAll.setConcerns(forums.get(i).getConcerns());
            forumAll.setInvitations(forums.get(i).getInvitations());
            forumAll.setViews(forums.get(i).getViews());
            forumAll.setName(forums.get(i).getName());
            forumAll.setLogo(forums.get(i).getLogo());
            forumAll.setIp(forums.get(i).getIp());
            forumAlls.add(forumAll);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",forumAlls.size());
        map.put("data",forumAlls);
        return map;
    }

    @RequestMapping("/findAllI")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> findAllI(){
        List<Invitation> invitations=invitationService.findAllInvitation();
        List<InvitationAll> invitationAlls=new ArrayList<>();
        for (int i = 0; i < invitations.size(); i++) {
            Account account=accountService.findByIdAccount(invitations.get(i).getAid());
            Forum forum=forumService.findByIdForum(invitations.get(i).getFid());
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
        map.put("count",invitationAlls.size());
        map.put("data",invitationAlls);
        return map;
    }
}
