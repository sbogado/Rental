package model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRentalByHour {

	RentalByHour rental;
	
	@Before
	public void setup(){
		rental = new RentalByHour();
	}
	
	
	@Test
	public void testcost(){
		assertThat("cost should be $5",rental.cost(),is(5.00));
	} 
	
	
	@After
	public void tearDown(){
	}
}
