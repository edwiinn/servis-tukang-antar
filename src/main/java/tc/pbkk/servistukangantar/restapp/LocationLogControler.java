package tc.pbkk.servistukangantar.restapp;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tc.pbkk.servistukangantar.model.LocationLog;
import tc.pbkk.servistukangantar.service.LocationLogService;
import tc.pbkk.servistukangantar.utils.DependencyContainer;

@RestController
@RequestMapping("delivery/{deliveryId}/log")
public class LocationLogControler {
	@Autowired
	private LocationLogService locationLogService;
	private DependencyContainer dependencyContainer = DependencyContainer.getInstance();
	private Gson gson = dependencyContainer.getService(Gson.class);
	
	@GetMapping(value = "latest",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getLatestLog(@PathVariable Integer deliveryId) {
		return gson.toJson(locationLogService.getLatestLogByDeliveryId(deliveryId));
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String postLog(@ModelAttribute LocationLog locationLog) {
		return gson.toJson(locationLogService.addLog(locationLog));
	}
}
