import java.util.Scanner;

// (1) Declaring the Kimball12 class

class Kimball12
{
   public static void main( String[] args )
   {
      Scanner scanner = new Scanner( System.in );
      
      // (2) Printing Program 12
      
      System.out.println( "Program 12" );
      
      // (10) The Car objects
      
      Car honda = new Car( "Honda", "Civic", 3000 );
      Car toyota = new Car( "Toyota", "Camry", 3400 );
      Car ford = new Car( "Ford", "F-150", 5000 );
      
      // (11) Driving the cars home using the drive method function
      
      honda.drive( 10 );
      toyota.drive( 10 );
      ford.drive( 10 );
      
      // (12) Printing the info about the car objects
      
      honda.printInfo();
      toyota.printInfo();
      ford.printInfo();
      
      // (13) Using the addFuel method to add five gallons of fuel to the toyota camry
      
      toyota.addFuel( 5 );
      
      // (14) Using input to decide the length of the road trip and then using the drive method function
      
      System.out.print( "How many miles is your road trip? " );
      double roadTripMiles = scanner.nextDouble();
      honda.drive( roadTripMiles );
      toyota.drive( roadTripMiles );
      ford.drive( roadTripMiles );
      
      // (15) Printing the ending info for the cars
      
      honda.printInfo();
      toyota.printInfo();
      ford.printInfo();
   }
}

// (3) Declaring the Car class

class Car
{
   // (4) Instance Variables
   
   String make;
   String model;
   double mpg;
   double milesDriven;
   double fuelGallons;
   
   // (5) The Car Constructor
   
   Car( String carMake, String carModel, double weight )
   {
      make = carMake;
      model = carModel;
      if (weight > 4000)
         mpg = 20;
      else
         mpg = 30;
      milesDriven = 7;
      fuelGallons = 15;
   }
   
   // (6) The addFuel method function
   
   void addFuel( double gallons )
   {
      fuelGallons += gallons;
   }
   
   // (7) The milesLeft method function
   
   double milesLeft()
   {
      double remainingMiles = mpg * fuelGallons;
      return remainingMiles;
   }
   
   // (8) The drive method function
   
   void drive( double miles )
   {
      if ( milesLeft() - miles > 0 )
      {
         milesDriven += miles;
         fuelGallons -= miles / mpg;
      }
      else
      {
         milesDriven += milesLeft();
         fuelGallons = 0;
      }
   }
   
   // (9) The printInfo method function
   
   void printInfo()
   {
      if ( fuelGallons != 0 )
         System.out.printf( "The " + make + " " + model + " has driven " + milesDriven + " miles and has %.2f gallons left\n", fuelGallons);
      else
         System.out.println( "The " + make + " " + model + " has driven " + milesDriven + " miles and is out of gas" );
   }
}
