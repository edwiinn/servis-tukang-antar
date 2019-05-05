package tc.pbkk.servistukangantar.service;

import java.util.Date;
import java.util.List;

import tc.pbkk.servistukangantar.model.Delivery;

public interface DeliveryService{
	public List<Delivery> getAllDelivery();
	public void addDelivery(Delivery delivery);
	public Delivery getDelivery(Integer deliveryId);
	public void updateDelivery(Integer deliveryId, Boolean isArrived, Date sentAt, Date arrivedAt);
	public void deleteDelivery(Integer deliveryId);
}