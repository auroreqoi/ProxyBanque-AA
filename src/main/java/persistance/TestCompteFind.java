package persistance;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Client;
import entity.Compte;

public class TestCompteFind {

	public void FindCompte() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Date date = new Date(53, 02, 06);
		try {
			txn.begin();
			
			Client c = em.find(Client.class, 5L);
			//c.setPrenom("Olympes");
			Compte compte1 = em.find(Compte.class, 4L);
			compte1.setSolde(500);
			System.out.println(compte1);

			
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
