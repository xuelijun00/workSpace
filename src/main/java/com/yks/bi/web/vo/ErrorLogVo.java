package com.yks.bi.web.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ErrorLogVo implements Serializable {
	private List<String> messageArray;
	
	private List<Object> objectList;

	public List<String> getMessageArray() {
		return messageArray;
	}

	public void setMessageArray(List<String> messageArray) {
		this.messageArray = messageArray;
	}

	public List<Object> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}

}
