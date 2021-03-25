package interfaces_and_abstraction.lab.CarShop;

public interface Car extends Serializable{
	
	Integer TIRES = 4;
	
	String getModel();
	String getColor();
	Integer getHorsePower();
	String getCountryProduced();

}
