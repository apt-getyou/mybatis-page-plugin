package com.banhujiu.mybatis.page;

import java.util.List;

/**
 * @author banhujiu
 * @date 2017/12/11 0011 15:42
 */
public interface PageBean<T> {

	Boolean getCatFlag();

	void setCount(Integer count);

	void setData(List<T> object);

	List<T> getData();

	Integer getPage();

	Integer getPageSize();
}
