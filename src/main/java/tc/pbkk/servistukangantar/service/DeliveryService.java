package tc.pbkk.servistukangantar.service;

import java.util.Map;

import tc.pbkk.servistukangantar.model.Delivery;

public interface DeliveryService {
	public Map<String, String> getEstimatedCost(String startPosition, String endPosition);
	public Delivery addDelivery(Delivery delivery);
	public Delivery getDelivery(Integer deliveryId);
	public Delivery updateDelivery(Integer id,Delivery delivery);
}