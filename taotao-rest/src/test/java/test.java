import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.rest.component.JedisClient;

/**
 * 
 */

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 下午9:40:21 
* 类说明 ：
*/

/** 
* 
*/

public class test {
	@Test
	public void testJedisClientSpring() throws Exception {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		//jedisClient操作redis
		jedisClient.set("cliet1", "1000");
		String string = jedisClient.get("cliet1");
		System.out.println(string);
	}
}
