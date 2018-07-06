package rodzina.com.example.Rodzina;

import java.sql.Date;

public class Osoba {
	int ID;
	String FirstName;
	String PESEL;
	Date BirthDate;
	String SecondName;
	String Sex;
	
	//Konstruktor osoby:
	public Osoba(){
		
	}
	
	//Konstruktor osoby:
	public Osoba(String name, String pesel, Date birthdate, String secondname, int id){
		this.FirstName=name;
		this.PESEL=pesel;
		this.BirthDate=birthdate;
		this.SecondName=secondname;
		this.ID=id;
	}
	public Osoba(String name, String pesel, String sex, String secondname) {
		this.FirstName=name;
		this.PESEL=pesel;
		this.Sex=sex;
		this.SecondName=secondname;
	}
	
	
	//Ustaw Imie
	void SetImie(String name){
		this.FirstName=name;
	}
	//Ustaw Date
	void SetDate(Date birthdate){
		this.BirthDate=birthdate;
	}
	//Ustaw Pesel
	void SetPesel(String pesel){
		this.PESEL=pesel;
	}
	//Ustaw Nazwisko
	void SetSecond(String secondname) {
		this.SecondName=secondname;
	}
	//Ustaw Plec
	void SetSex(String sex) {
		this.Sex=sex;
	}
	//Ustaw ID
	void SetID(int id) {
		this.ID=id;
	}
	
	
	//Pobierz Imie
		String GetImie(){
			return this.FirstName;
		}
		//Pobierz Date
		Date GetDate(){
			return this.BirthDate;
		}
		//Pobierz Pesel
		String GetPesel(){
			return this.PESEL;
		}
		//Pobierz Nazwisko
		String GetSecond() {
			return this.SecondName;
		}
		//Pobierz Plec
		String GetSex() {
			return this.Sex;
		}
		//Pobierz ID
		int GetID() {
			return this.ID;
		}
}
