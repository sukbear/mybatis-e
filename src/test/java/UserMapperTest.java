import org.apache.ibatis.session.SqlSession;

import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.UserMapper;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.Date;
import java.util.List;

/**
 * test
 *
 * @author sukbear
 * @create 2018-12-10 16:49
 */

public class UserMapperTest extends BaseMapperTest {
    /*    @Test
       // 查询测试
        public void testSelectById() {
            SqlSession sqlSession = getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);
            System.out.println(user.toString());
        }*/
/*    @Test
    // 插入测试
    public void insertTest() {
        SqlSession sqlSession = super.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@123");
            user.setUserInfo("testInfo");
            user.setHeadImg(new byte[]{1, 2});
            user.setCreateTime(new Date());

            int result = userMapper.insert2(user);
            Assert.assertEquals(1, result);
            System.out.println(user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }*/
/*    @Test
    public void selectAllTest() {
        SqlSession sqlSession = super.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<SysUser> userList = userMapper.selectAll();
        userList.stream().forEach(System.out::println);

        List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
        roleList.stream().forEach(System.out::println);
    }

    @Test
    //关联查询测试
    public void test() {
        SqlSession sqlSession = super.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
        roleList.stream().forEach(System.out::println);
    }*/

   /* //更新测试
    @Test
    public void updateByIdTest() {
        SqlSession sqlSession = super.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            user.setUserName("admin_test");
            user.setUserEmail("admin@123");

            int result = userMapper.updateById(user);
            Assert.assertEquals(1, result);
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }*/
   //删除测试
  /* @Test
   public void deleteByIdTest(){
       SqlSession sqlSession = super.getSqlSession();
       try {
           UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
           SysUser user = userMapper.selectById(1L);
           Assert.assertNotNull(user);
           Assert.assertEquals(1,userMapper.deleteById(1L));
       }finally {
           sqlSession.rollback();
           sqlSession.close();
       }
   }*/
  @Test
  public void selectRolesByUserIdAndRoleEnabledTest(){
      SqlSession sqlSession = super.getSqlSession();
      try {
          UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
          SysUser user = userMapper.selectById(1L);
          SysRole role = new SysRole();
          role.setEnabled(1);
          List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabledUseJavaBean(user,role);
          Assert.assertNotNull(roleList);
      }finally {
          sqlSession.close();
      }
  }


}
