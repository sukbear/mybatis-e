package tk.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * generator
 *
 * @author sukbear
 * @create 2018-12-11 10:44
 */
public class Generator {
    public static void main(String[] args) throws Exception{
        //执行过程中的警告信息
        List<String> warings = new ArrayList<>();
        //代码重复直接覆盖
        boolean overwrite = true;
        //读取配置文件
        InputStream is = Generator.class.getResourceAsStream("/generator/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warings);
        Configuration config = cp.parseConfiguration(is);
        //关闭流
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        //创建MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warings);

        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        warings.stream().forEach(System.out::println);
    }
}
