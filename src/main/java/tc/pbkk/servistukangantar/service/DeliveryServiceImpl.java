package tc.pbkk.servistukangantar.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.pbkk.servistukangantar.dao.DeliveryRepository;
import tc.pbkk.servistukangantar.model.Delivery;
import tc.pbkk.servistukangantar.utils.GeoLocHandler;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	private GeoLocHandler geoLocHandler = new GeoLocHandler();

	@Override
	public Map<String, String> getEstimatedCost(String startPosition, String endPosition) {
		Double cost = geoLocHandler.getCostByDistance(startPosition, endPosition) * 2500;
		int roundedCost = (int) Math.round(cost);
		Map<String, String> returnEstimated = new LinkedHashMap<String, String>();
		returnEstimated.put("cost", String.valueOf(roundedCost));

		return returnEstimated;
	}

	@Override
	public Delivery addDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
		
		return delivery;
	}

	@Override
	public Delivery getDelivery(Integer deliveryId) {
		
		return deliveryRepository.findById(deliveryId).get();
	}

	@Override
	public Delivery updateDelivery(Integer id,Delivery delivery) {
		if (getDelivery(id) == null) {
			throw new RuntimeException("Not Available");
		}
		delivery.setId(id);
		deliveryRepository.save(delivery);
		
		return delivery;
	}

}