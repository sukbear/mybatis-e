import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.AdvancedQuery;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

/**
 * test
 *
 * @author sukbear
 * @create 2018-12-11 13:41
 */
public class AdvancedQueryTest extends BaseMapperTest{
    @Test
    public void test(){
        SqlSession sqlSession = super.getSqlSession();
        try {
            AdvancedQuery mapper = sqlSession.getMapper(AdvancedQuery.class);

            List<SysUser> userList = mapper.selectAllUserAndAllRoleAndPrivileges();
            System.out.println("用户数"+userList.size());
            for(SysUser user : userList){
                System.out.println("用户名："+user.getUserName());
                for(SysRole role: user.getRoleList()){
                    System.out.println("角色名："+role.getRoleName());
                    for(SysPrivilege sp : role.getPrivilegeList()){
                        System.out.println("权限名："+sp.getPrivilegeName());
                    }
                }
            }

        }finally {
            sqlSession.close();
        }
    }
}
