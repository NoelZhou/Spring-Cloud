package com.moxi.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Demo
{
    private int id;
    /*
     * 不想返回该属性, serialize:是否进行序列化
     */
    @JSONField(serialize = false)
    private String name;

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	//注解使用的包: com.alibaba.fastjson.annotation.JSONField
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}