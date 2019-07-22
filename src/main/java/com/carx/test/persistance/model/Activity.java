package com.carx.test.persistance.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Activity {

    private UUID uuid;
    private UUID userUUID;
    private Integer activity;
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
