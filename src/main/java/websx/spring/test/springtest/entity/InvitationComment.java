package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class InvitationComment {
    private Long id;
    private Long iid;
    private Long aid;
    private String content;
    private Date time;
    private Object imgs;
    private Object videos;
    private String ip;
}
