package entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compte {
	@Id
	@GeneratedValue
	private long id;
	private float solde;
	private Date dateOuverture;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "client_id")
	private Client client;

	public Compte(float solde, java.util.Date date, Client client) {
		super();
		this.solde = solde;
		this.dateOuverture = (Date) date;
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public Compte() {
		super();
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", solde=" + solde + ", dateOuverture=" + dateOuverture + "]";
	}

}
