package com.bootdo.common.domain;

import java.io.Serializable;


/**
* @description: 公司文化相关信息
* @creater:geyafei
* @updater:geyafei
* @create:  10:38
* @update:  10:38
* @Param: 
* @return: 
* @exception : 
*/
public class AboutInfoConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//类型
	private String type;
	//名称
	private String title;
	//作者
	private String author;
	//来源
	private String origin;
	//简介
	private String content;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
