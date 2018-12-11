package tk.mybatis.simple.model;

import java.util.Date;
import java.util.List;

/**
 * role
 *
 * @author sukbear
 * @create 2018-12-10 17:32
 */
public class SysRole {
    private long id;
    private String roleName;
    private Integer enabled;
    private long createBy;
    private Date createTime;
    private List<SysPrivilege> privilegeList;

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<SysPrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<SysPrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    private SysUser user;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
