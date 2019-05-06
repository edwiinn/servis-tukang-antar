package tc.pbkk.servistukangantar.service;

import java.util.List;

import tc.pbkk.servistukangantar.model.Delivery;

public interface DeliveryService{
	public List<Delivery> getAllDelivery();
	public Delivery addDelivery(Delivery delivery);
	public Delivery getDelivery(Integer deliveryId);
	public Delivery updateDelivery(Delivery delivery);
	public void deleteDelivery(Integer deliveryId);
}