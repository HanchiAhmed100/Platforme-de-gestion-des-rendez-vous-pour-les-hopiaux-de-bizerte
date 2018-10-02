package Models;

public class Secretaire{

	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	private String password;
	private String specialit�es;
	

	public Secretaire(String nom, String prenom, String adresse, String mail,String password, String specialit�es) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.password = password;
		this.mail = mail;
		this.specialit�es = specialit�es;
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


	public String getSpecialit�es() {
		return specialit�es;
	}

	public void setSpecialit�es(String specialit�es) {
		this.specialit�es = specialit�es;
	}

	@Override
	public String toString() {
		return "Medecin [specialit�es=" + specialit�es + "]";
	}
	
}
