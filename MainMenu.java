package pckg;

import java.util.Scanner;

public class MainMenu {
	
	/***
	 * This method displays the menu options for the user
	 * The next options are displayed based on the current chosen option 
	 * It reads input entered by user to decide which method calls to make and what to display
	 * to the user
	 */
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		View v = new View();
		Event c = new Event();
		DataHelper dh = new DataHelper();
		System.out.println("Select one of the following options:");
		System.out.println("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
		String option = in.nextLine();
		while(true){
		switch(option.charAt(0)){
		case 'L':
			dh.load();
			break;
		case 'V':
			System.out.println("[D]ay view or [M]view ?");
			String viewOption = in.nextLine();
			switch(viewOption.charAt(0)){
			case 'D':
				v.dayView();
				break;
			case 'M':
				v.monthView();
				break;
			}
			break;
		case 'C':
			c.scheduleEvent();
			break;
		case 'G':
			c.showEvent();
			break;
		case 'E':
			c.showAll();
			break;
		case 'D':
			System.out.println("[S]elected or [A]ll ?");
			String delOption = in.nextLine();
			switch(delOption.charAt(0)){
			case 'S':
				System.out.println("Enter the date");
				c.deleteEvent(in.nextLine());
				break;
			case 'A':
				c.deleteAll();
				break;
			}
			break;
		case 'Q':
			dh.quit();
			System.exit(0);
			break;
		default:
			//
		}
		System.out.println("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
		option = in.nextLine();
		}
	}
}
