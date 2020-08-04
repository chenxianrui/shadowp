package com.example.shadowp.project.role.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/4 20:53
 */
@Data
public class Permissions {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String permissionsName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
}
