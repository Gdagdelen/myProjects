package day08;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
public class BookStore {
	/* 	
	    Let’s write an application for bookstores
		Rules
		You should create book id for every book. It should be start from 1000
		Every book should have some information like name, author, year of publication and price
		Program should start with a menu for user can pick any option
		1) add book
		2) search by book id
		3) search by any information
		4) delete by book id
		5) List all books
		6) Quit
	 */
	
	
	static int id=1000;	
	static String name;
	static String author;
	static int year;
	static double price;
	
	static HashMap<Integer, String> books = new HashMap<>();
	
	public static void main(String[] args) {	
		
		addSomeBooks();
		menu();
	
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Make your choice");
		System.out.println("1) Add book\r\n" +
				"2) Search by book id\r\n" +
				"3) Search by information\r\n" +
				"4) Delete by book id\r\n" +
				"5) List all books\r\n" +
				"6) Quit");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			addBook();
			break;
		case 2:
			searchById();
			break;
		case 3:
			searchByInfo();
			break;
		case 4:
			deleteById();
			break;
		case 5:
			bookList();
			break;
		case 6:
			quit();
			break;
		default:
			System.out.println("Please choice 1,2,3,4,5,6");	
		}
	}
	
	public static void addBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Book Name");
		name = scan.nextLine();
		
		System.out.println("Enter Author Name");
		author = scan.nextLine();
		
		System.out.println("Enter Year of Publication");
		year = scan.nextInt();
		System.out.println("Enter Price of Book");
		price = scan.nextDouble();
		
		String information = name + ", " + author + ", " + year + ", " + price;
		books.put(id, information);
		
		id++;
		menu();
		
	}
	public static void searchById() {
        Scanner  scan = new Scanner(System.in);
        System.out.println("Please enter the id of the book to see its informations");
        int key= scan.nextInt();
        System.out.println(books.get(key));
        menu();
    }
	public static void searchByInfo() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter any information about book");
		String searchInfo=scan.nextLine();
		boolean flag = true;
		for (Entry<Integer, String> entry : books.entrySet()) {
			if (entry.getValue().contains(searchInfo)) {
				System.out.println("Id = " + entry.getKey() + ", Book Information= " + entry.getValue());
				flag = true;
			}
		} if(!flag) {
			System.out.println("aradiginiz kitap bulunamadi");
		}
		System.out.println("============================");
		menu();		
	}
	
	public static void deleteById() {
		 Scanner  scan = new Scanner(System.in);
	     System.out.println("Please enter the id of the book you want to delete");
	     int key= scan.nextInt();
	     if (books.isEmpty()) {
	            System.out.println("The list is empty"); 
	     }
	     if(!books.containsKey(key)) {
	    	 System.out.println("ID doesn't match with any book from the store ");
	     } else
	    	 System.out.println(books.remove(key));
	     menu();
	}
	
	public static void bookList() {
		if(books.isEmpty()) {
			System.out.println("Book list is empty");
		}else {
			for(Integer keys: books.keySet()) {
				System.out.println(keys+ ": " +books.get(keys));
			}
		}
		
	}
	
	public static void quit() {
		System.out.println("Thanks. Take care...");	
	}

	public static void addSomeBooks() {
		books.put(9999, "Lords, John , 2001, 11");
		books.put(9998, "Countries, Ted, 2005, 10");
		books.put(9997, "Illness, Tulin, 2005, 21");
		books.put(9996, "Roads, Suzan, 2005, 30");		
	}
	
	
}
