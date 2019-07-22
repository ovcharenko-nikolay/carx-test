package com.carx.test.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "user_uuid")
    private UUID userUUID;
    @Column(name = "activity")
    private Integer activity;
    @Column(name = "create_date")
    private ZonedDateTime createDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "uuid=" + uuid +
                ", userUUID=" + userUUID +
                ", activity=" + activity +
                ", createDate=" + createDate +
                '}';
    }
}
