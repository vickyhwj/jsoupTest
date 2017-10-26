package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.dao.PlayerDAO;
import com.example.domain.Post;
import com.mongodb.DBObject;

@Controller
public class TeamController {

	@Autowired
	PlayerDAO playerDAO;
	@RequestMapping("/getPlaysBySeason_Team")
	public void getPlaysBySeason_Team(String season,String team,HttpServletResponse response) throws IOException {
		ArrayList<DBObject> list=  playerDAO.getPlayersBySeason_Team(season, team);
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(list);
	}
	@RequestMapping("/getPlayer")
	public void getPlaysBySeason_Team(String name,HttpServletResponse response) throws IOException {
		DBObject dbObject= playerDAO.findPlayerById(name);
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(dbObject);
	}
	@RequestMapping("/getPlayerList")
	public void getPlayerList(String name,HttpServletResponse response) throws IOException {
		ArrayList<DBObject> dbObjects= playerDAO.findPlayerByLikeId(name);
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(dbObjects);
	}
}
