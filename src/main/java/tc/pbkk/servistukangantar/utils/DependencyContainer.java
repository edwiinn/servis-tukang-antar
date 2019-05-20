package tc.pbkk.servistukangantar.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tc.pbkk.servistukangantar.model.AuthToken;

public class DependencyContainer {
	
	private static DependencyContainer instance;
	private Map<String, Object> service = new LinkedHashMap<String, Object>();
	private DependencyContainer() {
		this.setService(Gson.class, new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create());
		this.setService(AuthHandler.class, new AuthHandler());
	}
	
	public static DependencyContainer getInstance() {
		if(instance == null) {
			instance = new DependencyContainer();
		}
		return instance;
	}
	
	public <T> void setService(Class<T> serviceObj, Object obj) {
		service.put(serviceObj.toString(), obj);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> className) {
		return (T)service.get(className.toString());
	}
}
