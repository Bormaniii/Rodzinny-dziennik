package rodzina.com.example.Rodzina;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RodzinaApplication {

	public static void main(String[] args) {
		//Uruchomienie aplikacji
		 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      int fatherID;
		 
	    //Laczenie sie z baza danych  
		 FatherJDBC FatherJDBCObject = 
	         (FatherJDBC)context.getBean("fatherJDBC");
		 

	      //pobranie z bazy danych wszystkich ojców
	      List<Father> fathers = FatherJDBCObject.getAllFathers();
	      
	      //Ustalenie ID ostatniego ojca
	      for (Father record : fathers) {
	    	  fatherID = record.GetID();
	      }
	      
	      
		 
		 //Dodanie przykladowego ojca
	      @SuppressWarnings("deprecation")
		Date Birth = new Date(1995-1900, 02-1, 27);
	      
	      Father father = new Father();
	      father.SetImie("Kamil");
	      father.SetDate(Birth);
	      father.SetPesel("98032114574");
	      father.SetSecond("Bore");
	      fatherID =+ 1;
	      
	      
	      //Dodaje ojca
	      FatherJDBCObject.addFather(father);	 
	      fathers.add(father);
	      father.SetID(fatherID);
	      System.out.println(fatherID);
	      //Tworzy dziecko
	      Child child = new Child();
	      child.SetImie("Krzys");
	      child.SetSecond("Kmiec");
	      child.SetPesel("20032354609");
	      child.SetSex("male");
	      child.SetID(fatherID);
	      //Dodaje dziecko
	      FatherJDBCObject.addChild(child);
	      
	      	      	      
	      //Dodaje rodzine
	      FatherJDBCObject.addFamily();
	      //pokolei wyswietla ojcow oraz przypisane im dzieci
	      for (Father record : fathers) {
	         System.out.print("Imie : " + record.GetImie());
	         System.out.println(", Data : " + record.GetDate());
	         System.out.println(", Pesel : " + record.GetPesel());
	         System.out.println(", Nazwisko : " + record.GetSecond());
	         System.out.println(", ID : " + record.GetID());
	         int id = record.GetID();
	         
	         List<Child> children = FatherJDBCObject.getChildren(id);
	         if(!children.isEmpty()) {
		      System.out.println("Dzieci ojca " + record.GetImie());
		      for (Child recordchild : children) {
		    	  System.out.print("Imie : " + recordchild.GetImie());
			      System.out.print(", Plec : " + recordchild.GetSex());
			      System.out.println(", Pesel : " + recordchild.GetPesel());
			      System.out.println(", Nazwisko : " + recordchild.GetSecond());			      
		      }
	         }
	      }

}
		
}
