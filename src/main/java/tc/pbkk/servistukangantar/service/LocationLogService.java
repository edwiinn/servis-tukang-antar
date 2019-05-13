package tc.pbkk.servistukangantar.service;

import tc.pbkk.servistukangantar.model.LocationLog;

public interface LocationLogService {
	public LocationLog addLog(LocationLog log);
	public LocationLog getLatestLogByDeliveryId(Integer deliveryId);
}
