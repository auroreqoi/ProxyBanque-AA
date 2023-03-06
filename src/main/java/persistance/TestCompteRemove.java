package persistance;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Client;
import entity.Compte;

public class TestCompteRemove {

	public void RemoveCompte() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Date date = new Date(53, 02, 06);
		try {
			txn.begin();
			
//			Client c = em.find(Client.class, 1L);
//			em.remove(c);
			Compte compte1 = em.find(Compte.class, 4L);
			em.remove(compte1);
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
