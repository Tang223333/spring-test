package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Forum {
    private Long id;
    private Long aid;
    private Integer concerns;
    private Integer invitations;
    private Integer views;
    private String name;
    private String logo;
    private String ip;
}
