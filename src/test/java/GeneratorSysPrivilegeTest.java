import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.mapper.SysPrivilegeMapper;
import tk.mybatis.simple.model.SysPrivilege;

/**
 * test
 *
 * @author sukbear
 * @create 2018-12-11 12:36
 */
public class GeneratorSysPrivilegeTest extends BaseMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = super.getSqlSession();
        try {
            SysPrivilegeMapper mapper = sqlSession.getMapper(SysPrivilegeMapper.class);
            SysPrivilege privilege = mapper.selectByPrimaryKey(1L);
            System.out.println(privilege.getId());
            System.out.println(privilege.getPrivilegeName());
            System.out.println(privilege.getPrivilegeUrl());
        } finally {
            sqlSession.close();
        }
    }
}
