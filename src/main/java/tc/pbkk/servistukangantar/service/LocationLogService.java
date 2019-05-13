package tc.pbkk.servistukangantar.service;

import java.util.List;

import tc.pbkk.servistukangantar.model.LocationLog;

public interface LocationLogService {
	public List<LocationLog> getAllLogs();

	public List<LocationLog> getLogsByDeliveryId(Integer deliveryId);
	public LocationLog getLatestLogByDeliveryId(Integer deliveryId);
	
	public LocationLog addLog(LocationLog log);
}
