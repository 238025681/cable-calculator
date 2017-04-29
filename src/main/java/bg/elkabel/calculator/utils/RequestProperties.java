
package bg.elkabel.calculator.utils;


public class RequestProperties {
	
	private int lenght;
	private long totalLenght;
	private int multiplier;
	private int totalDrums;

	/**
	 *
	 * @param lenght
	 * @param totalLenght
	 * @param multiplier
	 * @param totalDrums
	 */
	public RequestProperties(int lenght, long totalLenght, int multiplier, int totalDrums) {
		this.lenght = lenght;
		this.totalLenght = totalLenght;
		this.multiplier = multiplier;
		this.totalDrums = totalDrums;
	}
	

	/**
	 * Get the value of totalDrums
	 *
	 * @return the value of totalDrums
	 */
	public int getTotalDrums() {
		return totalDrums;
	}

	/**
	 * Set the value of totalDrums
	 *
	 * @param totalDrums new value of totalDrums
	 */
	public void setTotalDrums(int totalDrums) {
		this.totalDrums = totalDrums;
	}

	public long getTotalLenght() {
		return totalLenght;
	}

	public void setTotalLenght(long totalLenght) {
		this.totalLenght = totalLenght;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	
	
	
	
	
}
