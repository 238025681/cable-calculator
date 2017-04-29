package bg.elkabel.calculator.models.bind;

public class CableBindModel {

	private Long id;

	private String name;

	private String conductorName;

	private Integer numberOfConductors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConductorName() {
		return conductorName;
	}

	public void setConductorName(String conductorName) {
		this.conductorName = conductorName;
	}

	public Integer getNumberOfConductors() {
		return numberOfConductors;
	}

	public void setNumberOfConductors(int numberOfConductors) {
		this.numberOfConductors = numberOfConductors;
	}
	
	
}
