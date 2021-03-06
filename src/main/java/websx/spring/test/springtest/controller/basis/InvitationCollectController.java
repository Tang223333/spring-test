package websx.spring.test.springtest.controller.basis;

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
        List<InvitationCollect> invitationCollects = invitationCollectService.findByAidInvitationCollect(aid);
        return JsonUtils.getJson(invitationCollects,invitationCollects!=null?0:1);
    }

    @RequestMapping(value = "/findByIid",method = RequestMethod.POST)
    public Map<String,Object> findByIidInvitationCollect(@PathParam("iid") Long iid){
        List<InvitationCollect> invitationCollects = invitationCollectService.findByIidInvitationCollect(iid);
        return JsonUtils.getJson(invitationCollects,invitationCollects!=null?0:1);
    }

    @RequestMapping(value = "/findByAidIid",method = RequestMethod.POST)
    public Map<String,Object> findByAidIidInvitationCollect(@PathParam("aid") Long aid,
                                                         @PathParam("iid") Long iid){
        InvitationCollect invitationCollects = invitationCollectService.findByAidIidInvitationCollect(aid,iid);
        return JsonUtils.getJson(invitationCollects,invitationCollects!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveInvitationCollect(@PathParam("aid") Long aid,
                                              @PathParam("iid") Long iid){
        InvitationCollect invitationCollect=invitationCollectService.findByAidIidInvitationCollect(aid,iid);
        if (invitationCollect != null) {
            invitationCollect=null;
        }else {
            invitationCollect=InvitationCollect.builder().aid(aid).iid(iid).time(new Date()).build();
            invitationCollect=invitationCollectService.saveInvitationCollect(invitationCollect);
        }
        return JsonUtils.getJson(invitationCollect,invitationCollect!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteInvitationCollect(@PathParam("id") Long id){
        InvitationCollect invitationCollect = invitationCollectService.deleteInvitationCollect(id);
        return JsonUtils.getJson(invitationCollect,invitationCollect!=null?0:1);
    }
}
