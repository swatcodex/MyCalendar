package pckg;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class View {
	MyCalendarTester test = new MyCalendarTester();
	Calendar o1 = new GregorianCalendar();
	Calendar o2 = new GregorianCalendar();
	Event evnt = new Event();
	ArrayList<Integer> al = new ArrayList<>();
	private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	/***
	 * This method prints out the result for option D followed by V
	 * It takes no input and when called fetches the current date and checks if there are events 
	 * scheduled for the current date
	 * It prints the date and events if any
	 * Prints "no events" if not
	 */
	
	public void dayView() {
		try{
		o1 = new GregorianCalendar();
		String today = df.format(o1.getTime()); 
		Date d = new java.sql.Date(df.parse(today).getTime());
		if(evnt.m.containsKey(d)){
			String showDate = new SimpleDateFormat("MMMM dd, yyyy").format(o1.getTime());
			System.out.println(evnt.m.get(d));
		}
		else{
			System.out.println("No events");
		}
		navigate('d');
		}
		catch(ParseException e){
			System.err.println("Enter date in MM/dd/yyy format");
		}
	}
	
	/***
	 This method prints out the result for option M followed by V
	 * It takes no input and when called fetches the current month 
	 * It prints the month calendar with day highlighted 
	 */
	
	public void monthView(){
		String[] k = null;
		if(!al.isEmpty()) al.clear();
		if(!evnt.m.isEmpty()){
			for(Date i : evnt.m.keySet()){
				k = i.toString().split("-");
			if(Integer.valueOf(k[1]) == (o2.get(Calendar.MONTH)+1) && Integer.valueOf(k[0]) == (o2.get(Calendar.YEAR))) {
				al.add(new Integer(k[2]));
			}
			}
				test.generatePrintCalendar(Integer.valueOf(k[1]),Integer.valueOf(k[0]), al);
			}
		else System.out.println("No events added");
		navigate('m');
	}
	
	/***
	 This method serves navigation for Previous, Next and Main menu options after option D or 
	 * M followed by V
	 * It takes an input as either D or M and fetches previous/next day with events
	 * or previous/next month based on the input and displays the result to the user
	 */
	
	public void navigate(char c){
		MainMenu m = new MainMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("[P]revious or [N]ext or [M]ain menu ? ");
		String choice = sc.nextLine();
		if(choice.charAt(0)=='M'){
			m.menu();
		}
		else if(choice.charAt(0)=='P'){
			if(c=='m'){
				String[] k = null;
				if(!al.isEmpty()) al.clear();
				if(!evnt.m.isEmpty()){
					for(Date i : evnt.m.keySet()){
						k = i.toString().split("-");
					if(Integer.valueOf(k[1]) == (o2.get(Calendar.MONTH)) && Integer.valueOf(k[0]) == (o2.get(Calendar.YEAR))) {
						al.add(new Integer(k[2]));
						test.generatePrintCalendar(Integer.valueOf(k[1]),Integer.valueOf(k[0]), al);
					}
					}
				}
			}
			else if(c=='d'){
				String[] pieces;
				o1.add(Calendar.DATE ,-1);
				DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				String checkDate = new SimpleDateFormat("MM/dd/yyyy").format(o1.getTime());
				System.out.println(new SimpleDateFormat("MMMM dd, yyyy").format(o1.getTime()));
				try {
					pieces = checkDate.split("/");
					checkDate = pieces[2]+"-"+pieces[0]+"-"+pieces[1];
					Date d = new java.sql.Date(f.parse(checkDate).getTime());
					if(evnt.m.containsKey(d)){
						System.out.println(evnt.m.get(d));
					}
					else{
						System.out.println("No event scheduled");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}else if(choice.charAt(0)=='N'){
			if(c=='m'){
				String[] k = null;
				if(!al.isEmpty()) al.clear();
				if(!evnt.m.isEmpty()){
					for(Date i : evnt.m.keySet()){
						k = i.toString().split("-");
					if(Integer.valueOf(k[1]) == (o2.get(Calendar.MONTH)+2) && Integer.valueOf(k[0]) == (o2.get(Calendar.YEAR))) {
						al.add(new Integer(k[2]));
						test.generatePrintCalendar(Integer.valueOf(k[1]),Integer.valueOf(k[0]), al);
					} 
					}
				}
			}
			else if(c=='d'){
				String[] pieces;
				o1.add(Calendar.DATE ,1);
				DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(new SimpleDateFormat("MMMM dd, yyyy").format(o1.getTime()));
				String checkDate = new SimpleDateFormat("MM/dd/yyyy").format(o1.getTime());
				try {
					pieces = checkDate.split("/");
					checkDate = pieces[2]+"-"+pieces[0]+"-"+pieces[1];
					Date d = new java.sql.Date(f.parse(checkDate).getTime());
					if(evnt.m.containsKey(d)){
						System.out.println(evnt.m.get(d));
					}
					else{
						System.out.println("No event scheduled");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("Invalid choice, showing main menu..");
		}
	}
}
