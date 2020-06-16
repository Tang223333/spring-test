package websx.spring.test.springtest.entity;

import java.sql.Date;

public class User {
    private long id;
    private String name;
    private String number;
    private String address;
    private Integer sex;
    private Date birthday;
    private Integer gameNum;
    private String logo;
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGameNum() {
        return gameNum;
    }

    public void setGameNum(Integer gameNum) {
        this.gameNum = gameNum;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User(long id, String name, String number, String address, Integer sex, Date birthday, Integer gameNum, String logo, Date time) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.gameNum = gameNum;
        this.logo = logo;
        this.time = time;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", gameNum=" + gameNum +
                ", logo='" + logo + '\'' +
                ", time=" + time +
                '}';
    }
}
