package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

/**
 * sql
 *
 * @author sukbear
 * @create 2018-12-10 20:55
 */
public interface DynamicMapper {
    int updateByIdSelecttive(SysUser sysUser);

    int insert(SysUser sysUser);

    SysUser selectById(Long id);

    SysUser selectByIdOrByUserName(SysUser sysUser);

    List<SysUser> selectByUser(SysUser sysUser);

    int insertList(List<SysUser> userList);
}
