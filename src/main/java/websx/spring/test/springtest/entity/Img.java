package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Img {
    private Long id;
    private String iKeys;
    private String value;
}
