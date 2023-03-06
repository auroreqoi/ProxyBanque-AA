package persistance;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Compte;
import entity.Client;

public class TestAuditCompte {

	public Set<Compte> Audit() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Set<Compte> comptes = new HashSet<Compte>();;
		try {
			txn.begin();

			comptes = (Set<Compte>) em.createQuery("SELECT * FROM public.compte");
			comptes.size();

			txn.commit();
			return comptes;
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
		return comptes;
	}

}
