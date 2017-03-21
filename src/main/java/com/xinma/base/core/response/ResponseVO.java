package com.xinma.base.core.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 该数据传输对象用于接口间调用返回响应的通用模型
 * 
 * @author Alauda
 *
 * @date 2015年7月5日
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseVO implements Serializable {

	private static final long serialVersionUID = -1157159645006381792L;

	private boolean success;

	@JsonProperty("data")
	private Object result;

	@JsonProperty("errors")
	private List<ErrorFiledEO> errors = new ArrayList<ErrorFiledEO>();

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<ErrorFiledEO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorFiledEO> errors) {
		this.errors = errors;
	}

	public void addError(ErrorFiledEO errorFiledDTO) {
		errors.add(errorFiledDTO);
	}

	public void addError(String code, String message) {
		errors.add(new ErrorFiledEO(code, message));
	}

	public ResponseVO() {
		super();
	}

	public ResponseVO(boolean success, Object result) {
		super();
		this.success = success;
		this.result = result;
	}

	public ResponseVO(boolean success, Object result, List<ErrorFiledEO> errors) {
		super();
		this.success = success;
		this.result = result;
		this.errors = errors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseVO other = (ResponseVO) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResponseDTO [success=" + success + ",result=" + result + ", errors=" + errors + "]";
	}

}
