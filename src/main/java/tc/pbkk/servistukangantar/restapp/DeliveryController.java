package tc.pbkk.servistukangantar.restapp;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import tc.pbkk.servistukangantar.model.Delivery;
import tc.pbkk.servistukangantar.service.DeliveryService;
import tc.pbkk.servistukangantar.utils.DependencyContainer;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	private DeliveryService deliveryService;
	private DependencyContainer dependencyContainer = DependencyContainer.getInstance();
	private Gson gson = dependencyContainer.getService(Gson.class);
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getDeliveries() {
		return gson.toJson(deliveryService.getAllDelivery());
	}
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getDeliveryById(@PathVariable Integer id) {
		return gson.toJson(deliveryService.getDelivery(id));
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String postDelivery(@ModelAttribute Delivery delivery) {
		return gson.toJson(deliveryService.addDelivery(delivery));
	}
	
	@PutMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String updateDelivery(@PathVariable Integer id, @ModelAttribute Delivery delivery) {
		return gson.toJson(deliveryService.updateDelivery(id, delivery));
	}
}
