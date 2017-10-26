package background;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import po.Player;
import po.SeasonPre;
import po.SeasonSum;
import utils.FormatUils;
import utils.JsopUtil;
//把所有球员按照每个赛季数据分库
public class Fenku {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring/spring-config.xml");
		final MongoTemplate mongoTemplate= (MongoTemplate) ac.getBean("mongoTemplate");
		final long start=System.currentTimeMillis();
		ExecutorService threadPool=Executors.newCachedThreadPool();
		DBCursor cursor= mongoTemplate.getCollection("player").find();
		while (cursor.hasNext()) {
			DBObject dbObject = (DBObject) cursor.next();
			BasicDBList seasons = (BasicDBList) dbObject.get("seasonSums");
			for(int i=0;i<seasons.size();++i){
				DBObject dbObject2=(DBObject) seasons.get(i);
				String s=(String) dbObject2.get("season");
				s=s.replaceAll("-", "to");
				s="sumfrom"+s;
				dbObject2.put("name", dbObject.get("name"));
				mongoTemplate.insert(dbObject2, s);
			}
		}
	}
}
