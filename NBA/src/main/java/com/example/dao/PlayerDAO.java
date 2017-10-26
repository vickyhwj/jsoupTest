package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import po.Player;
import po.SeasonPre;

import com.example.domain.Post;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
@Component
//@Repository
public class PlayerDAO {

	@Autowired
	MongoOperations mongoTemplate;

	public void savePlayer(Player player) {
		mongoTemplate.save(player);
		//ScriptOperations operations=mongoTemplate.scriptOps();
		
	}
	public ArrayList<DBObject> getPlayersBySeason_Team(String season,String team){
		ArrayList<DBObject> playerlist=new ArrayList<>();
		DBCursor cursor= mongoTemplate.getCollection("player").find();
		while(cursor.hasNext()){
			DBObject pObject=	cursor.next();
			ArrayList<BasicDBObject> seasonPres= (ArrayList<BasicDBObject>) pObject.get("seasonPres");
			
			if(seasonPres!=null){
				for(int i=0;i<seasonPres.size();++i)
					if(team.equals(seasonPres.get(i).get("team"))&&season.equals(seasonPres.get(i).get("season"))){
						ArrayList<BasicDBObject> basicDBObjects=new ArrayList<>();
						basicDBObjects.add(seasonPres.get(i));
						pObject.put("seasonPres", basicDBObjects);
						ArrayList<BasicDBObject> seasonSums= (ArrayList<BasicDBObject>) pObject.get("seasonSums");
						
						pObject.put("seasonSums", seasonSums.get(i));
						playerlist.add(pObject);
						break;
					}
			}
		}
		return playerlist;
		
	}
	public DBObject findPlayerById(String name){
		DBObject object=new BasicDBObject("name", name);
		return mongoTemplate.getCollection("player").findOne(object);
	}
	public ArrayList<DBObject> findPlayerByLikeId(String name){
		Pattern pattern=Pattern.compile(name);
		DBObject object=new BasicDBObject("name", pattern);
		DBCursor cursor=mongoTemplate.getCollection("player").find(object);
		ArrayList<DBObject> list=new ArrayList<>();
		while(cursor.hasNext()){
			DBObject o=cursor.next();
			String name1=(String) o.get("name");
			
			list.add(new BasicDBObject("name", name1));
		}
		return list;
	}
	
	
}
