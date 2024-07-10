package Lab01_Simsek;

/**
 * @(#)MenuApp.java
 * @author CS102
 * @version 1.00 2022/06/13
 */
import java.util.*;
import java.io.*;
public class MenuApp {
   	public static int MAX_CUSTOMERS = 1000;
   	
    public static void main(String[] args) throws IOException{
		String email;

		Scanner in = new Scanner(System.in);
		Customer[] customerList = new Customer[MAX_CUSTOMERS];
		
		customerList = loadCustomers("customers.txt");

		displayCustomersWithMeatInFoodOrder(customerList);

		System.out.print("Enter the E-mail of the customer to empty their food order: ");
		email = in.next();
		emptyFoodOrder(email, customerList);

		displayAllCustomers(customerList);

		in.close();
    }

	public static void displayCustomersWithMeatInFoodOrder(Customer[] customerList) {
		
		System.out.println("Customers with meat in their food order: ");

		for(int n = 0; n < customerList.length; n++) {
			if(customerList[n].getFoodOrder().searchYemekSepeti("meat").size() != 0) {
				System.out.println(customerList[n]);
			}
		}

		System.out.println();
	}

	public static void emptyFoodOrder(String email, Customer[] customerList) {
		boolean isFound;

		isFound = false;

		for(int n = 0; n < customerList.length; n++) {
			if(customerList[n].getCustEmail().equals(email)) {
				customerList[n].getFoodOrder().emptyYemekSepeti();
				System.out.println("The food order is emptied");
				isFound = true;
			}	
		}

		if(!isFound) {
			System.out.println("Customer with that E-mail cannot be found");
		}
	}	


	public static void displayAllCustomers(Customer[] customerList) {
		System.out.println("All of the customers: ");

		for(int n = 0; n < customerList.length; n++) {
			System.out.println(customerList[n]);
		}

		System.out.println();
	}
    
    public static Customer[] loadCustomers(String fileName) throws IOException{
    	int custCount = 0;
    	//Create array to store Customers (at most MAX_CUSTOMERS)
    	Customer[] customers = new Customer[MAX_CUSTOMERS];
    	
    	//create Scanner to read from file
		File file = new File("C:\\Git\\CS102\\Lab01_Simsek\\customers.txt");
    	Scanner inFile = new Scanner(file);
    	
    	//tokens in file delimited by semi-colon
    	inFile.useDelimiter(";");
    	inFile.useLocale(Locale.US);
    	
    	//while file has more data
    	while(inFile.hasNext()){
    		//read customer data
    		String customerName = inFile.next();
    		String customerSurname = inFile.next();
    		String email = inFile.next();
    		boolean diet = inFile.nextBoolean();
    		
    		/************create new Customer**************/
    		Customer customer = new Customer((customerSurname + ", " + customerName), email, diet);
    		
    		//read number of MenuItems for Customer 
    	    int numItems = inFile.nextInt();
 	    
 	    	//read the MenuItem data from file
    	    for(int i = 0; i < numItems; i++){
    	    	String itemData = inFile.next();

    	    	String[] data = itemData.split("-");
    	    	String itemName = data[0];
    	    	String itemDescription = data[1];
    	    	int ingredients  = Integer.parseInt(data[2]);
    	    	int calories = Integer.parseInt(data[3]);
    	    	double itemCost = Double.parseDouble(data[4]);
    	    	
    	    	/************create MenuItem**************/
    	    	MenuItem menuItem = new MenuItem(itemName, itemDescription, ingredients, calories, itemCost);
    	    	
    	    	/************add MenuItem to Customer's FoodOrder**************/
    	    	customer.getFoodOrder().addItemToYemekSepeti(menuItem);
    	 
    	    }
    	    /************add Customer to array of Customers**************/
    	    customers[custCount] = customer;
			custCount++;
    	}
    	inFile.close();
    	
    	/************Trim empty elements from the array of Customers**************/
    	customers = Arrays.copyOf( customers, custCount);
    	
    	//return array of customers
    	return customers;
    }
    
}
