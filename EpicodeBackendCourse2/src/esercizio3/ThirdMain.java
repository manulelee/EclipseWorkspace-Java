package esercizio3;


public class ThirdMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Articolo articolo1 = new Articolo("0123", "iPhone 11", 879.12, 10);
		 Articolo articolo2 = new Articolo("0234", "iPad", 316.67, 4);
		 Articolo articolo3 = new Articolo("0531", "macBook pro", 1353.21, 6);
		 
		 articolo1.stampaDescrizione();
		 articolo2.stampaDescrizione();
		 articolo3.stampaDescrizione();
		 
		Cliente me = new Cliente("00001", "Emanuele", "Syrbe", "emanuele.sy@gmail.com", "02/05/2023", new Carrello(new Articolo[10], "00001") ) ;
		
		me.stampaCliente();
		
		
	}

}
