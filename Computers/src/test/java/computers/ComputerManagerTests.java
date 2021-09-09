package computers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComputerManagerTests {
    
	private ComputerManager computerManager;
	private Computer computer;
	private Computer computer2;
	
	@Before
	public void setUp() {
		this.computerManager = new ComputerManager();
		computer = new Computer("Dell", "Latitude", 700.00);
		computer2 = new Computer("Lenovo", "ThinkPad", 900.00);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testGetComputers() {
		computerManager.getComputers().remove(0);
	}
	
	@Test(expected = IllegalArgumentException.class) //not
	public void testNullAdd() {
		this.computerManager.addComputer(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondAdd() {
		this.computerManager.addComputer(computer);
		this.computerManager.addComputer(computer);
	}
	
	@Test
	public void testAdd() {
		this.computerManager.addComputer(computer);
		assertEquals(1, this.computerManager.getCount());
	}
	
	@Test(expected = IllegalArgumentException.class)				//not
	public void testGet() {
		this.computerManager.getComputer(null, "Model");
	}
	
	@Test(expected = IllegalArgumentException.class)				//not
	public void testGet2() {
		this.computerManager.getComputer("Manufacturer", null);
	}
	
	@Test(expected = IllegalArgumentException.class)				//not
	public void testGetNonExisting() {
		this.computerManager.getComputer(computer.getManufacturer(), computer.getModel());
	}
	
	@Test
	public void testGetReturnCorrect() {
		computerManager.addComputer(computer);
		Computer returned = this.computerManager.getComputer(computer.getManufacturer(), computer.getModel());
		assertNotNull(returned);
		assertEquals(computer.getManufacturer(), returned.getManufacturer());
		assertEquals(computer.getModel(), returned.getModel());
	}
	
	@Test
	public void testGetByMen() {
		computerManager.addComputer(computer);
		computerManager.addComputer(computer2);
		List<Computer> list = computerManager.getComputersByManufacturer(computer.getManufacturer());
		assertNotNull(list);
		assertEquals(list.get(0).getManufacturer(), computer.getManufacturer());
	}
	
	@Test
	public void testGetByMenWhenEmpty() {							//not
		List<Computer> list = computerManager.getComputersByManufacturer(computer.getManufacturer());
		assertNotNull(list);
		assertTrue(list.isEmpty());
	}
	
}