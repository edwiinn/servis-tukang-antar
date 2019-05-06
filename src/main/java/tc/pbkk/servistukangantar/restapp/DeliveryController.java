package tc.pbkk.servistukangantar.restapp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tc.pbkk.servistukangantar.model.Delivery;
import tc.pbkk.servistukangantar.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	private DeliveryService deliveryService;

	@GetMapping()
	public Map<String, Object> getDeliveries() {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("status", "success");
		result.put("data", deliveryService.getAllDelivery());

		return result;
	}
	
	@GetMapping("{id}")
	public Map<String, Object> getDeliveryById(@PathVariable Integer id) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("status", "success");
		result.put("result", deliveryService.getDelivery(id));

		return result;
	}
	
	@PostMapping()
	public Map<String, Object> postDelivery(@ModelAttribute Delivery delivery) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("status", "success");
		result.put("result", deliveryService.addDelivery(delivery));

		return result;
	}
	
	@PutMapping("{id}")
	public Map<String, Object> updateDelivery(@PathVariable Integer id, @ModelAttribute Delivery delivery) {
		delivery.setId(id);

		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("status", "success");
		result.put("data", deliveryService.addDelivery(delivery));

		return result;
	}
	
	@DeleteMapping("{id}")
	public Map<String, String> deleteDelivery(@PathVariable Integer id) {
		deliveryService.deleteDelivery(id);
		
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put("status", "success");
		result.put("data", "Delivery ID: " + id + " deleted!");
		
		return result;
	}
}
