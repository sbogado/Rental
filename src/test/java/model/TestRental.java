package model;

import org.junit.Test;

public class TestRental {

	@Test(expected = UnsupportedOperationException.class)
	public void testAddRentalOnLeaf() throws UnsupportedOperationException{
		
		Rental rental = new RentalByDay();
		rental.addRental(new RentalByHour());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveRentalOnLeaf() throws UnsupportedOperationException{
		
		Rental anotherRental = new RentalByDay();
		
		Rental rental = new RentalByDay();
		rental.removeRental(anotherRental);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testgetRentalOnLeaf() throws UnsupportedOperationException{
		
		Rental rental = new RentalByDay();
		rental.getRental(1);
	}
	
}
