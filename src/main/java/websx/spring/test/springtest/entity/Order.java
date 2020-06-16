package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
public class Order {
    private Long id;
    private Long aid;
    private Long gid;
    private Integer type;
    private Date time;

    public Order(Long id, Long aid, Long gid, Integer type, Date time) {
        this.id = id;
        this.aid = aid;
        this.gid = gid;
        this.type = type;
        this.time = time;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", aid=" + aid +
                ", gid=" + gid +
                ", type=" + type +
                ", time=" + time +
                '}';
    }
}
