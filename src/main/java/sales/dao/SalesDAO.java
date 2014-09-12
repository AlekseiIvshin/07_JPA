package sales.dao;

import java.util.List;

import common.dao.GenericDAO;

import merchant.dao.Merchant;
import customer.dao.Customer;
import car.dao.modifiacation.Modification;

public interface SalesDAO extends GenericDAO<Sales, Integer>{
	
	public List<Sales> find(Modification modification);

	public List<Sales> find(Customer customer);

	public List<Sales> find(Merchant merchant);
}
