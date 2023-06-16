package com.service.tokenservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.service.tokenservice.model.Parametro;
import com.service.tokenservice.model.Seller;
import com.service.tokenservice.utils.API;

@Service
public class MLService {

	public List<String> sacarRefreshToken(String code) {
		List<String> tokens = new ArrayList<>();

		String url = "https://api.mercadolibre.com/oauth/token";

		List<Parametro> headers = new ArrayList<>();
		headers.add(new Parametro("ContentType", "application/x-www-form-urlencoded"));

		Map<String, String> json = new HashMap<>();
		//BANIOFERTA
		/*json.put("grant_type", "authorization_code");
		json.put("client_id", "748785826240870");
		json.put("client_secret", "DQ1Q6nim60l3LSYVJzVwstNd9KxbTmma");
		json.put("code", code);
		//json.put("redirect_uri", "https://181.10.100.183:8080/api/userAuth");
		json.put("redirect_uri", "https://mltoken.onrender.com/api");*/
		
		//LESAMI
		json.put("grant_type", "authorization_code");
		json.put("client_id", "8369560227252271");
		json.put("client_secret", "cYcrFp1nq1kaL3TUAWPwadhOl6zHRc4O");
		json.put("code", code);
		//json.put("redirect_uri", "https://181.10.100.183:8080/api/userAuth");
		json.put("redirect_uri", "https://mwmkwazdti.execute-api.sa-east-1.amazonaws.com/api/auth");

		String response = API.Post(url, headers, json);
		JSONObject obj = new JSONObject(response);
		tokens.add(Long.toString(obj.getLong("user_id")));
		tokens.add(obj.getString("refresh_token"));
		tokens.add("Bearer " + obj.getString("access_token"));
		return tokens;
	}

	public String sacarToken(String refresh_token) {
		String url = "https://api.mercadolibre.com/oauth/token";

		List<Parametro> headers = new ArrayList<>();
		headers.add(new Parametro("ContentType", "application/x-www-form-urlencoded"));

		Map<String, String> json = new HashMap<>();
		json.put("grant_type", "refresh_token");
		json.put("client_id", "8369560227252271");
		json.put("client_secret", "cYcrFp1nq1kaL3TUAWPwadhOl6zHRc4O");
		json.put("refresh_token", refresh_token);

		String response = API.Post(url, headers, json);
		JSONObject obj = new JSONObject(response);
		return "Bearer " + obj.getString("access_token");
	}
	
	public Seller getDatos(String userID, String token) {
		
		String url = "https://api.mercadolibre.com/users/" + userID;

		List<Parametro> headers = new ArrayList<>();
		headers.add(new Parametro("Authorization", token));

		String response = API.Get(url, headers);
		JSONObject respObj = new JSONObject(response);
		
		return new Seller(userID, respObj);
	}

}
