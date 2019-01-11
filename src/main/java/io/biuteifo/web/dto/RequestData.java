package io.biuteifo.web.dto;

import java.io.Serializable;
import java.util.Map;

import io.biuteifo.web.utils.TextUtils;

/**
 * 请求报文模型
 * 
 * @author <a href="mailto:632635114@qq.com">luojun</a>
 * @date 2019年1月11日
 * @version 0.0.1
 */
public final class RequestData implements Serializable {

	private String id, name, // 基础数据
			startDate, endData, // 时间
			pageIndex, pageSize; // 分页

	public static final void notNull(Map<String, ?> requestData, String... strings) throws NullPointerException {
		for (String string : strings) {
			if (TextUtils.isEmpty(requestData.get(string))) {
				throw new NullPointerException(String.format("请求参数{%s}不能为空", string));
			}
		}
	}

	public static final void notNull(RequestData requestData, String... strings) throws NullPointerException {
		for (String string : strings) {
			switch (string) {
			case "id":
				if (TextUtils.isEmpty(requestData.getId())) {
					throw new NullPointerException(String.format("请求参数{%s}不能为空", "id"));
				}
				break;
			case "name":
				if (TextUtils.isEmpty(requestData.getName())) {
					throw new NullPointerException(String.format("请求参数{%s}不能为空", "name"));
				}
				break;
			case "startDate":
				if (TextUtils.isEmpty(requestData.getStartDate())) {
					throw new NullPointerException(String.format("请求参数{%s}不能为空", "startDate"));
				}
				break;
			case "endData":
				if (TextUtils.isEmpty(requestData.getEndData())) {
					throw new NullPointerException(String.format("请求参数{%s}不能为空", "endData"));
				}
				break;
			case "pageIndex":
				if (TextUtils.isEmpty(requestData.getPageIndex())) {
					throw new NullPointerException(String.format("请求参数{%s}不能为空", "pageIndex"));
				}
				break;
			case "pageSize":
				if (TextUtils.isEmpty(requestData.getPageSize())) {
					throw new NullPointerException(String.format("请求参数{%s}不能为空", "pageSize"));
				}
				break;
			default:
				break;
			}
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndData() {
		return endData;
	}

	public void setEndData(String endData) {
		this.endData = endData;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
}
