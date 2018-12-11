import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.mapper.RoleMapper;
import tk.mybatis.simple.model.SysRole;

/**
 * test
 *
 * @author sukbear
 * @create 2018-12-10 21:40
 */

public class RoleMapperTest extends BaseMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = super.getSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        SysRole sysRole = roleMapper.selectById(1L);
    }
}
