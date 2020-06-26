package websx.spring.test.springtest.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class UserAccount {
    private Long id;
    private String name;
    private String number;
    private String address;
    private Integer sex;
    private Date birthday;
    private String style;
    private String accountName;
    private String password;
    private String email;
    private String phone;
    private java.util.Date time;
    private Integer type;
    private Integer status;
    private String logo;
}
