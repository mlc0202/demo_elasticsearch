package com.fccs.es_demo.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ClientTemplate {

	private ClientTemplate() {
	}
	
	@SuppressWarnings("resource")
	public static  Client getLocalInstance() {
/*		return TransportClient.builder().build()
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("139.129.48.57"), 9300));*/
		try {
			return  TransportClient.builder().build()
			        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("139.129.48.57"), 9300));
//			        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static Client getInstance(String host, int port) {
		if (StringUtils.isBlank(host) || port == 0)
			throw new IllegalArgumentException();
		try {
			return  TransportClient.builder().build()
			        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("139.129.48.57"), 9300));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Client client) {
		if (client != null)
			client.close();
	}
	
}
