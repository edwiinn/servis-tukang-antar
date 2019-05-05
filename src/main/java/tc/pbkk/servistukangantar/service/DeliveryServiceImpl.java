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
		List<Delivery>deliverys = (List<Delivery>) deliveryRepository.findAll();
		return deliverys;
	}

}