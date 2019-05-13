package tc.pbkk.servistukangantar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tc.pbkk.servistukangantar.model.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {}
