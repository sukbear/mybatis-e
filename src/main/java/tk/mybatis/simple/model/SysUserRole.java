package tk.mybatis.simple.model;

/**
 * user_role
 *
 * @author sukbear
 * @create 2018-12-10 17:36
 */
public class SysUserRole {
    private long userId;
    private long roleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
