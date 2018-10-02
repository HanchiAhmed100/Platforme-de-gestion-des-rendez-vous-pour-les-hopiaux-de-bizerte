package Models;

public class Secretaire{

	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	private String password;
	private String specialitées;
	

	public Secretaire(String nom, String prenom, String adresse, String mail,String password, String specialitées) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.password = password;
		this.mail = mail;
		this.specialitées = specialitées;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getSpecialitées() {
		return specialitées;
	}

	public void setSpecialitées(String specialitées) {
		this.specialitées = specialitées;
	}

	@Override
	public String toString() {
		return "Medecin [specialitées=" + specialitées + "]";
	}
	
}
