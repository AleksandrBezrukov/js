package DAO;
import java.util.ArrayList;

import Model.Person;


public interface PersonDAO
{
	 void create(Person p);//  throws  SQLException;
	 ArrayList<Person> read();// throws  SQLException;
	 void update(Person p);//  throws  SQLException;
	 void delete(Person p);//  throws  SQLException;
	 //void startwork();
	 //void finishwork();

}