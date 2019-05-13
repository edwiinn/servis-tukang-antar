package tc.pbkk.servistukangantar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private Integer deliveryId;
    private String driverLat;
    private String driverLong;
    private Long timestamp;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDriverLat() {
        return driverLat;
    }

    public void setDriverLat(String driverLat) {
        this.driverLat = driverLat;
    }

    public String getDriverLong() {
        return driverLong;
    }

    public void setDriverLong(String driverLong) {
        this.driverLong = driverLong;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}