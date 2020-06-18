package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class User {
    private long id;
    private String name;
    private String number;
    private String address;
    private Integer sex;
    private Date birthday;
    private Integer gameNum;
    private String logo;
    private String style;
    private Date time;
}
