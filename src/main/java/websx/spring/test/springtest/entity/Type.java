package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Type {
    private String tKeys;
    private String value;
}
