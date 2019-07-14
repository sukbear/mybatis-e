import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;

/***
 *@ClassName CustTest
 *@Description
 * @author sukbear
 * @create 2019-03-20 15:59
 */
public class CustTest extends BaseMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = super.getSqlSession();
        try {
            //利SqlSession完成查询操作,第一个参数是MappedStatement的id.注意namespace和配置的id唯一确定id.第二个参数是输入参数,对应配置文件的parameterType
            SysUser user = sqlSession.selectOne("tk.mybatis.simple.mapper.UserMapper.findUserByID", 1);
            Assert.assertNotNull(user);
            System.out.println(user.toString());
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
