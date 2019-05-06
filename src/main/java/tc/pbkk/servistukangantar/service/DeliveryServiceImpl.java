package tc.pbkk.servistukangantar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.pbkk.servistukangantar.dao.DeliveryRepository;
import tc.pbkk.servistukangantar.model.Delivery;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Override
	public List<Delivery> getAllDelivery() {
		List<Delivery> deliveries = (List<Delivery>) deliveryRepository.findAll();
		return deliveries;
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
	public Delivery updateDelivery(Delivery delivery) {
		if (delivery == null) {
			throw new RuntimeException("Not Available");
		}
		deliveryRepository.save(delivery);
		
		return delivery;
	}

	@Override
	public void deleteDelivery(Integer deliveryId) {
		deliveryRepository.deleteById(deliveryId);
	}
	

}