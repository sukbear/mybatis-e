package tk.mybatis.simple.mapper;

import java.util.List;
import tk.mybatis.simple.model.SysPrivilege;

public interface SysPrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilege record);

    SysPrivilege selectByPrimaryKey(Long id);

    List<SysPrivilege> selectAll();

    int updateByPrimaryKey(SysPrivilege record);
}