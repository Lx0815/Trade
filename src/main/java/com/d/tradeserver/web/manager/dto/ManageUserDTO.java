package com.d.tradeserver.web.manager.dto;

import com.d.tradeserver.pojo.ManageUser;
import com.d.tradeserver.pojo.School;
import com.d.tradeserver.web.common.response.DTO;

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

    private School school;

    private Integer sessionAge;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    public ManageUserDTO(ManageUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.sessionAge = user.getSessionAge();
        this.school = user.getSchool();
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
