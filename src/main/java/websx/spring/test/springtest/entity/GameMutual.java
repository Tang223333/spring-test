package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GameMutual {
    private Long gid;
    private Double collects;
    private Double comments;
    private Double goods;
    private Double bads;
    private  Integer grades;
}
