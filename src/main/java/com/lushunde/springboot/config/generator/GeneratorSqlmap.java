package com.lushunde.springboot.config.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * 
 * @node 
 * @package springboot com.lushunde.springboot.config.generator 
 * @version 1.0
 * @date 2020年6月7日
 * @author bellus
 * @since JDK1.8
 */
public class GeneratorSqlmap {

	
	/**
	 * 实用mybatis反向生成入口
	 * @throws Exception
	 * @author： bellus 2020年6月7日
	 */
    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //ָ
        File configFile = new File("./src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    } 
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("逆向工程 开始执行...");
            long curr = System.currentTimeMillis();
        	GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
            System.out.println("逆向工程 执行完毕，用时："+(System.currentTimeMillis()- curr)+" ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}
