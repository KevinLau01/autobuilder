package com.wys.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.wys.config.Group;
import com.wys.config.SetupConfig;
import com.wys.config.TemplateMapping;
import com.wys.core.Column;

/**
 * 工具类
 * @author xuyl
 * @date 2013-2-28
 */
public class MyUtils {
	/**
	 * config instance
	 */
	private static SetupConfig config = SetupConfig.getInstance();
	public static List<String> xmlFileList = new ArrayList<String>();
	
	/**
	 * freemarker template file path
	 * @author xuyl
	 * @date 2013-1-30
	 * @param m
	 * @return
	 */
	public static String getTemplatePath(TemplateMapping m) {
		return config.getTemplateDir() + File.separator + m.getTemplate();
	}

	/**
	 * witch group contains tableName
	 * @author xuyl
	 * @date 2013-2-28
	 * @param tableName
	 * @return
	 */
	public static String getGroupName(String tableName) {
		Group[] groups = config.getGroups();
		String name;
		for (Group g : groups) {
			name = g.findGroupName(tableName);
			if (name != null) return name;
		}
		return null;
	}
	
	/**
	 * model name of project.(default: group name and tableName in java style )
	 * @author xuyl
	 * @date 2013-1-8
	 * @param tableName
	 * @return
	 */
//	public static String getModelName(String tableName, String separator) {
//		String g = getGroupName(tableName);
//		if (g == null) {
//			return StringUtil.javaStyleOfTableName(tableName);
//		}
//		return g + separator + StringUtil.javaStyleOfTableName(tableName);
//	}
	
	
	
	/**
	 * generate output file path.
	 * @author xuyl
	 * @date 2013-1-7
	 * @param m
	 * @param tableName
	 * @return
	 */
	public static String getOutPutPath(TemplateMapping m, String tableName) {
		String path = SetupConfig.USER_DIR + SetupConfig.SEPARATOR 
				+ "target" + SetupConfig.SEPARATOR+"results"+SetupConfig.SEPARATOR
				+ m.buildDir(config.getGroupId(), config.getArtifactId()) + SetupConfig.SEPARATOR;
		String xmlPath =m.buildDir(config.getGroupId(), config.getArtifactId()) + "/";

		//如果为固定文件名，不加前后缀
		if(m.isFixedName()){
			String fileName = (m.getFileName()!=null && m.getFileName().trim().length() > 0) ? m.getFileName():"xxxxxxx";		
			path += fileName + "." + m.getSuffix();
			xmlPath += fileName + "." + m.getSuffix();
		}else{
			path += m.getLpadding() + StringUtil.capFirst(StringUtil.javaStyle(tableName)) + m.getRpadding() + "." + m.getSuffix();
			xmlPath += m.getLpadding() +  StringUtil.capFirst(StringUtil.javaStyle(tableName)) + m.getRpadding() + "." + m.getSuffix();
		}
		
		
		if("xml".equals(m.getSuffix())){
			
			xmlFileList.add(xmlPath);
		}
		
		System.out.println("outPutPath>>>>>>>>>>>>>>>:"+path);
		mkdir(path);
		return path;
		
	}
	
	/**
	 * mkdir by path if not exist
	 * @author xuyl
	 * @date 2013-1-7
	 * @param filePath
	 */
	public static void mkdir(String filePath) {
		int index = filePath.lastIndexOf("\\");
		int index2 = filePath.lastIndexOf("/");
		if (index + index2 == -2) return;
		index = index > index2 ? index : index2;
		if (index != -1 && !new File(filePath.substring(0, index)).exists()) {
			System.out.println("mkdir - "+ filePath.substring(0, index) );
			new File(filePath.substring(0, index)).mkdirs();
		}
	}
	
	/**
	 * project + group + tableName
	 * @author xuyl
	 * @date 2013-2-28
	 * @return
	 */
//	public static String buildModelPackage(String tableName) {
//		return config.getArtifactId().replaceAll(".",File.separator) + "." +getModelName(tableName, ".");
//	}

	public static void buildPoImportList(Set<String> poImportSet,
			List<Column> columns) {
		if(columns == null || columns.size() == 0)
			return ;
		
		for (Column c : columns) {
			if (c.getType().equals("BigDecimal")) {
				poImportSet.add("java.math.BigDecimal");
			}
		}
		
		
		
		
		
	}
}
