package tc.pbkk.servistukangantar.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tc.pbkk.servistukangantar.model.LocationLog;

@Repository
public interface LocationLogRepository extends CrudRepository<LocationLog, Integer> {

    @Query(value = "SELECT * FROM location_log WHERE delivery_id = :deliveryId ORDER BY id DESC LIMIT 1", nativeQuery = true)
    LocationLog getLatesLocationLog(@Param("deliveryId") Integer deliveryId);

}