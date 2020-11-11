package commun;

import java.io.Serializable;
import java.util.List;

public class ListeAttente implements Serializable{
	private int attente;
	private List<DemandeLocation> demande;
	private String dateDemande;
	
	public ListeAttente() {
		// TODO Auto-generated constructor stub
	}

	public ListeAttente(int attente, List<DemandeLocation> demande, String dateDemande) {
		super();
		this.attente = attente;
		this.demande = demande;
		this.dateDemande = dateDemande;
	}

	public int getAttente() {
		return attente;
	}

	public void setAttente(int attente) {
		this.attente = attente;
	}

	public List<DemandeLocation> getDemande() {
		return demande;
	}

	public void setDemande(List<DemandeLocation> demande) {
		this.demande = demande;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

	@Override
	public String toString() {
		return "ListeAttente [attente=" + attente + ", demande=" + demande + ", dateDemande=" + dateDemande + "]";
	}
	
}
