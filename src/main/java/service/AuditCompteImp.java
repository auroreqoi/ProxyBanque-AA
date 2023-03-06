package service;


import java.util.Set;

import entity.Compte;
import persistance.TestAuditCompte;

public class AuditCompteImp implements AuditCompte {

	private TestAuditCompte audit = new TestAuditCompte();
	
	public Set<Compte> getAllComptes() {
		return audit.Audit();
	}

}
