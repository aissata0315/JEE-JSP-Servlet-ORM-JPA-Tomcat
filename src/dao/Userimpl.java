package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

public class Userimpl implements IUser {
	private EntityManager em;
	
	public Userimpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMJPAPU");
		
		em = emf.createEntityManager();
	}

	@Override
	public int add(User user) {
		
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public User login(String email, String password) {
		
		try {
			User user = (User) em
					.createQuery("select u from User u where u.email=:e and u.password=:p")
					.setParameter("e",email)
					.setParameter("p",password)
					.getSingleResult();
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
