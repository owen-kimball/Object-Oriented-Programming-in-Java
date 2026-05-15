/**

This program revolves around a particular problem: 10 people go to a restraunt, and they decide that
those who buy just a drink get their meals for free, while everyone else splits the cost evenly between
themselves. 2 random people just get drinks, while the other 8 will pay for the meal. This program
simulates this situation.

*/

import java.util.Random;

class Kimball10
{
   // This defines the number of people and the arrays of names and amounts.
   static final int NUM_PEOPLE = 10;
   static double[] amounts = new double[NUM_PEOPLE];
   static String[] names = {"Alice","Bob","Clarence","Dan","Edward","Florence","Gregory","Henry","Ivan","James"};
   
   public static void main( String[] args )
   {
      // This is the tenth Java program.
      System.out.println( "Program 10" );
      
      // This creates a new Random object called rand.
      Random rand = new Random();
      
      // This causes each index in the amounts array to get a random number between 8.50 and 24.99.
      for (int i = 0; i < NUM_PEOPLE; i++)
      {
         double amount = (rand.nextInt( 1650 ) / 100.0) + 8.5;
         amounts[i] = amount;
      }
      
      // This chooses one person to pay only $1.75.
      int index1 = rand.nextInt( NUM_PEOPLE );
      amounts[index1] = 1.75;
      
      // This chooses another person to pay only $1.75 while also making sure it is not the same person as before.
      int index2 = NUM_PEOPLE;
      do
      {
         index2 = rand.nextInt( NUM_PEOPLE );
      }
      while (index2==index1);
      amounts[index2] = 1.75;
      
      // This prints each person's name and what they paid, as well as the total payment.
      double total = 0.0;
      for (int i = 0; i < NUM_PEOPLE; i++)
      {
         System.out.printf( names[i] + "'s lunch cost $%.2f\n", amounts[i] );
         total = total + amounts[i];
      }
      System.out.printf( "total = %.2f\n", total );
      
      // This calculates the tax and the tip, and then gives the total bill payment.
      double tax = total * 0.0725;
      System.out.printf( "tax = %.2f\n", tax );
      double tip = total * 0.18;
      System.out.printf( "tip = %.2f\n", tip );
      double totalBill = total + tax + tip;
      System.out.printf( "total bill = %.2f\n", totalBill );
      
      // This calculates what each person needs to pay and displays it.
      double cost = perPersonCost( totalBill );
      for (int i = 0; i < NUM_PEOPLE; i++)
      {
         if (amounts[i] != 1.75)
         {
            System.out.printf( names[i] + " owes $%.2f\n", cost );
         }
         else
         {
            System.out.println( names[i] + " got a free drink." );
         }
      }

   }
   
   // This function splits the cost evenly between those who paid for more than drinks.
   static double perPersonCost( double totalBill )
   {
      double costPerPerson = totalBill / (NUM_PEOPLE - 2);
      return costPerPerson;
   }
}