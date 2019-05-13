package tc.pbkk.servistukangantar.model;

import javax.persistence.*;
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;	
	private Integer orderId;
	private Integer driverId;
	private String status;
	private Long sentAt;
	private Long arrivedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSentAt() {
		return sentAt;
	}

	public void setSentAt(Long sentAt) {
		this.sentAt = sentAt;
	}

	public Long getArrivedAt() {
		return arrivedAt;
	}

	public void setArrivedAt(Long arrivedAt) {
		this.arrivedAt = arrivedAt;
	}
}