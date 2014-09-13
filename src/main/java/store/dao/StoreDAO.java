package store.dao;

import java.util.List;

import common.dao.GenericDAO;

import car.dao.modifiacation.Modification;

public interface StoreDAO extends GenericDAO<Store, Integer>{

	public Store find(Modification modification);
}
