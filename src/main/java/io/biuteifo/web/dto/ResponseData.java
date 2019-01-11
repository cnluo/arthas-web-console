package io.biuteifo.web.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 响应报文模型
 * 
 * @author <a href="mailto:632635114@qq.com">luojun</a>
 * @date 2019年1月11日
 * @version 0.0.1
 */
public class ResponseData implements Serializable {

	public static final String MSG_SUCCESS = "SUCCESS";

	private int code;
	private String msg;
	private Map<?, ?> data;

	public ResponseData() {
		this.code = 200;
		this.msg = MSG_SUCCESS;
	}

	public ResponseData(Map<?, ?> data) {
		this.code = 200;
		this.msg = MSG_SUCCESS;
		this.data = data;
	}

	public ResponseData(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResponseData(int code, String msg, Map<?, ?> data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<?, ?> getData() {
		return data;
	}

	public void setData(Map<?, ?> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
}
