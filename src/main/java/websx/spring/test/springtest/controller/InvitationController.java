package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Invitation;
import websx.spring.test.springtest.service.impl.InvitationService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/invitation")
@RestController
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllInvitation(){
        List<Invitation> allInvitation = invitationService.findAllInvitation();
        return JsonUtils.getJson(allInvitation,allInvitation!=null?0:1);
    }
}
