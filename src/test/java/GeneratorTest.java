import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.dao.SysUserMapper;
import test.model.SysUser;

import java.util.List;

/**
 * test
 *
 * @author sukbear
 * @create 2018-12-11 11:06
 */
public class GeneratorTest extends BaseMapperTest{
    @Test
    public void test(){
        SqlSession sqlSession = super.getSqlSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> userList = mapper.selectAll();
            userList.stream().forEach(System.out::println);
        }finally {
            sqlSession.close();
        }
    }
}
