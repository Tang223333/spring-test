package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Builder
@Data
public class GameComment {
    private Long id;
    private Long gid;
    private Long aid;
    private String content;
    private Integer goodOrBad;
    private Integer grade;
    private String ip;
    private Date time;
}
