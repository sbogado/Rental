package model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRentalByDay {

	RentalByDay rental;
	
	@Before
	public void setup(){
		rental = new RentalByDay();
	}
	
	@Test
	public void testcost(){
		assertThat("cost should be $20",rental.cost(),is(20.00));
	} 
	
	@After
	public void tearDown(){
	}
}
