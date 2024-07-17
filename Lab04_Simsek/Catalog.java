import java.util.ArrayList;

public class Catalog {
	private int currentProd;
	private ArrayList<Product> prodList;
	
	public Catalog(){
		currentProd = 0;
		prodList = new ArrayList<Product>();
		prodList.add(new Product(12345, "BEKO BREAD MAKER\n White in color\n700 gram capacity\n 600 watts power"+
												"\n12 programs with 3 different settings",
												"BEKO EKMEK YAPMA MAKINESI \nBeyaz renk"+
												"\n700 gr kapasiteli tek hazne"+
												"\n600 W g��"+
												"\n12 farkli program ve \n3 farkli pi�irme se�imi",120.0));
		prodList.add(new Product(12346, "BRAUN BLOOD PRESSURE MONITOR\nExtra comfortable\nHigh-Low pressure warning\nAs accurate as clinic tests"+
												"\nSMALL/MEDIUM 23 - 33 cm",
												"BRAUN �ST KOL MANSETLi \nTANSIYON ALETi\nEkstra konforlu hassas man�et "+
												"\nK���k- B�y�k tansiyon �l��m� "+
												"\nKlinik olarak test edilmis dogruluk"+
												"\nK���k/Orta 23 - 33 cm", 125.0));
		prodList.add(new Product(76345, "PHILIPS HAIR STRAIGHTENER\nAutomatic shutoff after 1 hour\nHeats up quickly\nMatte Chrome Plates"+
												"\nDual Voltage",
												"PHILIPS SA� D�ZLESTiRiCi\n1 saat sonrasinda otomatik \nkapanma "+
												"\nKisa s�rede isinma"+
												"\nMat krom y�zey"+
												"\nD�nya �apinda kullanim i�in �ift voltaj", 101.48));
	
	}
	public Product getProductByPosition(int position){
		return prodList.get(position);
	}
	public int getCurrentProdIndex() {
		return currentProd;
	}
	public void setCurrentProdIndex(int index) {
		currentProd = index;
	}
	public int getCatalogSize(){
		return prodList.size();
	}
}

