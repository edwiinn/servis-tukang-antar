package tc.pbkk.servistukangantar.restapp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delivery/{deliveryId}/log")
public class DeliveryLogControler {
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllLogs(@PathVariable Integer deliveryId) {
		return "Return all logs";
	}
	
	@GetMapping(value = "{logId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getLog(@PathVariable Integer deliveryId, @PathVariable Integer logId) {
		return "Return single log";
	}
	
	@GetMapping(value = "latest",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getLatestLog(@PathVariable Integer deliveryId) {
		return "Return latest log";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String postLog(@PathVariable Integer deliveryId) {
		return "Post log";
	}
}
