package bg.elkabel.calculator.utils;

import bg.elkabel.calculator.models.view.RequestViewModel;

public abstract class RequestPropertiesBuilder {

	private static final int ZERO = 0;
	private static final int CORE = 1;
	private static final double REDUCE = 0.96;
	private static final int REDUCE_PER_CAGE = 100;

	public static RequestProperties createRequestProperties(RequestViewModel request) {
		
		double coreWeight = request.getCable().getConductor().getCore().getWeight();
		int drumCapacity = request.getCable().getConductor().getMaterial().getCapacity();
		int totalDrums = request.getCable().getNumberOfConductors();
		long totalLenght = request.getLength();
		
		double totalWeight = totalLenght *  coreWeight;
		
		int lenght =  (int) ((drumCapacity / coreWeight) - ( (drumCapacity / coreWeight) % 1000));
		int multiplier = (int) Math.ceil(totalWeight / drumCapacity);

		return new RequestProperties(lenght, totalLenght, multiplier, totalDrums);
	}

}
