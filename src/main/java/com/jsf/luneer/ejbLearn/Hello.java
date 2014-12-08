package com.jsf.luneer.ejbLearn;

import javax.ejb.Remote;

@Remote
public interface Hello {

	public String hello(String name);
}
