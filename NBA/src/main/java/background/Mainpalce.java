package background;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
//爬取统计局省市区
public class Mainpalce {
	static String host="http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2016/";
	static ExecutorService threadPool=Executors.newCachedThreadPool();
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring/spring-config.xml");
		final MongoTemplate mongoTemplate= (MongoTemplate) ac.getBean("mongoTemplate");
		final long start=System.currentTimeMillis();
		
		Document document=JsopUtil.getDocumentByGetMethod(host+"index.html");
		Elements pros=document.getElementsByClass("provincetr");
		ArrayList<String> urls=new ArrayList<>();
		ArrayList<String> names=new ArrayList<>();
		for(int i=0;i<pros.size();++i){
			Element e=pros.get(i);
			Elements a=e.getElementsByTag("a");
			for(Element aa:a){
				System.out.println(aa.attr("href"));
				urls.add(aa.attr("href"));
				names.add(aa.text());
			}
		}
		BasicDBList list=new BasicDBList();
		ArrayList<Future<DBObject>> results=new ArrayList<>();
		for(int i=0;i<urls.size();++i){			
				Future<DBObject> future= Mainpalce.threadPool.submit(new CallResult("citytr", urls.get(i)));
				results.add(future);				
		}
		for(int i=0;i<results.size();++i){
			try{
			DBObject object=new BasicDBObject("shis",results.get(i).get());
			System.out.println(object.toString());
			BasicDBObject sheng=new BasicDBObject("sheng",names.get(i));
			sheng.putAll(object);
			mongoTemplate.insert(sheng, "place");
			}catch(Exception e){
				
			}
		}
		
	}
	
}
class CallResult implements Callable<DBObject>{
	String classname;
	String url;
	public CallResult(String name,String url) {
		super();
		this.classname = name;
		this.url=url;
	}

	@Override
	public DBObject call() throws Exception {
		Document document=JsopUtil.getDocumentByGetMethod(Mainpalce.host+url);
		Elements pros=document.getElementsByClass(classname);
		if("countytr".equals(classname)&&(pros==null||pros.size()==0)){
			classname="towntr";
			pros=document.getElementsByClass(classname);
		}
		
		ArrayList<String> shiurls=new ArrayList<>();
		ArrayList<String> names=new ArrayList<>();
		for(int i=0;i<pros.size();++i){
			try{
			Element e=pros.get(i);
			Element a=e.getElementsByTag("a").get(1);
			System.out.println(a.attr("href"));
			shiurls.add(a.attr("href"));
			names.add(a.text());
			System.out.println(a.text());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if("countytr".equals(classname)||"towntr".equals(classname)){
			BasicDBList list=new BasicDBList();
			for(int i=0;i<names.size();++i){			
				list.add(new BasicDBObject("que", names.get(i)));
			}
			return list;
			
		}
		BasicDBList list=new BasicDBList();
		ArrayList<Future<DBObject>> results=new ArrayList<>();
		for(int i=0;i<shiurls.size();++i){
			if("citytr".equals(classname)){
				Future<DBObject> future= Mainpalce.threadPool.submit(new CallResult("countytr", shiurls.get(i)));
			//	Future<DBObject> future= Mainpalce.threadPool.submit(new CallResult("countytr", "44/4420.html"));
				results.add(future);
			}
			
		}
		
		for(int i=0;i<results.size();++i){
			BasicDBObject shi=new BasicDBObject("shi",names.get(i));
			shi.put("ques",results.get(i).get());
			list.add(shi);
		}
		
		return list;
		
	}
		
	
}
