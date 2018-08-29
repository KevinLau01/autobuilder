package com.wys.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wys.core.Column;
import com.wys.util.StringUtil;
import org.springframework.context.annotation.Primary;

/**
 * MySQL database Dao
 * @author xuyl
 * @date 2013-1-7
 */
public class MysqlDao extends AbstractDaoSupport {
	
	@Override
	public List<String> queryAllTables() {
		return queryAllTables("show tables");
	}

	@Override
	public List<Column> queryColumns(String tableName) {
		List<Column> list = new ArrayList<Column>();
		try {
			checkDriver();
			Connection conn = getConn();
			ResultSet rs = createQuary(conn, "show full fields from " + tableName);
			while (rs.next()) {
				String jdbcType=rs.getString(2);
				jdbcType=jdbcType.substring(0,jdbcType.indexOf('(')==-1?jdbcType.length():jdbcType.indexOf('(')).toUpperCase();
				String type = typesConvert(rs.getString(2));
				String name=rs.getString(1);
				String nameJ = StringUtil.javaStyle(rs.getString(1));
				String remark= rs.getString(9);
				String index=rs.getString(5);
				list.add(new Column(name,jdbcType,index,remark,nameJ,type));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public String typesConvert(String mysqlType) {
		if (mysqlType.startsWith("varchar") || mysqlType.startsWith("longtext")) {
			return "String";
		} else if (mysqlType.startsWith("bigint") ) {
			return "Long";
		}else if (mysqlType.startsWith("int") || mysqlType.contains("int")) {
			return "Integer";
		} else if (mysqlType.startsWith("double")) {
			return "Double";
		} else if (mysqlType.startsWith("date") || mysqlType.startsWith("timestamp")) {
			return "Date";
		}else if(mysqlType.contains("text") || mysqlType.contains("char") || mysqlType.startsWith("enum") ){
			return "String";
		}else if(mysqlType.startsWith("decimal")){
			return "BigDecimal";
		} else{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>新发现要处理的类型:"+mysqlType);
		}
		
		return mysqlType;
	}


	/**
	 * 测试入口
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractDaoSupport dao = new MysqlDao();
		List<String> tables = dao.queryAllTables();
		System.out.println(tables);
		List<Column> list = dao.queryColumns(tables.get(0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
