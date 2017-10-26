package background;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.PlayerDAO;
import com.mongodb.DBObject;

public class TestGet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring/*.xml");
		final PlayerDAO playerDAO = (PlayerDAO) ac.getBean("playerDAO");
		long start = System.currentTimeMillis();
		final HashMap<String, ArrayList<DBObject>> map = new HashMap<>();
		ExecutorService pool=Executors.newFixedThreadPool(100);
		for (int i = 1; i <= 1000; ++i) {
			pool.execute(new Runnable() {

				@Override
				public void run() {
					ArrayList<DBObject> list = map.get("16-17 马刺");
				
							
					list = playerDAO.getPlayersBySeason_Team("16-17", "马刺");
							
							
						
						
					
					//System.out.println(list);

				}}
			);
			

		}
		pool.shutdown();
		pool.awaitTermination(10000, TimeUnit.SECONDS);
		System.out.print(System.currentTimeMillis() - start);

	}

}
