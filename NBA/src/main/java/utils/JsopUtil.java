package utils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsopUtil {
	static int TIMEOUT=500000;
	public static Document getDocumentByGetMethod(String url) throws IOException{
	/*	Connection con = Jsoup.connect(url).userAgent("Mozilla").timeout(TIMEOUT);  
      //浏览器可接受的MIME类型。
  

     
        Document doc=con.get();  
		return doc;*/
	//	Document parse = Jsoup.parse(new URL("http://info.bet007.com/cn/team/Summary.aspx?TeamID=35"), 10000);
//		Document parse = Jsoup.parse(new URL("http://www.baidu.com"), 10000);
		Connection connect = Jsoup.connect(url);
	//	Map<String, String> header = new HashMap<String, String>();
		HashMap<String, String> header=new HashMap<>();
		header.put("Cookie", "__cfduid=d2f5aeb0ad0fb923dce73f2cf4423c17a1506527215; Hm_lvt_102e5c22af038a553a8610096bcc8bd4=1506527144,1506583082; cf_clearance=c59328ad708f708a19ffe3d0269e57ea7d13afd5-1506581576-28800; Hm_lpvt_102e5c22af038a553a8610096bcc8bd4=1506586040");
		HashMap<String,String > cm=new HashMap<>();
		cm.put("__cfduid", "d2f5aeb0ad0fb923dce73f2cf4423c17a1506527215");
		cm.put("Hm_lvt_102e5c22af038a553a8610096bcc8bd4", "1506527144,1506583082");
		cm.put("cf_clearance", "c59328ad708f708a19ffe3d0269e57ea7d13afd5-1506581576-28800");
		cm.put("Hm_lpvt_102e5c22af038a553a8610096bcc8bd4", "1506586040");
		
		Connection data = connect.cookies(cm).data(header);
		
		Document document = data.get();
		return document;
	}
	public static Document getDocumentByPostMethod(String url) throws IOException{
		Document document=Jsoup.connect(url).timeout(TIMEOUT).post();
		
		return document;
	}
	
}
