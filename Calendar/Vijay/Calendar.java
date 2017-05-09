/**
 * Created by vijaychandra on 5/5/16.
 */

import java.lang.Integer;

public class Calendar {

    static final String[] MONTHS = new String[] {"January", "February", "March", "April", "May", "June", "July", "August","September",
            "October","November","December"};
    static int[] MonthDays = new int[]{31,28,31,30,31,30,31,31,30,31,30,31,29}; //number of days in each month (29 is for leapyear)

    /**
     * @param Month
     * @param Year
     * @return
     * getDay function takes in two arguments and returns day (int). This function is based on Zeller's congruence: to
     * calculate the day of the week for any given year and month.
     */
    public static int getDay(int Month, int Year){
        int daynumber =1, month, year, day;
        if(Month < 3)
            month = Month+10;
        else
            month = Month-2;
        if(month > 10)
            year = Year-1;
        else
            year = Year;
        day = (((13*month-1)/5)+daynumber+year%100+
                ((year%100)/4)-2*(year/100)+
                (year/400)+77)%7;
        return day; //{1: Monday, 2: Tuesday, 3: Wednesday, 4:Thursday, 5: Friday, 6: Saturday, 0:Sunday}
    }

    /**
     *@param args
     * main takes in two arguments (month, year) and returns nothing. main invokes an external function called getDay
     * and prints out a calendar for the given month, year in unix cal format
     */
    public static void main(String[] args){
        if(args.length == 2 && args[1].length() == 4) { //2 inputs and year is 4 digit
            int month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            if (year > 0 && month > 0 && month <= 12) {
                System.out.println("\t" + MONTHS[month - 1] + " " + year);
                System.out.println(" Su Mo Tu We Th Fr Sa");
                int day = getDay(month, year);
                //setting the first day's position
                for (int x = 0; x < day; x++) {
                    System.out.print("   "); //setting spacer for the first day (1)
                }

                int j = day;

                if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) { //check if Leap year
                    if (month == 2) {
                        for (int i = 1; i <= MonthDays[12]; i++) {
                            if (j++ % 7 == 0) {
                                System.out.printf("  \n"); //line breaker after every 7 numbers in a row
                            }
                            System.out.printf(" %2d", i);
                        }
                    }

                } else { //if the given year is not leap year
                    for (int i = 1; i <= MonthDays[month - 1]; i++) {
                        if (j++ % 7 == 0) {
                            System.out.printf("  \n"); //line breaker after every 7 numbers in a row
                        }
                        System.out.printf(" %2d", i);
                    }
                }
            }
        }
        else{
            System.out.println("Invalid input");
        }
    }
}
