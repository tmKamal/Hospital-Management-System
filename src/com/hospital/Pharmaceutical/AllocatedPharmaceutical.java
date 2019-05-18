package com.hospital.Pharmaceutical;

public class AllocatedPharmaceutical {
	private int id;
	private String patientNic;
	private String pharmaceuticalId;
	private int qty;
	private String phName;
	private String phBrandName;
	
	public AllocatedPharmaceutical(int id, String pharmaceuticalId, int qty, String phName,
			String phBrandName) {
		
		this.id = id;
		this.pharmaceuticalId = pharmaceuticalId;
		this.qty = qty;
		this.phName = phName;
		this.phBrandName = phBrandName;
	}
	
	public AllocatedPharmaceutical(int id, String patientNic, String pharmaceuticalId, int qty) {
		
		this.id = id;
		this.patientNic = patientNic;
		this.pharmaceuticalId = pharmaceuticalId;
		this.qty = qty;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientNic() {
		return patientNic;
	}

	public void setPatientNic(String patientNic) {
		this.patientNic = patientNic;
	}

	public String getPharmaceuticalId() {
		return pharmaceuticalId;
	}

	public void setPharmaceuticalId(String pharmaceuticalId) {
		this.pharmaceuticalId = pharmaceuticalId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPhName() {
		return phName;
	}

	public void setPhName(String phName) {
		this.phName = phName;
	}

	public String getPhBrandName() {
		return phBrandName;
	}

	public void setPhBrandName(String phBrandName) {
		this.phBrandName = phBrandName;
	}
	
	
	
}
