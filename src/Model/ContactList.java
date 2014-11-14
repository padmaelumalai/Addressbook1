/**
 * Stores the list of persons object as contact list
 * @author Padma Priya
 *
 */

package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class ContactList {

	private ArrayList<Person> contactlist = new ArrayList<Person>();

	public ArrayList<Person> getContactlist() {
		return contactlist;
	}

	public void setContactlist(ArrayList<Person> contactlist) {
		this.contactlist = contactlist;
	}

	
	public boolean addtoContactList(String filepath){
		//BufferedReader reader;
		String line = "";
		try {
			BufferedReader  reader = new BufferedReader(new FileReader(filepath));
			while ((line = reader.readLine()) != null) {
				String[] linecontents = line.split(",");
				Person contact = new Person();
				contact.setName(linecontents [0].trim());
				contact.setGender(linecontents[1].trim().toLowerCase());
				Date dob = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH).parse(linecontents[2].trim());
				contact.setDob(dob);
				contactlist.add(contact);
				
			}
			
			return true;
		}catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + filepath);
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			System.out.println("Unable to read the file : " + filepath);
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println("Current line : " + filepath);
			e.printStackTrace();
			return false;
		}
	}

}
