package tc.pbkk.servistukangantar.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.pbkk.servistukangantar.dao.LocationLogRepository;
import tc.pbkk.servistukangantar.model.LocationLog;

@Service
public class LocationLogServiceImpl implements LocationLogService {

	@Autowired
	private LocationLogRepository locationLogRepository;

	@Override
	public LocationLog addLog(LocationLog log) {
		log.setTimestamp(Instant.now().getEpochSecond());
		locationLogRepository.save(log);

		return log;
	}

	@Override
	public LocationLog getLatestLogByDeliveryId(Integer deliveryId) {
		LocationLog latestLocationLog = locationLogRepository.getLatesLocationLog(deliveryId);	
	
		return latestLocationLog;
	}

}
