package persistance;


import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Client;
import entity.Compte;


public class TestComptePersist {
	public void ComptePersist() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Date date = new Date(52, 02, 06);
		try {
			txn.begin();
			
			Client c1 = em.find(Client.class, 7L);
			Compte compte2 = new Compte(3568.98F, date, c1);

			em.persist(compte2);
				
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
