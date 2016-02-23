package com.fccs.es_demo.mapping;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;

import com.fccs.es_demo.client.ClientTemplate;

public class MappingTest {

	@Test
	public void mappingTest() throws IOException {
		Client client = ClientTemplate.getLocalInstance();
		client.admin().indices().prepareCreate("missxu").execute().actionGet();
		XContentBuilder mapping = XContentFactory.jsonBuilder()
			.startObject()  
	        	.startObject("user")
		        	.startObject("properties")         
			        	.startObject("title").field("type", "string").field("analyzer", "ik").endObject()    
			            .startObject("description").field("type", "string").field("analyzer", "ik").endObject()  
			            .startObject("price").field("type", "double").field("analyzer", "ik").endObject()  
			            .startObject("onSale").field("type", "boolean").field("analyzer", "ik").endObject()  
			            .startObject("type").field("type", "integer").field("analyzer", "ik").endObject()  
			            .startObject("createDate").field("type", "date").field("analyzer", "ik").endObject()                  
			        .endObject()  
	          .endObject()  
	     .endObject();
		PutMappingRequest mappingRequest = Requests.putMappingRequest("missxu").type("user").source(mapping);
		client.admin().indices().putMapping(mappingRequest).actionGet();
		
	}
	
	@Test
	public void mappingTest1() throws IOException {
		Client client = ClientTemplate.getLocalInstance();
		client.admin().indices().prepareCreate("missxu").execute().actionGet();
		XContentBuilder mapping = XContentFactory.jsonBuilder()
			.startObject()  
	        	.startObject("user")
		        	.startObject("properties")         
			        	.startObject("name").field("type", "string").field("analyzer", "ik").endObject() 
			            .startObject("age").field("type", "integer").field("analyzer", "ik").endObject()
			            .startObject("birthday1").field("type", "date").field("analyzer", "ik").endObject()                  
			        .endObject()  
	          .endObject()  
	     .endObject();
		PutMappingRequest mappingRequest = Requests.putMappingRequest("missxu").type("user").source(mapping);
		client.admin().indices().putMapping(mappingRequest).actionGet();
	}
	
}
