package tc.pbkk.servistukangantar.model;

import javax.persistence.*;
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;
	
	private Integer orderId;
	private Boolean isArrived;
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
	public Boolean getIsArrived() {
		return isArrived;
	}
	public void setIsArrived(Boolean isArrived) {
		this.isArrived = isArrived;
	}
	public void setSentAt(Long sentAt) {
		this.sentAt = sentAt;
	}
	public void setArrivedAt(Long arrivedAt) {
		this.arrivedAt = arrivedAt;
	}

}