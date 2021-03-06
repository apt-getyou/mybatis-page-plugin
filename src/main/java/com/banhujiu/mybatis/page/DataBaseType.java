package com.banhujiu.mybatis.page;

/**
 * @author banhujiu
 * @date 2017/12/11 0011 15:44
 */
public enum DataBaseType {
	ORACLE {
		@Override
		public String getLimitSql(String sql, PageBean<?> pageBean) {
			StringBuilder pageSql = new StringBuilder(100);
			String beginrow = String.valueOf((pageBean.getPage() - 1) * pageBean.getPageSize());
			String endrow = String.valueOf(pageBean.getPage() * pageBean.getPageSize());
			pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
			pageSql.append(sql);
			pageSql.append(" ) temp where rownum <= ").append(endrow);
			pageSql.append(") where row_id > ").append(beginrow);
			return pageSql.toString();
		}
	},
	MYSQL {
		@Override
		public String getLimitSql(String sql, PageBean<?> pageBean) {
			StringBuilder pageSql = new StringBuilder(100);
			String beginrow = String.valueOf((pageBean.getPage() - 1) * pageBean.getPageSize());
			pageSql.append(sql);
			pageSql.append(" limit ").append(beginrow).append(",").append(pageBean.getPageSize());
			return pageSql.toString();
		}
	};

	/**
	 * 初始化数据库类型
	 */
	public static DataBaseType initDataBaseType(String dataBaseType) {
		if (dataBaseType == null || "".equals(dataBaseType)) {
			throw new UnsupportedDataBaseTypeException();
		}
		for (DataBaseType baseType : DataBaseType.values()) {
			if (baseType.toString().equalsIgnoreCase(dataBaseType)) {
				return baseType;
			}
		}
		throw new UnsupportedDataBaseTypeException();
	}

	/**
	 * 获取切分语句
	 */
	public abstract String getLimitSql(String sql, PageBean<?> pageBean);
}
