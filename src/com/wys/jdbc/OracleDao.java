package com.wys.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wys.core.Column;
import com.wys.util.StringUtil;

/**
 * MySQL database Dao
 * @author xuyl
 * @date 2013-1-7
 */
public class OracleDao extends AbstractDaoSupport {
	
	@Override
	public List<String> queryAllTables() {
		return queryAllTables("select lower(tname) from tab where tabtype = 'TABLE' order by 1");
	}

	@Override
	public List<Column> queryColumns(String tableName) {
		List<Column> list = new ArrayList<Column>();
		try {
			checkDriver();
			Connection conn = getConn();
			String sql = 
					"select  lower(t1.column_name), lower(t1.data_type),  t2.comments,lower(t1.data_scale) " +
					" from  user_col_comments  t2  left  join  user_tab_columns  t1 " + 
					" on  t1.table_name  =  t2.table_name  and  t1.column_name  =  t2.column_name " + 
					" where  t1.table_name  =  upper('"+tableName+"')"; 
			System.out.println("sql:"+sql);
			ResultSet rs = createQuary(conn, sql);
			while (rs.next()) {
				String type = typesConvert(rs.getString(2),rs.getInt(4));
				String jdbcType = jdbcTypeConvert(type); //jdbctype 解决oracle的插入空值 
				String javaStyle = StringUtil.javaStyle(rs.getString(1));
				list.add(new Column(type, rs.getString(1), javaStyle, rs.getString(3),jdbcType));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * java 类型转jdbc类型  oracle
	 * 需要完善
	 * @param type
	 * @return
	 */
	private String jdbcTypeConvert(String type) {
		//新发现的类型单独处理
		if("String".equals(type))
			return "VARCHAR";
		
		if("Date".equals(type))
			return "TIMESTAMP";
		
		return type.trim().toUpperCase();
		
	}

	private String typesConvert(String sqltype, Integer scale) {
		if(sqltype.startsWith("number") && scale > 0)
			return "Double";
		
		return typesConvert(sqltype);
	}

	@Override
	public String typesConvert(String mysqlType) {
		if (mysqlType.startsWith("varchar") || mysqlType.startsWith("char")) {
			return "String";
		} else if (mysqlType.startsWith("long")) {
			return "Integer";
		} else if (mysqlType.startsWith("number")) {
			System.out.println("mysqlType:"+mysqlType);
			return "Integer";
		} else if (mysqlType.startsWith("date")) {
			return "Date";
		} 
		return mysqlType;
	}
	
	/**
	 * 测试入口
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractDaoSupport dao = new OracleDao();
		System.out.println(dao.queryAllTables());
		List<Column> list = dao.queryColumns("sys_city");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
