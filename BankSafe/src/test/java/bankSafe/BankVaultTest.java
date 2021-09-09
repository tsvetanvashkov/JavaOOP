package bankSafe;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

public class BankVaultTest {
	
	private BankVault bankVault;
	private static final Item ITEM = new Item("Pesho", "8");
	
	@Before
	public void setUp() throws OperationNotSupportedException, IllegalArgumentException {
		 this.bankVault = new BankVault();
	}

    @Test(expected = IllegalArgumentException.class)
    public void testIfVaultCellContainsCell() throws OperationNotSupportedException, IllegalArgumentException {
    	this.bankVault.addItem("Z1", null);
    }
    
        @Test(expected = IllegalArgumentException.class)
    public void testIfVaultCelAddSameCell() throws OperationNotSupportedException, IllegalArgumentException {
    	Item item = new Item("Pesho", "5");
    	this.bankVault.addItem("A1", item);
    	this.bankVault.addItem("A1", ITEM);
    }
    
    @Test
    public void testAddToBankVaultShouldWork() throws OperationNotSupportedException, IllegalArgumentException {
    	String expected = "Item:8 saved successfully!";
    	String actual = this.bankVault.addItem("C2", ITEM);
    	assertEquals(expected, actual);
    	
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementShouldFail() {
    	this.bankVault.removeItem("C2", ITEM);
    }
    
    @Test
    public void testRemoveFromBankVaultShouldWork() throws OperationNotSupportedException, IllegalArgumentException {
    	String expected = "Remove item:8 successfully!";
    	this.bankVault.addItem("C2", ITEM);
    	String actual = this.bankVault.removeItem("C2", ITEM);
    	assertEquals(expected, actual);
    	
    }
    
    @Test
    public void testCellShouldHaveItemNull() throws OperationNotSupportedException, IllegalArgumentException{
    	this.bankVault.addItem("C2", ITEM);
    	this.bankVault.removeItem("C2", ITEM);
    	assertNull(bankVault.getVaultCells().get("C2"));
    }

}