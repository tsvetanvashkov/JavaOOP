package garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
	
	private Garage garage;
	private Car car;
	private Car car2;
	
	
	@Before
	public void setUp() {
		this.garage = new Garage();
		this.car = new Car("Audi", 260, 7000.00);
		this.car2 = new Car("BMW", 250, 12000.00);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddCarWhenItIsNullShouldFail() {
		this.garage.addCar(null);
	}
	
	@Test(expected = UnsupportedOperationException.class)  //not
	public void testGetCar() {
		this.garage.getCars().remove(0);
	}
	
	@Test
	public void testAddCar() {
		this.garage.addCar(car);
		assertEquals(1, garage.getCount());
	}
	
	
	@Test
	public void testFilterMaxSpeed() {
		this.garage.addCar(car);
		List<Car> list = garage.findAllCarsWithMaxSpeedAbove(200);
		assertNotNull(list);
		assertEquals(list.get(0), car);
	}
	
	@Test
	public void testFilterBrand() {
		this.garage.addCar(car);
		List<Car> list = garage.findAllCarsByBrand(car.getBrand());
		assertNotNull(list);
		assertEquals(list.get(0), car);
	}
	
	@Test
	public void testFindMostExpensiveCar() {
		this.garage.addCar(car);
		this.garage.addCar(car2);
		Car returned = this.garage.getTheMostExpensiveCar();
		assertNotNull(returned);
		assertEquals(returned, car2);
	}
	
}