package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

/**
 * usermapper
 *
 * @author sukbear
 * @create 2018-12-10 16:31
 */
public interface UserMapper {
    SysUser selectById(Long id);

    int insert(SysUser sysUser);

    int insert2(SysUser sysUser);

    int insert3(SysUser sysUser);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    int updateById(SysUser sysUser);

    int deleteById(Long id);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);
    List<SysRole> selectRolesByUserIdAndRoleEnabledUseJavaBean(@Param("user") SysUser user, @Param("role") SysRole role);
}
