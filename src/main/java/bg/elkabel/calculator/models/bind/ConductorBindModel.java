/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.models.bind;

public class ConductorBindModel {


	private String name;

	private String material;

	private int coreNumbers;

	private String core;

	private int degree;
	
	private int cut;

	private double weight;

	public int getCut() {
		return cut;
	}

	public void setCut(int cut) {
		this.cut = cut;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getCoreNumbers() {
		return coreNumbers;
	}

	public void setCoreNumbers(int coreNumbers) {
		this.coreNumbers = coreNumbers;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
