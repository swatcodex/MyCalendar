
package pckg;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyCalendarTester {
	/*
	 * This method asks users for month and years, then it evaluates the weekday
	 * of the first day of that month as well as the number of days in that
	 * month with the current day highlighted
	 */
	public static void main(String[] args) {
		MainMenu menuMain = new MainMenu();
		Calendar now = Calendar.getInstance();
		generatePrintCalendar(now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
		menuMain.menu();
	}

	public static void generatePrintCalendar(int month, int year) {

		try {

			// check if it is a valid month
			if (month < 1 || month > 12)
				throw new Exception("Invalid index for month: " + month);

			// print the calendar for the given month/year.
			printCalendarMonthYear(month, year);

		} catch (NumberFormatException e) {
			// handles NumberFormatException
			System.err.println("Numberat Error: " + e.getMessage());
		} catch (Exception e) {
			// handles any other Exception
			System.err.println(e.getMessage());
		}
	}

	public static void generatePrintCalendar(int month, int year, ArrayList<Integer> eventDates) {

		try {

			// check if it is a valid month
			if (month < 1 || month > 12)
				throw new Exception("Invalid index for month: " + month);

			// print the calendar for the given month/year.
			printCalendarMonthYear(month, year, eventDates);

		} catch (NumberFormatException e) {
			// handles NumberFormatException
			System.err.println("Numberat Error: " + e.getMessage());
		} catch (Exception e) {
			// handles any other Exception
			System.err.println(e.getMessage());
		}
	}

	/*
	 * prints a calendar month based on month / year info
	 */
	private static void printCalendarMonthYear(int month, int year) {
		// create a new GregorianCalendar object
		Calendar cal = new GregorianCalendar();
		int currDate = cal.get(Calendar.DATE);
		// set its date to the first day of the month/year given by user
		cal.clear();
		cal.set(year, month - 1, 1);

		// print calendar header
		System.out.println("             " + cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " "
				+ cal.get(Calendar.YEAR));

		// obtain the weekday of the first day of month.
		int firstWeekdayOfMonth = cal.get(Calendar.DAY_OF_WEEK);

		// obtain the number of days in month.
		int numberOfMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// print anonymous calendar month based on the weekday of the first
		// day of the month and the number of days in month:
		printCalendar(numberOfMonthDays, firstWeekdayOfMonth, currDate);
	}

	/*
	 * prints an anonymous calendar month based on the weekday of the first day
	 * of the month and the number of days in month:
	 */
	private static void printCalendar(int numberOfMonthDays, int firstWeekdayOfMonth, int currDate) {

		// reset index of weekday
		int weekdayIndex = 0;

		// print calendar weekday header
		System.out.println("Su    Mo    Tu    We    Th    Fr   Sa");

		// leave/skip weekdays before the first day of month
		for (int day = 1; day < firstWeekdayOfMonth; day++) {
			System.out.print("      ");
			weekdayIndex++;
		}
		// print the days of month in tabular format.
		for (int day = 1; day <= numberOfMonthDays; day++) {
			if (day != currDate)
				// print day
				System.out.printf("%2d", day);
			else
				System.out.printf("[%d]", day);
			// next weekday
			weekdayIndex++;
			// if it is the last weekday
			if (weekdayIndex == 7) {
				// reset it
				weekdayIndex = 0;
				// and go to next line
				System.out.println();
			} else { // otherwise
				// print space
				System.out.print("    ");
			}
		}

		// print a final new-line.
		System.out.println();
	}

	/*
	 * prints a calendar month based on month / year and dates with events info
	 */
	private static void printCalendarMonthYear(int month, int year, ArrayList<Integer> eventDates) {
		// create a new GregorianCalendar object
		Calendar cal = new GregorianCalendar();
		int currDate = cal.get(Calendar.DATE);
		// set its date to the first day of the month/year given by user
		cal.clear();
		cal.set(year, month - 1, 1);

		// print calendar header
		System.out.println("             " + cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " "
				+ cal.get(Calendar.YEAR));

		// obtain the weekday of the first day of month.
		int firstWeekdayOfMonth = cal.get(Calendar.DAY_OF_WEEK);

		// obtain the number of days in month.
		int numberOfMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// print anonymous calendar month based on the weekday of the first
		// day of the month and the number of days in month:
		printCalendar(numberOfMonthDays, firstWeekdayOfMonth, eventDates);
	}

	/*
	 * prints an anonymous calendar month based on the weekday of the first day
	 * of the month and the number of days in month:
	 */
	private static void printCalendar(int numberOfMonthDays, int firstWeekdayOfMonth, ArrayList<Integer> eventDates) {

		// reset index of weekday
		int weekdayIndex = 0;

		// print calendar weekday header
		System.out.println("Su    Mo    Tu    We    Th    Fr   Sa");

		// leave/skip weekdays before the first day of month
		for (int day = 1; day < firstWeekdayOfMonth; day++) {
			System.out.print("      ");
			weekdayIndex++;
		}
		// print the days of month in tabular format.
		for (int day = 1; day <= numberOfMonthDays; day++) {

			if (eventDates.contains(day))
				// print day
				System.out.printf("[%d]", day);
			else
				System.out.printf("%2d", day);
			// next weekday
			weekdayIndex++;
			// if it is the last weekday
			if (weekdayIndex == 7) {
				// reset it
				weekdayIndex = 0;
				// and go to next line
				System.out.println();
			} else { // otherwise
				// print space
				System.out.print("    ");
			}
		}

		// print a final new-line.
		System.out.println();
	}
}
