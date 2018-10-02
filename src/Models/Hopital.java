package Models;

public class Hopital {
	private String id;
	private String nom;
	private String adresse;
	private int tel;
	private int medecinId;
	private int patientId;
	
	public Hopital(String id, String nom, String adresse, int tel, int medecinId, int patientId) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.medecinId = medecinId;
		this.patientId = patientId;
	}
	
	public Hopital(String id, String nom, String adresse, int tel) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
	}
	
	public Hopital(String id, String nom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
			}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getMedecinId() {
		return medecinId;
	}
	public void setMedecinId(int medecinId) {
		this.medecinId = medecinId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "Hopital [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + ", medecinId="
				+ medecinId + ", patientId=" + patientId + "]";
	}
	
}
