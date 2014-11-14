/**
 * Address Book defines the features available for the address book application
 * @author Padma Priya
 *
 */
package Controller;

import java.util.ArrayList;
import java.util.Date;
import Model.ContactList;
import Model.Person;


public class AddressBook {
	
	ArrayList<Person> contactlist;
	
	/**
	 * constructor
	 * @param objContacts
	 */
	public AddressBook(ContactList objContacts) {
		// TODO Auto-generated constructor stub
		
		contactlist = objContacts.getContactlist();
		
	}	
	
	/**
	 * gets the no of males in the contact list
	 * @return
	 */
	public int getNumberOfMales()
	{
		int noOfMales = 0;
		for(int i=0; i < contactlist.size(); i++)
		{
			Person contact = contactlist.get(i);
			if(contact.getGender().equalsIgnoreCase("male"))
				noOfMales++;
			
		}
		return noOfMales;
	}
	
	
	/**
	 * gets the oldest person's name in the contact list
	 * @return
	 */
	public String getOldestPerson()
	{
		int oldpersonid = 0;
		String oldpersonname = "";
		for(int i=1; i < contactlist.size() ; i++)
		{
			//Person contact = ;
			Date d1 = contactlist.get(oldpersonid).getDob();
			Date d2 = contactlist.get(i).getDob();
			
			if(d1.after(d2))
				oldpersonid = i;
			
		}
		return contactlist.get(oldpersonid).getName();
	}
	
	/**
	 * compare 2 person's dob and return the no of days 
	 * @param person1
	 * @param person2
	 * @return
	 */
	public int getDaysOlder(String person1, String person2)
	{
		int noDaysOlder = 0;
		int ind1 = findPersonByName(person1) ;
		int ind2 = findPersonByName(person2); 
		if((ind1 != -1) && (ind2 != -1))
				{
			noDaysOlder = (int) ((contactlist.get(ind2).getDob().getTime() - contactlist.get(ind1).getDob().getTime())/ (1000 * 60 * 60 * 24));
			
				}
		
		return noDaysOlder;
	}
	
	/**
	 * find the person object using his name
	 * @param name
	 * @return
	 */
	private int findPersonByName(String name)
	{
		int index = -1;
		for(int i=0; i < contactlist.size(); i++)
		{
			Person contact = contactlist.get(i);
			if(contact.getName().equalsIgnoreCase(name))
				return i;
			
		}
		
		return index;
		
	}
	
}
