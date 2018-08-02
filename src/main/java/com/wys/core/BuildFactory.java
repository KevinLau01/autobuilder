package com.wys.core;

import com.wys.config.SetupConfig;
import com.wys.jdbc.AbstractDaoSupport;
import com.wys.util.MyUtils;
import com.wys.util.PrimaryKeyMethod;
import com.wys.util.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;
/**
 * freemarker生成器Test
 * @author Yinglong Xu
 * @date 2012-2-16
 */
public class BuildFactory {
	private static final Map<String, Map<String, Object>> CACHE = new HashMap<String, Map<String, Object>>();
	private static SetupConfig config = SetupConfig.getInstance();
	private static AbstractDaoSupport dao = AbstractDaoSupport.getInstance();
	
	/**
	 * 配置属性
	 */
	private static Configuration cfg = new Configuration();

	/**
	 * 这里我设置模板的根目录
	 * @param dirPath 目录路径
	 */
	public static void setLoadingDir(String dirPath) {
		try {
			cfg.setDirectoryForTemplateLoading(new File(dirPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据模板生成文件
	 * 
	 * @param templateFile 
	 * @param obj 
	 * @param outFile 
	 */
	public void build(String templateFile, Object obj, String outFile) {
		try {
			System.out.println("生成文件:>>>>>>>>>>>>>>>>>>>>"+templateFile);
			Template t = cfg.getTemplate(templateFile);
			Writer out = new OutputStreamWriter(new FileOutputStream(outFile), "utf-8");
			t.process(obj, out);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * POJO数据准备
	 * @param tableName 
	 * @return Map 
	 */
	public Map<String, Object> getParams(String tableName, String packagePath) {
		if (CACHE.containsKey(tableName)) {
			Map<String, Object> map = CACHE.get(tableName);
//			map.put("model_package", MyUtils.buildModelPackage(tableName));
			map.put("package_path", packagePath);
			return map;
		}
		// 数据准备,可以是Map,List或者是实体
		System.out.println("tablename:"+tableName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("package_path", packagePath);
//		map.put("model_package", MyUtils.buildModelPackage(tableName));
		//分组名称
//		map.put("group_name", MyUtils.getGroupName(tableName));
		//map.put("group_name", "abc");
		map.put("table_name", tableName);
		map.put("sub_class_name",StringUtil.javaStyleOfTableName(tableName));
		map.put("class_name", StringUtil.javaStyle(tableName));
		map.put("isMappingTable",StringUtil.isMappingTeble(tableName));
		List<Column> columns = dao.queryColumns(tableName);
		map.put("table_column", columns);		// 设置数据
        map.put("primaryKeys",Column.getPrimaryKey(columns));
		map.put("hasDateColumn", Column.typeContains(columns, "Date"));		// 特殊字符处理
		//poImportList po里需要导入的包
		Set<String> poImportList = new HashSet<String>();
		MyUtils.buildPoImportList(poImportList,columns);
		map.put("poImportList", poImportList);
		
		map.put("artifactId", config.getArtifactId());
		map.put("groupId",config.getGroupId());
		map.put("author", config.getAuthor());
		map.put("sysDate", new Date());
//		map.put("getPrimaryKey",new PrimaryKeyMethod());
		CACHE.put(tableName, map);
		return map;
	}
}
