package com.banhujiu.mybatis.page;

import java.util.List;

/**
 * @author banhujiu
 * @date 2017/12/12 0012 10:39
 */
public abstract class AbstractPageBean<T> implements PageBean<T> {
	private Integer count;
	private Boolean catFlag = false;
	private Integer totalPage;
	private Integer pageSize = 20;
	private List<T> data;
	private Integer page = 1;

	@Override
	public void setCount(Integer count) {
		this.count = count;
		if (count == null) {
			return;
		}
		if (this.catFlag) {
			this.totalPage = count % this.pageSize == 0 ? count / this.pageSize : count / this.pageSize + 1;
		} else {
			this.totalPage = 1;
			this.pageSize = this.count;
		}
	}

	@Override
	public Integer getCount() {
		return count;
	}

	@Override
	public Boolean getCatFlag() {
		return catFlag;
	}

	public void setCatFlag(Boolean catFlag) {
		this.catFlag = catFlag;
	}

	@Override
	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public List<T> getData() {
		return data;
	}

	@Override
	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}
