package esercizio1;



public class FirstMain {

	public static void main(String[] args) {
		


		Rettangolo r1 = new Rettangolo();
		r1.stampaRettangolo();
		
		Rettangolo r2 = new Rettangolo();
		r2.stampaRettangolo();
		
		Rettangolo r3 = new Rettangolo();
		r3.stampaRettangolo();
		
		Rettangolo r4 = new Rettangolo();
		r4.stampaRettangolo();

		System.out.println("");
		Rettangolo.stampaDueRettangoli(r1, r2);
		
		System.out.println("");
		Rettangolo.stampaDueRettangoli(r3, r4);
		
	}

}
