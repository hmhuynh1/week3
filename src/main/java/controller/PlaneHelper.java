/**
 * @author Hong Huynh
 * CIS175 - Fall 2023
 * Sep 6, 2023
 */


package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Plane;

public class PlaneHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PlaneDemo");
	
	public void persist(Plane model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Plane model) {
		EntityManager manager = factory.createEntityManager();
		/*TypedQuery<Train> query = manager.createQuery("SELECT i FROM Planes i WHERE i.name = :name", Plane.class);
		query.setParameter("name", model.getName());
		Train dbEntity = query.getSingleResult();*/
		manager.getTransaction().begin();
		manager.remove(manager.find(Plane.class, model.getRowId()));
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Plane> showAllPlane() {
		EntityManager manager = factory.createEntityManager();
		List<Plane> allItems = manager.createQuery("SELECT i FROM Plane i").getResultList();
		manager.close();
		return allItems;
		
	}

	public void update(Plane model) {
		EntityManager manager = factory.createEntityManager();
		Plane dbEntity = manager.find(Plane.class, model.getRowId());
		manager.getTransaction().begin();
		dbEntity.setName(model.getName());
		dbEntity.setLength(model.getLength());
		manager.getTransaction().commit();
		manager.close();
		
	}

}
