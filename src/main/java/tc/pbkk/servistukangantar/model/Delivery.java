package tc.pbkk.servistukangantar.model;

import java.util.Date;
import javax.persistence.*;
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private Integer id;
	
	private Integer orderId;
	private Boolean isArrived;
	private Date sentAt;
	private Date arrivedAt;
	
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
	public Date getSentAt() {
		return sentAt;
	}
	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}
	public Date getArrivedAt() {
		return arrivedAt;
	}
	public void setArrivedAt(Date arrivedAt) {
		this.arrivedAt = arrivedAt;
	}
	
	
}
