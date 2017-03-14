package pckg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Event {
	private static final String FILENAME = "events.txt";
	static Map<Date, String> m = new HashMap<Date, String>(); 
	Scanner s = new Scanner(System.in);
	Calendar cl = new GregorianCalendar();
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	//default constructor 
	public Event(){
		
	}
	
	/*** parameterized constructor
	 * It takes the date and event as input and sets it to the record of events maintained by the calendar 
	 * @param d date
	 * @param s event
	 */
	
	public Event(String d, String s){
		try {
			m.put(new java.sql.Date(dateFormat.parse(d).getTime()), s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * This method updates the event record of the calendar when user chooses to create an event
	 */
	public void scheduleEvent(){
		try{
		String title = s.nextLine();
		String date = s.nextLine();
		String time = s.nextLine(); 
		m.put(new java.sql.Date(dateFormat.parse(date).getTime()),title+" "+time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 *  This method lets the user delete an event on the calendar
	 * @param eventToDelete date of the event that user wants to delete
	 */
	public void deleteEvent(String eventToDelete){
		try{
		Date k = new java.sql.Date(dateFormat.parse(eventToDelete).getTime());
		if(m.containsKey(k)){
			m.remove(k);
			deleteEventFile();
		}
		else{
			System.out.println("No event to delete");
		}
		}catch(ParseException e){
			System.out.println("Date not in correct format");
		}
	}
	
	/***
	 * This method deletes all events, it calls deleteEventFile method
	 */
	public void deleteAll(){
		if(m.isEmpty()){
				System.out.println("No event to delete");
		}
		m.clear();
		deleteEventFile();
	}
	
	/***
	 * This method deletes events.txt file on the system
	 */
	public void deleteEventFile(){
		Path path = Paths.get(FILENAME);
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
	}
	
	/***
	 * This method fetches from the calendar and prints events based on user entered date
	 */
	public void showEvent(){
		try{
		System.out.println("Enter a date in the form of MM/DD/YYYY");
		String dayViewOfDate = s.nextLine();
		Date dvd = new java.sql.Date(dateFormat.parse(dayViewOfDate).getTime());
		if(m.containsKey(dvd)){
			String month = cl.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			String day = cl.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
			System.out.println(day+", "+month+" "+cl.get(Calendar.DATE)+", "+cl.get(Calendar.YEAR));
			System.out.println(m.get(dvd));
		}
		else{
			System.out.println("No event on day "+dayViewOfDate);
		}
		}
		catch(ParseException e){
			System.err.println("Date not in the right format");
		}
	}
	
	/***
	 * This method fetches from the calendar and prints all events on the calendar
	 */
	public void showAll(){
		System.out.println("Dates are in format yyyy-dd-mm so its easier to compare order");
			Iterator it = m.entrySet().iterator();
		    while (it.hasNext()) {
		    	Map.Entry pair = (Map.Entry) it.next();
		    	System.out.println(pair.getKey()+" "+pair.getValue());
		    
		    }
	}
}
