package com.yks.bi.web.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class MessageVo implements Serializable {
	private static ObjectMapper json = new ObjectMapper();
	private int status;
	private String message;
	private List<String> messageArray;
	
	public String toString(){
		try {
			return json.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public MessageVo(){}
	
	public MessageVo(int status,String message){
		this.status = status;
		this.message = message;
	}

	public MessageVo(int status,String message,List<String> messageArray){
		this.status = status;
		this.message = message;
		this.messageArray = messageArray;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessageArray() {
		return messageArray;
	}

	public void setMessageArray(List<String> messageArray) {
		this.messageArray = messageArray;
	}
	
}
