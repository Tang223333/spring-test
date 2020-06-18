package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Account {
    private Long id;
    private Long uid;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Date time;
    private Integer type;
}
