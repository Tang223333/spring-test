package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.InvitationCollect;
import websx.spring.test.springtest.service.impl.InvitationCollectService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/invitationCollect")
@RestController
public class InvitationCollectController {

    @Autowired
    private InvitationCollectService invitationCollectService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllInvitationCollect(){
        List<InvitationCollect> allInvitationCollect = invitationCollectService.findAllInvitationCollect();
        return JsonUtils.getJson(allInvitationCollect,allInvitationCollect!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdInvitationCollect(@PathParam("id") Long id){
        InvitationCollect invitationCollect = invitationCollectService.findByIdInvitationCollect(id);
        return JsonUtils.getJson(invitationCollect,invitationCollect!=null?0:1);
    }

    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public Map<String,Object> findByAidInvitationCollect(@PathParam("aid") Long aid){
        List<InvitationCollect> invitationCollects = invitationCollectService.findByAidGidInvitationCollect(aid);
        return JsonUtils.getJson(invitationCollects,invitationCollects!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveInvitationCollect(@PathParam("aid") Long aid,
                                              @PathParam("gid") Long gid){
        InvitationCollect invitationCollect=InvitationCollect.builder().aid(aid).gid(gid).time(new Date()).build();
        invitationCollect=invitationCollectService.saveInvitationCollect(invitationCollect);
        return JsonUtils.getJson(invitationCollect,invitationCollect!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteInvitationCollect(@PathParam("id") Long id){
        InvitationCollect invitationCollect = invitationCollectService.deleteInvitationCollect(id);
        return JsonUtils.getJson(invitationCollect,invitationCollect!=null?0:1);
    }
}
