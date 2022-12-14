package com.d.tradeserver.pojo;

import java.time.LocalDateTime;

/**
 * @author: Ding
 * @date: 2022/10/27 10:28
 * @description:
 * @modify:
 */


public class Major {


    private Integer id;

    private String name;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
