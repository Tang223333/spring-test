package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class GameCollect {
    private Long id;
    private Long gid;
    private Long aid;
    private Date time;
}
