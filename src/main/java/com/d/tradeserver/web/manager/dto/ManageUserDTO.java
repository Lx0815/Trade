package com.d.tradeserver.manager.web.dto;

import com.d.tradeserver.common.web.response.DTO;
import com.d.tradeserver.manager.pojo.ManageUser;

import java.time.LocalDateTime;

/**
 * @author: Ding
 * @date: 2022/10/17 17:48
 * @description:
 * @modify:
 */


public class ManageUserDTO implements DTO {

    private Integer id;

    private String username;

    private Integer schoolId;

    private Integer sessionAge;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    public ManageUserDTO(ManageUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.sessionAge = user.getSessionAge();
        this.schoolId = user.getSchoolId();
        this.updateDateTime = user.getUpdateDateTime();
        this.createDateTime = user.getCreateDateTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getSessionAge() {
        return sessionAge;
    }

    public void setSessionAge(Integer sessionAge) {
        this.sessionAge = sessionAge;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
