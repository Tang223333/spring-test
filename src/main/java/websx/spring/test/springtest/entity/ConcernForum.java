package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ConcernForum {
    private Long id;
    private Long fid;
    private Long aid;
    private Date time;
}
