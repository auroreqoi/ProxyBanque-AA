package persistance;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Client;

public class TestAuditClient {


	public Set<Client> Audit() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Set<Client> clients = new HashSet<Client>();
		try {
			txn.begin();
			clients = (Set<Client>) em.createQuery("SELECT * FROM public.client");
			clients.size();

			txn.commit();
			return clients;
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
		return clients;
	}
	
//	public Set<Client> findAllClients(){
//		return session.createQuery
//	}

}
