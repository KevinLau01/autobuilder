package com.wys.builder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wys.config.SetupConfig;
import com.wys.config.TemplateMapping;
import com.wys.core.BuildFactory;
import com.wys.jdbc.AbstractDaoSupport;
import com.wys.util.MyUtils;

/**
 * Builder Entry
 * @author xuyl
 * @date 2013-1-7
 */
public class Builder {
	/**
	 * freemarker factory
	 */
	private static BuildFactory factory = new BuildFactory();
	/**
	 * config instance
	 */
	private static SetupConfig config = SetupConfig.getInstance();
																												
	/**
	 * generate from all template files.
	 * @author xuyl
	 * @date 2013-1-7
	 */
	public void db2pojoEntry() {
		// iterator all template file
		TemplateMapping[] mappings = config.getMappings();
		List<String> tablesList = AbstractDaoSupport.getInstance().queryAllTables();
		for (TemplateMapping m : mappings) {
			// iterator all databases tables.
			System.out.println("template:>>>>>>>>>>>>>>>>>>>>>"+m.getTemplate());
			for (String tableName : tablesList) {
				System.out.println("talbe:>>>>>>>>>>>>>>>>>>>>>>>>"+tableName);
				String packagePath = m.buildPackage(config.getProject(), MyUtils.getModelName(tableName, "."));
				System.out.println("packagePath >>>>>>>>>>>>>>>>>:"+packagePath);
				Map<String, Object> data = factory.getParams(tableName, packagePath);
				//模板数据添加进去做处理
				data.put("template", m);
				factory.build(MyUtils.getTemplatePath(m), data, MyUtils.getOutPutPath(m, tableName));
				
			}
		}
		//生成mybatis总配置文件
		Map<String, Object> root = new HashMap<>();
		root.put("xmlList", MyUtils.xmlFileList);
		String xmlOutPut =  SetupConfig.USER_DIR + SetupConfig.SEPARATOR 
				+ "target" + SetupConfig.SEPARATOR + "mapper/mybatis-config.xml" ;
		factory.build(config.getTemplateDir() + File.separator+"mybatis-config.ftl",root,xmlOutPut);
	}
	
	/**
	 * main entry
	 * @param args
	 */
	public static void main(String[] args) {
		new Builder().db2pojoEntry();
		System.out.println("Congratulations! Your code generate successfully....^_^.....");
	}
}