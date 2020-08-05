package com.example.shadowp.project.user.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author aquarius_cxr
 * @Date 2020/7/18 17:24
 */

@Data
//@ToString
//@Accessors(chain = true)
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long tenantId;

    private String userName;

    private String passWord;

    private String roleName;

    private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", roleName='" + roleName + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
