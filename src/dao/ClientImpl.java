package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Client;
import entities.Village;

public class ClientImpl implements IClient{

		private EntityManager em;
		
		public ClientImpl() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMJPAPU");
			
			em = emf.createEntityManager();
		}

		@Override
		public int add(Client client) {
			
			try {
				em.getTransaction().begin();
				em.persist(client);
				em.getTransaction().commit();
				return 1;
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			
		
		
	}

		@Override
		public Client getClient(int idClient) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Village getVillage(int idVillage) {
            return em.find(Village.class, idVillage );

		}

		@Override
		public List<Village> village() {
			return em.createQuery("select v from Village v").getResultList();
		}

		@Override
		public List<Client> listeClient() {
			// TODO Auto-generated method stub
			return null;
		}
	

}
