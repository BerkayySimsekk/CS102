public class Product {
	
	private int productCode;
	private String engDescription;
	private String turkDescription;
	private double price;
	
	
	public Product(int code, String edesc,String tdesc, double price){
		productCode = code;
		engDescription = edesc;
		turkDescription = tdesc;
		this.price = price;
	}
	public int getProductCode(){
		return productCode;
	}
	public String getEngDescription(){
		return engDescription;
	}
	public String getTurkDescription(){
		return turkDescription;
	}
	
	public double getPrice(){
		return price;
	}
}