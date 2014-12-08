package com.jsf.luneer.ejbLearn;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless(mappedName="Hello")
public class HelloBean implements Hello {

	@Override
	public String hello(String name) {
		return name + ",您好，现在时间是"
				+ new Date();
	}

}
