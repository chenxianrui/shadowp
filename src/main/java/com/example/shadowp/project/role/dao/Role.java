package com.example.shadowp.project.role.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Set;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/4 20:50
 */
@Data
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long tanentId;

    private String roleName;

    private Set<Permissions> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTanentId() {
        return tanentId;
    }

    public void setTanentId(Long tanentId) {
        this.tanentId = tanentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}
