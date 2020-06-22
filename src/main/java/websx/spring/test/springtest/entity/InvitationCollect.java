package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class InvitationCollect {
    private Long id;
    private Long iid;
    private Long aid;
    private Date time;
}
