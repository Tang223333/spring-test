package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Type {
    private Long id;
    private String tKeys;
    private String value;
}
