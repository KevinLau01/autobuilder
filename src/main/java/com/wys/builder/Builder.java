package com.wys.builder;


import java.io.File;
import java.util.*;

import com.wys.config.SetupConfig;
import com.wys.config.TemplateMapping;
import com.wys.core.BuildFactory;
import com.wys.jdbc.AbstractDaoSupport;
import com.wys.util.MyUtils;
import com.wys.util.StringUtil;

import static com.wys.util.MyUtils.mkdir;


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
		Set<String> ignoreSet=new HashSet(){{
			add("SysSku");
			add("SysSchool");
			add("CcUserQuestion");
			add("BizGroupBuyingDetails");
			add("BizStudentOrganization");
			add("BizFavorite");
			add("BizGroupBuying");
			add("BizPolicy");
			add("BizUrlTransform");
			add("BizCourseHistory");
			add("BizAppointment");
		}};

		TemplateMapping[] mappings = config.getMappings();
		List<String> tablesList = AbstractDaoSupport.getInstance().queryAllTables();
		for (TemplateMapping m : mappings) {
			// iterator all databases tables.
			System.out.println("template:>>>>>>>>>>>>>>>>>>>>>"+m.getTemplate());
			String packagePath = m.buildPackage(config.getGroupId(), config.getArtifactId());
			System.out.println("packagePath >>>>>>>>>>>>>>>>>:"+packagePath);

			for (String tableName : tablesList) {
				if(ignoreSet.contains(StringUtil.capFirst(StringUtil.javaStyle(tableName)))){continue;}
				if(m.getRpadding().equals("Controller") && StringUtil.isMappingTeble(tableName)){
					continue;
				}
				System.out.println("table:>>>>>>>>>>>>>>>>>>>>>>>>"+tableName);
				Map<String, Object> data = factory.getParams(tableName, packagePath);
				//模板数据添加进去做处理
				data.put("template", m);
				factory.build(MyUtils.getTemplatePath(m), data, MyUtils.getOutPutPath(m, tableName));

			}

		}

		//生成单个错误码常量文件
		/*模板所在路径*/
		String dir=config.getTemplateDir()  + "errcode.ftl";
		/*数据模型*/
		String packagePath="${groupId}/${artifactId}/constants".replaceAll("\\$\\{groupId\\}", config.getGroupId())
				.replaceAll("\\$\\{artifactId\\}", config.getArtifactId()).replaceAll("[\\/]", ".");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("packagePath", packagePath);
		/*生成文件路径*/
		String target_dir=SetupConfig.USER_DIR + SetupConfig.SEPARATOR+ "target" + SetupConfig.SEPARATOR+"results"+SetupConfig.SEPARATOR
				+packagePath.replaceAll("[\\.]", "\\/")+SetupConfig.SEPARATOR+"ErrCode.java";
		mkdir(target_dir);
		factory.build(dir, map, target_dir);

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
