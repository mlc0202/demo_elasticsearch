package com.fccs.es_demo.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;

public class TransportClientTest {

	@Test
	public void getClient() throws UnknownHostException {
		@SuppressWarnings("resource")
		Client client = TransportClient.builder().build()
        	.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host1"), 9300));
		System.out.println(client);
		client.close();
	}
	
	
}
