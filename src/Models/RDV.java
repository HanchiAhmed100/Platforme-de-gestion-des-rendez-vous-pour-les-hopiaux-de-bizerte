package Models;

public class RDV {
	private String id;
	private String patientVille;
	private String Service;
	private String hopitalId;
	private String RdvDate;
	@Override
	public String toString() {
		return "RDV [id=" + id + ", patientVille=" + patientVille + ", Service=" + Service + ", hopitalId=" + hopitalId
				+ ", RdvDate=" + RdvDate + ", patientId=" + patientId + ", RdvValidation=" + RdvValidation + "]";
	}
	private String patientId;
	private String RdvValidation;
	
	public RDV() {
		
	}
	
	public RDV(String patientVille, String service, String hopitalId, String rdvDate, String patientId) {
		super();
		this.patientVille = patientVille;
		this.Service = service;
		this.hopitalId = hopitalId;
		this.RdvDate = rdvDate;
		this.patientId = patientId;
		this.RdvValidation = "0";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatientVille() {
		return patientVille;
	}
	public void setPatientVille(String patientVille) {
		this.patientVille = patientVille;
	}
	public String getService() {
		return Service;
	}
	public void setService(String service) {
		Service = service;
	}
	public String getHopitalId() {
		return hopitalId;
	}
	public void setHopitalId(String hopitalId) {
		this.hopitalId = hopitalId;
	}
	public String getRdvDate() {
		return RdvDate;
	}
	public void setRdvDate(String rdvDate) {
		RdvDate = rdvDate;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getRdvValidation() {
		return RdvValidation;
	}
	public void setRdvValidation(String rdvValidation) {
		RdvValidation = rdvValidation;
	}
	

	
}
