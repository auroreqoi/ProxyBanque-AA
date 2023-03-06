package persistance;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Client;
import entity.Compte;


public class TestClientPersist {
	public void ClientPersist() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Date date = new Date(52, 02, 06);
		List<Client> clients = new ArrayList<Client>();
		try {
			txn.begin();
			
			Client c1 = new Client("Allouis", "Adrien");
			Compte compte2 = new Compte(324675.45F, date, c1);

			em.persist(compte2);
			clients.add(c1);
				
			txn.commit();
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
	}
}
