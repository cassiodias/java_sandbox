package br.com.webtest.modulo1.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHelper {
	private static ApplicationContext bf;

	public synchronized static ApplicationContext getApplicationContext() {
        if (bf == null)
            try {
                bf = new FileSystemXmlApplicationContext(new String[] { "web/WEB-INF/applicationWebTestContext.xml"});
            } catch (Throwable t) {
                t.printStackTrace();
                throw new RuntimeException(t.getMessage());
            }
        return bf;
    }
}
