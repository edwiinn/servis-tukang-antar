package tc.pbkk.servistukangantar.utils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpHeaders;

import com.google.gson.Gson;

import tc.pbkk.servistukangantar.model.AuthToken;

public class AuthHandler {
	
	public boolean checkToken(String deliveryToken, String tobeCheckToken) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://rendoru.com/kuliah/pbkk/oauth/check_token");
		httpPost.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+deliveryToken);
		List<NameValuePair> form = new ArrayList<>();
		form.add(new BasicNameValuePair("token", tobeCheckToken));
		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(form, Consts.UTF_8);
			httpPost.setEntity(urlEncodedFormEntity);
			System.out.println("Executing Request : "+ httpPost.getRequestLine());
			HttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HttpStatus.SC_OK) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public AuthToken getAuthToken(String username, String password) {
		String key = username+":"+password;
		String base64Key = Base64.getEncoder().encodeToString(key.getBytes());
		List<NameValuePair> form = new ArrayList<>();
		form.add(new BasicNameValuePair("grant_type", "password"));
		form.add(new BasicNameValuePair("username", "user_customer"));
		form.add(new BasicNameValuePair("password", "customer"));
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://rendoru.com/kuliah/pbkk/oauth/token");
		httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic "+base64Key);
		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(form, Consts.UTF_8);
			httpPost.setEntity(urlEncodedFormEntity);
			System.out.println("Executing Request : "+ httpPost.getRequestLine());
			HttpResponse response = httpClient.execute(httpPost);
			String responseString = new BasicResponseHandler().handleResponse(response);
			Gson gson = new Gson();
			AuthToken responseJson = gson.fromJson(responseString,AuthToken.class);
			return responseJson;
		} catch (Exception e) {
			System.out.println("AuthHandler.getAuthorizedToken()");
			return null;
		}
		
		
	}
}
