package com.myopgg.myopggapp;

import org.springframework.stereotype.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.myopgg.myopggapp.dto.ChampionInfoRotation;
import com.myopgg.myopggapp.dto.ChampionMasteryDto;
import com.myopgg.myopggapp.dto.ChampionsResourcesDto;
import com.myopgg.myopggapp.dto.MatchlistDto;
import com.myopgg.myopggapp.dto.SummonerDto;
import com.myopgg.myopggapp.utils.IdForNameUtil;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

@Controller
public class ExClass {
	//api 키는 유효기간이 존재하므로 재발급을 받아야합니다.
	final static String API_KEY = "RGAPI-9193602b-7d76-4f25-bedf-ae66c0185362";
	// example jsp 
	@RequestMapping("/TestJsp")
	public String ExampleJsp(HttpServletRequest req , Model model) {
		System.out.println("testJsp start ");
		return "TestJsp";
	}
	@RequestMapping("/exController")
	@ResponseBody
	public List<ChampionMasteryDto> getServerStatus(HttpServletRequest req , Model model) throws IOException, ParseException {
		  System.out.println("exController =>! ");
		  BufferedReader br = null;
		 // 해당 데이터는 json Array 형식이므로 jsonObject 로 casting 될수 없다.
		  String urlstr ="https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/QJJvQmbVJnkBjqoZaJ3uok86sjhbiGqqS2Fk7Hh-C13_NSQ?api_key=RGAPI-9193602b-7d76-4f25-bedf-ae66c0185362";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); 
			String result = "";
			String line;
			while((line = br.readLine()) != null) { 
				result = result + line;
			}
			// jsonList Return 
			JsonParser jsonParser = new JsonParser();
			// jsonArray result 를 jsonarray 로 cast 
			JsonArray jArray = (JsonArray) jsonParser.parse(result);
			Gson gson = new Gson();
			Type type = new TypeToken<List<ChampionMasteryDto>>() {}.getType();
			List <ChampionMasteryDto> ChampionMastery = gson.fromJson(jArray,type);
			
		return ChampionMastery;
		
	}

}
