import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.DynamicMapper;
import tk.mybatis.simple.model.SysUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * test
 *
 * @author sukbear
 * @create 2018-12-10 21:09
 */
public class DynamicMapperTest extends BaseMapperTest {
    /* //更新测试
     @Test
     public void test(){
         SqlSession sqlSession = super.getSqlSession();
         DynamicMapper dynamicMapper = sqlSession.getMapper(DynamicMapper.class);
         SysUser user = new SysUser();
         user.setId(1L);
         user.setUserEmail("test@mybatis.tk");
         int result = dynamicMapper.updateByIdSelecttive(user);
         Assert.assertEquals(1,result);
     }*/
    /* insert if 测试*/
   /* @Test
    public void insertTest() {
        SqlSession sqlSession = super.getSqlSession();
        try {
            DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test-se");
            user.setUserPassword("123456");
            user.setUserInfo("test info");
            user.setCreateTime(new Date());

            mapper.insert(user);
            user = mapper.selectById(user.getId());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }*/

    /*@Test
    public void chooseWhenTest() {
        SqlSession sqlSession = super.getSqlSession();
        try {
            DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
            SysUser query = new SysUser();
            query.setId(1L);
            query.setUserName("admin");
            SysUser user = mapper.selectByIdOrByUserName(query);

            Assert.assertNotNull(user);

            //当没有id 时
            query.setId(null);
            user = mapper.selectByIdOrByUserName(query);
            Assert.assertNotNull(user);
            //当 id 和name都空时

            query.setUserName(null);
            user = mapper.selectByIdOrByUserName(query);
            Assert.assertNull(user);
        } finally {
            sqlSession.close();
        }
    }*/
//
  @Test
    public void foreachTest(){
      SqlSession sqlSession = super.getSqlSession();
      try {
          DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
          List<SysUser> userList = new ArrayList<>();
          for(int i = 0; i < 5;i++){
              SysUser user = new SysUser();
              user.setUserName("test"+i);
              user.setUserEmail("test@yk");
              user.setUserPassword("123456");
              userList.add(user);

              int result = mapper.insertList(userList);
              userList.stream().forEach(System.out::println);
          }
      }finally {
          sqlSession.rollback();
          sqlSession.close();
      }
    }
}
