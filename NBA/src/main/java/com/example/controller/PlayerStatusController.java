package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.example.dao.GetPlayerOnLineDAO;
import com.example.dao.PlayerDAO;
import com.example.domain.Post;
import com.mongodb.DBObject;

@Controller
public class PlayerStatusController {

	@Autowired
	PlayerDAO playerDAO;
	@Autowired
	GetPlayerOnLineDAO getPlayerOnLineDAO;
	
	@RequestMapping("/getPlayerStatus")
	public String getPlaysBySeason_Team(String num,HttpServletRequest request) throws IOException {
		HashMap<String,String> map0=(HashMap<String, String>) getPlayerOnLineDAO.getTableByURL_IDs("http://www.stat-nba.com/player/stat_box/"+num+"_season.html","stat_box_avg","stat_box_tot","stat_box_single","stat_box_advanced_basic","stat_box_advanced_shooting" );
		request.setAttribute("stat_box_avg_season", map0.get("stat_box_avg"));
		request.setAttribute("stat_box_tot_season", map0.get("stat_box_tot"));
		request.setAttribute("stat_box_single_season",map0.get( "stat_box_single"));
		request.setAttribute("stat_box_advanced_basic_season",map0.get( "stat_box_advanced_basic"));
		request.setAttribute("stat_box_advanced_shooting_season",map0.get( "stat_box_advanced_shooting"));
		
		
		HashMap<String,String> map=(HashMap<String, String>) getPlayerOnLineDAO.getTableByURL_IDs("http://www.stat-nba.com/player/stat_box/"+num+"_playoff.html","stat_box_avg","stat_box_tot","stat_box_single","stat_box_advanced_basic","stat_box_advanced_shooting" );
		request.setAttribute("stat_box_avg", map.get("stat_box_avg"));
		request.setAttribute("stat_box_tot", map.get("stat_box_tot"));
		request.setAttribute("stat_box_single",map.get( "stat_box_single"));
		request.setAttribute("stat_box_advanced_basic",map.get( "stat_box_advanced_basic"));
		request.setAttribute("stat_box_advanced_shooting",map.get( "stat_box_advanced_shooting"));

		HashMap<String,String> map2=(HashMap<String, String>) getPlayerOnLineDAO.getTableByURL_IDs("http://www.stat-nba.com/player/stat_box/"+num+"_allstar.html","stat_box_avg","stat_box_tot","stat_box_single","stat_box_advanced_basic","stat_box_advanced_shooting" );
		request.setAttribute("stat_box_avg_allstar", map2.get("stat_box_avg"));
		request.setAttribute("stat_box_tot_allstar", map2.get("stat_box_tot"));
		request.setAttribute("stat_box_single_allstar",map2.get( "stat_box_single"));
		request.setAttribute("stat_box_advanced_basic_allstar",map2.get( "stat_box_advanced_basic"));
		request.setAttribute("stat_box_advanced_shooting_allstar",map2.get( "stat_box_advanced_shooting"));

		
		return "player";
	}
	
}
