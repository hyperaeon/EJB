package com.jsf.luneer.ejbLearn.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jsf.luneer.ejbLearn.Hello;

public class EjbClient {

	public void test() throws NamingException {
		Context ctx = getInitialContext();
		Hello hello = (Hello) ctx.lookup("Hello#com.jsf.luneer.ejbLearn.Hello");
		System.out.println(hello.hello("妖精"));
	}

	private Context getInitialContext() {
		final String INIT_FACTORY = "weblogic.jndi.WLInitialContextFactory";
		final String SERVER_URL = "t3://localhost:7001";
		Context ctx = null;
		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, INIT_FACTORY);
			props.put(Context.PROVIDER_URL, SERVER_URL);
			ctx = new InitialContext(props);
		} catch (NamingException ne) {
			System.err.println("不能链接Weblogic");
			ne.printStackTrace();
		}
		return ctx;
	}

	public static void main(String[] args) throws NamingException {
		EjbClient client = new EjbClient();
		client.test();
	}
}
