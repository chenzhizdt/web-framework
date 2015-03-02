package org.instorm.web;


import java.net.InetSocketAddress;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerGroup;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextAware implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("******************************************************");
        // 连接超时的时限，单位为毫秒
        ClientGlobal.setG_connect_timeout(20000);
        // 网络超时的时限，单位为毫秒
        ClientGlobal.setG_network_timeout(0);
        ClientGlobal.setG_anti_steal_token(false);
        // 字符集
        ClientGlobal.setG_charset("UTF-8");
        ClientGlobal.setG_secret_key(null);
        // HTTP访问服务的端口号
        ClientGlobal.setG_tracker_http_port(8088);
        // Tracker服务器列表
        InetSocketAddress[] tracker_servers = new InetSocketAddress[1];
        tracker_servers[0] = new InetSocketAddress("114.80.9.11", 22122);
        ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));
	}
}
