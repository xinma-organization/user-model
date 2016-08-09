package com.xinma.base.core.logger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Marker;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.MNSClient;
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

	private MNSClient mnsClient = null;

	@Override
	public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
		if (t instanceof CustomException) {
			// TODO
		}

		return FilterReply.ACCEPT;
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

		mnsClient = new CloudAccount(accessId, accessKey, endpoint).getMNSClient();

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

}
