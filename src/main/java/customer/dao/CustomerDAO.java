package customer.dao;

import common.dao.GenericDAO;

public interface CustomerDAO extends GenericDAO<Customer, Integer> {

	Customer contains(Customer customer);
}
