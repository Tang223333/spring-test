package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class NewsCollect {
    private Long id;
    private Long nid;
    private Long aid;
    private Date time;
}
