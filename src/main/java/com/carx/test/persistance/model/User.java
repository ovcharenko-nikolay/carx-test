package com.carx.test.persistance.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "json")
    private String json;
    @Column(name = "money")
    private Integer money;
    @Column(name = "country")
    private String country;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_uuid")
    private List<Activity> activities;
    @Column(name = "create_date")
    private ZonedDateTime createDate;
    @Column(name = "update_date")
    private ZonedDateTime updateDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", json='" + json + '\'' +
                ", money=" + money +
                ", country='" + country + '\'' +
                ", activities=" + activities +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
