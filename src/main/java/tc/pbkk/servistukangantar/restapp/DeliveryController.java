package tc.pbkk.servistukangantar.restapp;

import java.sql.Time;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tc.pbkk.servistukangantar.model.Delivery;
import tc.pbkk.servistukangantar.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	private DeliveryService deliveryService;

	@GetMapping()
	public List<Delivery> getDeliveries() {
		return deliveryService.getAllDelivery();
	}
	
	@GetMapping("{id}")
	public Delivery getDeliveryById(@PathVariable Integer id) {
		return deliveryService.getDelivery(id);
	}
	
	@PostMapping()
	public Delivery postDelivery(@ModelAttribute Delivery delivery) {
		return deliveryService.addDelivery(delivery);
	}
	
	@PutMapping("{id}")
	public Delivery updateDelivery(@PathVariable Integer id, @ModelAttribute Delivery delivery) {
		delivery.setId(id);
		
		return deliveryService.addDelivery(delivery);
	}
	
	@DeleteMapping("{id}")
	public Map<String, String> deleteDelivery(@PathVariable Integer id) {
		deliveryService.deleteDelivery(id);
		
		Map<String, String > result = new LinkedHashMap<String, String>();
		result.put("Result", "Delivery ID: " + id + " deleted!");
		
		return result;
	}
}
