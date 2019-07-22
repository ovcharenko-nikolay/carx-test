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
    @Column(name = "date")
    private ZonedDateTime date;

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

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", json='" + json + '\'' +
                ", money=" + money +
                ", country='" + country + '\'' +
                ", activities=" + activities +
                ", date=" + date +
                '}';
    }
}
