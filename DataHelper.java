package pckg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class DataHelper {
	Event mp;
	BufferedWriter bw = null;
	BufferedReader br = null;
	FileWriter fw = null;
	FileReader fr;
	private static final String FILENAME = "events.txt";
	static Map<Date, String> m = new HashMap<Date, String>(); 
	
	//default constructor
	public void populateCalendar(){
		
	}
	
	/***
	 * This method indicates its the first run on the first run
	 * Loads the calendar with events and its corresponding dates from the events.txt file 
	 * present in the users system (which was created in previous run)
	 */
	
	public void load(){
		String[] str = null;
		String newStr = "";
		if(!new File(FILENAME).exists()) { 
		    System.out.println("Either its the first run or you have no events added yet");
		}else{
			//populate calendar
			try {
				fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				String line = null;
				String line1 = null;
				while ((line = br.readLine()) != null) {
					line1 = br.readLine();
					str = line.split("-");
					newStr = str[1].trim()+"/"+str[2].trim()+"/"+str[0].trim();
					mp = new Event(newStr.trim(), line1.trim());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	/***
	 * This method creates an events.txt file on the users system and stores all the
	 * created events during this session. It stores the events in descending order
	 * irrespective of the order of their creation 
	 */
	
	public void quit(){
		try {
			Map<Date, String> m1 = new TreeMap(mp.m);
		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Iterator it = m1.entrySet().iterator();
			    while (it.hasNext()) {
			    	Map.Entry pair = (Map.Entry) it.next();
				    try(FileWriter fw = new FileWriter(FILENAME, true);
							BufferedWriter bw = new BufferedWriter(fw)){
			        bw.write(pair.getKey()+" ");
			        bw.newLine();
			        bw.write(pair.getValue()+"");
			        bw.newLine();
				    }
			    }
		} catch (IOException e) {
				e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
