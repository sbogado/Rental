package model;

import java.util.List;

import model.exception.CompositeRentalMalformedException;

public class FamilyRental extends Rental{

	List<Rental> rentals;
	
	public FamilyRental(List<Rental> rentals) throws CompositeRentalMalformedException{
		if(rentals.size() > 5 || rentals.size() < 3){
			throw new CompositeRentalMalformedException();
		}
		
		this.rentals = rentals;
	}
	
	@Override
	public double cost() {
		double cost = 0;
		
		for(Rental rental : rentals){
			cost = cost + rental.cost();
		}
		return cost * 70 / 100;
	}

	public void addRental(Rental rental) {
		if(rentals.size() < 5){
			rentals.add(rental);
		}
	}
	
	public void removeRental(Rental rental) {
		if(rentals.size() > 3){
			rentals.remove(rental);
		}
	}
	

	public Rental getRental(int index) {
		return rentals.get(index - 1);
	}

}
