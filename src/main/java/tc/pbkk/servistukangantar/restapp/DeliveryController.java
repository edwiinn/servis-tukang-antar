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
	
	@GetMapping()
	public List<Delivery> getDeliveries() {
		return deliveryService.getAllDelivery();
	}
	
	@GetMapping("{id}")
	public Delivery getDeliveryById(@PathVariable Integer id) {
		return deliveryService.getDelivery(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String postDelivery(@ModelAttribute Delivery delivery) {
//		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		Gson gson = dependencyContainer.getService(Gson.class);
		return gson.toJson(deliveryService.addDelivery(delivery));
	}
	
	@PutMapping("{id}")
	public Delivery updateDelivery(@PathVariable Integer id, @ModelAttribute Delivery delivery) {
		return deliveryService.updateDelivery(id, delivery);
	}
	
//	@DeleteMapping("{id}")
//	public Map<String, String> deleteDelivery(@PathVariable Integer id) {
//		deliveryService.deleteDelivery(id);
//		
//		Map<String, String > result = new LinkedHashMap<String, String>();
//		result.put("result", "Delivery ID: " + id + " deleted!");
//		
//		return result;
//	}
}
