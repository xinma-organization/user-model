package com.xinma.base.core.logger;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Marker;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ClientException;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinma.base.core.exceptions.CustomException;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;

public class MnsLogBackFilter extends TurboFilter {

	String endpoint;

	String accessId;

	String accessKey;

	String queueName;

	private CloudAccount mnsAccount = null;
	private MNSClient mnsClient = null;
	private CloudQueue logQueue = null;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
		try {
			if (t != null && t instanceof CustomException) {
				CustomException ce = (CustomException) t;

				CustomErrorLogTO errorLog = new CustomErrorLogTO();
				errorLog.setErrorCode(ce.getError());
				if (ce.getParams() != null && ce.getParams().length > 0) {
					// 调用第三方返回错误代码记录
					errorLog.setParams(Arrays.asList(ce.getParams()));
				}

				Message message = new Message(objectMapper.writeValueAsBytes(errorLog));
				logQueue.putMessage(message);
			}

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();

			mnsClient = mnsAccount.getMNSClient();
			logQueue = mnsClient.getQueueRef(queueName);
			if (logQueue == null) {
				System.err.println("the log queue name " + queueName + "isn't exist.");
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return FilterReply.NEUTRAL;
	}

	@Override
	public void start() {
		if (StringUtils.isBlank(accessId)) {
			System.err.println("accessId not allowed blank.");
		}

		if (StringUtils.isBlank(accessKey)) {
			System.err.println("accessKey not allowed blank.");
		}

		if (StringUtils.isBlank(endpoint)) {
			System.err.println("endpoint not allowed blank.");
		}

		if (StringUtils.isBlank(queueName)) {
			System.err.println("queueName not allowed blank.");
		}
		mnsAccount = new CloudAccount(accessId, accessKey, endpoint);
		mnsClient = mnsAccount.getMNSClient();
		logQueue = mnsClient.getQueueRef(queueName);
		if (logQueue == null) {
			System.err.println("the log queue name " + queueName + "isn't exist.");
		}
		System.out.println("mns client has success created.");
		super.start();
	}

	@Override
	public void stop() {
		if (mnsClient != null && mnsClient.isOpen()) {
			mnsClient.close();
			System.out.println("mns client has success destroyed.");
		}
		super.stop();
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
}
