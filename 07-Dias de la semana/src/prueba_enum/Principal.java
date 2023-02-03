package prueba_enum;

/**
 * A Java enum switch statement (switch/case) example.
 * @author alvin alexander, http://alvinalexander.com
 */
public class Principal
{

  public static void main(String[] args)
  {
    // loop through the enum values, calling the
    // print method once for each value
    for (Day d: Day.values())
    {
      printTodaysThought(d);
    }
  }

  // a method that prints a String corresponding to the day value
  // that is passed in.
  public static void printTodaysThought(Day theDay)
  {
    switch (theDay)
    {
      case MONDAY:
      case TUESDAY:
      case WEDNESDAY:
      case THURSDAY:  System.out.println("Working for the man :)");
                      break;

      case FRIDAY:    System.out.println("TGIF ");
                      break;

      case SATURDAY:
      case SUNDAY:    System.out.println("Ahh, the weekend ...");
                      break;

      default:        System.out.println("What day is it?");;
    }
  }
}

/**
 * Our "Day" enum type
 */
enum Day
{
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY 
}