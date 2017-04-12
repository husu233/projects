package com.su.hpre.alipay;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.su.hpre.alipay.config.RootConfig;



/**
 * 
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 * 
 */
public class TestApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(RootConfig.class);
			MyApplication application = context.getBean(MyApplication.class);

			application.performDbTasks();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}	    
	}
}