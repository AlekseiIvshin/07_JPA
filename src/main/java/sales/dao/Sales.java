package sales.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import customer.dao.CustomerDAO;
import merchant.dao.Merchant;
import modification.dao.Modification;

/**
 * Entity of table 'sales'.
 * @author AlekseiIvshin
 *
 */
@Entity
@Table(name = "sales")
public class Sales {

	/**
	 * Id of sale.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_sale")
	private int id;

	/** 
	 * Price in sale.
	 */
	@Column(name = "price")
	private BigDecimal price;
	
	/**
	 * Sale date.
	 */
	@Column(name = "sale_date")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Temporal(TemporalType.TIMESTAMP)
	private Date saleDate;
	
	/**
	 * Sale modification.
	 */
	@ManyToOne
	@JoinColumn(name = "id_car_modification")
	private Modification modification;
	
	/**
	 * Sale customer.
	 */
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private CustomerDAO customer;
	
	/**
	 * Sale merchant.
	 */
	@ManyToOne
	@JoinColumn(name = "id_merchant")
	private Merchant merchant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Modification getModification() {
		return modification;
	}

	public void setModification(Modification modification) {
		this.modification = modification;
	}

	public CustomerDAO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDAO customer) {
		this.customer = customer;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
}
