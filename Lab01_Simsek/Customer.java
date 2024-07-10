package Lab01_Simsek;

/**
 * @(#)Customer.java
 *
 *
 * @author 
 * @version 1.00 2018/1/15
 */


public class Customer {
	private String custName;
	private String custEmail;
	private boolean dietCustomer;
	//Data member to store customer FoodOrder
    private FoodOrder custFoodOrder;
	
	//update constructor to initialize FoodOrder
    public Customer(String custName, String custEmail, boolean dietCustomer) {
    	this.custName = custName;
    	this.custEmail = custEmail;
    	this.dietCustomer = dietCustomer;
        custFoodOrder = new FoodOrder();
    }
    public void setCustName(String custName){
    	this.custName = custName;
    }
    public String getCustName(){
    	return custName;
    }
    public void setCustEmail(String custEmail){
    	this.custEmail = custEmail;
    }
    public String getCustEmail(){
    	return custEmail;
    }
    //getter method for food order
    public FoodOrder getFoodOrder() {
        return custFoodOrder;
    }
    
    //get total calories
	public int getTotalCalories() {
        return custFoodOrder.calculateTotalCalories();
    }
	
	
    public String toString(){
    	return "Customer Name: " + custName + "\nCustomer E-mail: " + custEmail + "\nCustomer's diet status: " + dietCustomer + "\n" + custFoodOrder;
    }
    
    
}