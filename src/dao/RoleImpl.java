package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Role;
import entities.User;

public class RoleImpl implements IRole {
private EntityManager em;
	
	public RoleImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMJPAPU");
		
		em = emf.createEntityManager();
	}

	@Override
	public int add(Role role) {
		
		try {
			em.getTransaction().begin();
			em.persist(role);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

}
