package generator;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap {

	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		
		File configFile = new File("src/generator/generatorConfig.xml"); 
		
		System.out.println(configFile.getAbsolutePath());
		
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		//������
		myBatisGenerator.generate(null);

	} 
	/**
	 * 如果运行之前对应的mapper.xml已经存在，会生成重复代码。(之前的xml代码被顶到xml文件后面去了)
	 * 若不注释此main方法，操作失误又把generator运行一遍你就GG。
	 * @param args
	 * @throws Exception
	 */
/*	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

}
