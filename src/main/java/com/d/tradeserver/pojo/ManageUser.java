package com.d.tradeserver.pojo;

import java.time.LocalDateTime;

/**
 * @author: Ding
 * @date: 2022/10/16 17:59
 * @description: 对应 manage_user 表
 * @modify:
 */


public class ManageUser {

    private Integer id;

    private String username;

    private String password;

    private School school;

    /**
     * 单位：分
     */
    private Integer sessionAge;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    public ManageUser() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
