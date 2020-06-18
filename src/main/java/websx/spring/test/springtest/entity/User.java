package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Long id;
    private String name;
    private String number;
    private String address;
    private Integer sex;
    private String style;
}
