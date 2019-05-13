package tc.pbkk.servistukangantar.service;

import tc.pbkk.servistukangantar.model.Delivery;

public interface DeliveryService {
	public Delivery addDelivery(Delivery delivery);
	public Delivery getDelivery(Integer deliveryId);
	public Delivery updateDelivery(Integer id,Delivery delivery);
}