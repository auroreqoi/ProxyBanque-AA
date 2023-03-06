package service;

import java.util.Set;

import entity.Client;
import persistance.TestAuditClient;

public class AuditClientImp implements AuditClient {

	private TestAuditClient audit = new TestAuditClient();

	public Set<Client> getAllClients() {

		return audit.Audit();
	}

}
