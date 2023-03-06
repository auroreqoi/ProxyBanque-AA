package vue;

import java.util.ArrayList;
import java.util.List;

import entity.Client;
import persistance.TestClientPersist;
import service.AuditClientImp;
import service.AuditCompteImp;

public class Main {

	public static void main(String[] args) {
		
		AuditClientImp auditClient = new AuditClientImp();
		
		System.out.println(auditClient.getAllClients());
		
		AuditCompteImp auditImp = new AuditCompteImp();
		System.out.println(auditImp.getAllComptes());
	}

}
