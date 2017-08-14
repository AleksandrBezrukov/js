package DAOImplementation;

import java.util.ArrayList;

import DAO.PersonDAO;
import Model.Person;

public class PersonDAO_Mock implements PersonDAO
{
 ArrayList<Person> pp = new ArrayList<Person>();
 
 public PersonDAO_Mock()
 {
  pp.add( new Person(10, "Vasia", "Pupkin", 23) );
  pp.add( new Person(12, "Kasia", "Lupkin", 21) );
  pp.add( new Person(13, "Masia", "Gupkin", 25) );
  pp.add( new Person(17, "Gasia", "Supkin", 36) );
  pp.add( new Person(21, "Zasia", "Fupkin", 99) );
  pp.add( new Person(25, "Jasia", "Dupkin", 90) );
  pp.add( new Person(30, "Basia", "Wupkin", 88) );
 }
 
 @Override
 public void create(Person p) 
 {
  pp.add(p);
 }

 @Override
 public ArrayList<Person> read()
 {
	 //System.out.println("Mock read");
	 return pp;
 }

 @Override
 public void update(Person p) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void delete(Person p)
 {
	  for(int k=0;k<pp.size();k++)
	  {
		  if(p.id==pp.get(k).id)
		  {
			  pp.remove(k);
			  break;
		  }
	  }
  
 }

}