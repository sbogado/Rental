package model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRentalByWeek {

	RentalByWeek rental;
	
	@Before
	public void setup(){
		rental = new RentalByWeek();
	}
	
	
	@Test
	public void testcost(){
		assertThat("cost should be $60",rental.cost(),is(60.00));
	} 
	
	
	@After
	public void tearDown(){
	}
}
