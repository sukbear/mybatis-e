package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;

/**
 * mapper
 *
 * @author sukbear
 * @create 2018-12-10 21:37
 */
public interface RoleMapper {
    SysRole selectById(Long id);
}
