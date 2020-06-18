package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class G_Comment {
    private Long id;
    private Long gid;
    private Long uid;
    private String content;
    private Integer goodOrBad;
    private Integer grade;
}
