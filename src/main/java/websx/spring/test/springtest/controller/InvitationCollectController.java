package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.InvitationCollect;
import websx.spring.test.springtest.service.impl.InvitationCollectService;
import websx.spring.test.springtest.utils.JsonUtils;

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
}
