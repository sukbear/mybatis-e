package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysUser;

import java.util.List;

/**
 * Advanced query
 *
 * @author sukbear
 * @create 2018-12-11 13:19
 */
public interface AdvancedQuery {
    SysUser selectUserAndRoleById(Long id);
    SysUser selectUserAndRoleByIdColumn(Long id);
    List<SysUser> selectAllUserAndRoles();
    List<SysUser> selectAllUserAndAllRoleAndPrivileges();
}
