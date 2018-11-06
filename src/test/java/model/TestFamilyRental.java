package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.exception.CompositeRentalMalformedException;

public class TestFamilyRental {

	List<Rental> rentals;
	
	@Before
	public void setup() throws CompositeRentalMalformedException{
		rentals = new ArrayList<Rental>();
	}
	
	@Test(expected = CompositeRentalMalformedException.class)
	public void testContructorFailsBecauseInsuficientRentals() throws CompositeRentalMalformedException{
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		
		new FamilyRental(rentals);
	}
	
	@Test(expected = CompositeRentalMalformedException.class)
	public void testContructorFailsBecauseTooMuchRentals() throws CompositeRentalMalformedException{
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		
		new FamilyRental(rentals);
	}
	
	@Test
	public void testContructorSuccesWith3Rentals() throws CompositeRentalMalformedException {
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByDay());

		new FamilyRental(rentals);
	}
	
	@Test
	public void testContructorSuccesWith5Rentals() throws CompositeRentalMalformedException {
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByWeek());

		new FamilyRental(rentals);
	}
	
	
	@Test 
	public void testCost() throws CompositeRentalMalformedException{
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		
		Rental rental = new FamilyRental(rentals);
		assertThat("cost should be (5 + 20 + 20 + 60) = 105 --> 105 - 105 * 30 / 100 =  $73.50",rental.cost(),is(73.50));
	} 
	
	@Test 
	public void testCostWithComposite() throws CompositeRentalMalformedException{
		List<Rental> compositeRentals = new ArrayList<Rental>();
		
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByDay());
		
		compositeRentals.addAll(rentals);
		compositeRentals.add(new RentalByWeek());
		
		rentals.add(new FamilyRental(compositeRentals));
		
		Rental rental = new FamilyRental(rentals);
		assertThat("cost should be (5 + 20 + 20 + 60) = 105 --> 105 - 105 * 30 / 100 = 73.50 "
				+ "--> (73.50 + 5 + 20 + 20 ) = 118.5 --> 118.5 - 118.5 * 30 / 100 = $82.95 ",rental.cost(),is(82.95));
	} 
	
	@Test
	public void testRemoveRentalShouldNotRemove() throws CompositeRentalMalformedException{
		
		Rental rentalToRemove = new RentalByHour();
		
		rentals.add(rentalToRemove);
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		
		Rental rental = new FamilyRental(rentals);
		
		rental.removeRental(rentalToRemove);
		
		assertThat("rentals size should be 3 ",rentals.size(),is(3));
	} 
	
	@Test
	public void testRemoveRentalShouldRemove() throws CompositeRentalMalformedException{
		
		Rental rentalToRemove = new RentalByHour();
		
		rentals.add(rentalToRemove);
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByHour());
		
		Rental rental = new FamilyRental(rentals);
		
		rental.removeRental(rentalToRemove);
		
		assertThat("rentals size should be 3 ",rentals.size(),is(3));
	}
	
	@Test
	public void testRemoveRentalShouldNotAdd() throws CompositeRentalMalformedException{
		
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		
		Rental rental = new FamilyRental(rentals);
		
		rental.addRental(new RentalByHour());
		
		assertThat("rentals size should be 5 ",rentals.size(),is(5));
	}
	
	@Test
	public void testRemoveRentalShouldAdd() throws CompositeRentalMalformedException{
		
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByHour());
		
		Rental rental = new FamilyRental(rentals);
		
		rental.addRental(new RentalByHour());
		
		assertThat("rentals size should be 5 ",rentals.size(),is(5));
	}
	
	@Test
	public void testGetFirstRental() throws CompositeRentalMalformedException{
		
		Rental rentalToGet = new RentalByHour();
		
		rentals.add(rentalToGet);
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByHour());
		
		Rental rental = new FamilyRental(rentals);
				
		assertThat("rentals should be the same ",rental.getRental(1),is(rentalToGet));
	}
	
	@Test
	public void testGetFifthRental() throws CompositeRentalMalformedException{
		
		Rental rentalToGet = new RentalByHour();
		
		rentals.add(new RentalByHour());
		rentals.add(new RentalByDay());
		rentals.add(new RentalByWeek());
		rentals.add(new RentalByHour());
		rentals.add(rentalToGet);
		
		Rental rental = new FamilyRental(rentals);
				
		assertThat("rentals should be the same ",rental.getRental(5),is(rentalToGet));
	}
	
	
}
