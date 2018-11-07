# Rental

# Right now, in my actual job in Sysone, im working using Java 1.7 so i used it to resolve what it is asking 
because i just have to focus on the design and resolution.
# The Rental excercise from the very beggining had an smell of the Composite Design Pattern. It made me to
go in that direction.
The model is composed basically by 3 parts, Rental, Leaf Rental, and Composite Rental.

- Rental is an abstract class that represents a common interface of any Rental class.
It defines the common interface behavior of any Rental. First is the method "cost" that returns a double representing an amount of money.
I decided to add "Composite Rental" behavior too, to make Rental subclasses being accessed transparently regardless if they are
Composite Rentals or Leaf Rental. By default, Rental will throws UnsupportedOperationException when
messages are being send to it corresponding to a Composite Rental class to force the external classes to handle
the situation when a Rental is a Leaf Rental.

- RentalBYHour, RentalByDay, RentalByWeek are classes used to model a Leaf Rental

- FamilyRental is the Composite Rental class in this design pattern. It is internally composed by many Rentals which
are used to define the "cost" Rental behavior.

I made another decision that consists in implement FamilyRental's contructor to receive a collection of Rental
and then validate that the size is between 3 and 5 following the exercise requirements, not allowing to make an instance of FamilyRental inconsistently.

# Is out of my habit to practice unit testing, it is not something that we do because of the nature of the company's projects.
I tried to apply TDD learned in the University and i hope have made it well.
I used JUnit 4 Library to make the tests and i ran them using "eclipse | run as | Junit " from the project.
