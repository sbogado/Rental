package model;

public abstract class Rental {

	public abstract double cost();
	
	public void addRental(Rental rentalByHour){
		throw new UnsupportedOperationException();
	}
	
	public void removeRental(Rental rentalByHour){
		throw new UnsupportedOperationException();
	}
	

	public Rental getRental(int index) {
		throw new UnsupportedOperationException();
	}
}
