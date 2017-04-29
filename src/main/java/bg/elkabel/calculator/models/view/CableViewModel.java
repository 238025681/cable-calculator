package bg.elkabel.calculator.models.view;

import bg.elkabel.calculator.entity.Conductor;

public class CableViewModel {

    private Long id;

    private String name;

    private Conductor conductor;

    private int numberOfConductors;

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

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public int getNumberOfConductors() {
        return numberOfConductors;
    }

    public void setNumberOfConductors(int numberOfConductors) {
        this.numberOfConductors = numberOfConductors;
    }

}
