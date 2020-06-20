package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Video {
    private Long id;
    private String vKeys;
    private String value;
}
