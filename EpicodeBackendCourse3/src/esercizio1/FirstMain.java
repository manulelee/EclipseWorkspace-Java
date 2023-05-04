package esercizio1;

public class FirstMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------PariDispari----------");
		
		System.out.println("Prova pari: " + pariDispari("Pari"));
		System.out.println("Prova dispari: " + pariDispari("Dispari"));
	 
		System.out.println();
		System.out.println("----------AnnoBisestile----------");
		System.out.println("Prova non bisestile: " + annoBisestile(2023));
		System.out.println("Prova bisestile: " + annoBisestile(2024));
		System.out.println("Prova bisestile: " + annoBisestile(2100));
 }	
	public static boolean pariDispari (String n){
		if (n.length()%2==0) {
			return true;
		}
		else {
			return false;
		}
 }

	public static boolean annoBisestile (int n){
		if ((n%100==0 & n%400==0)||n%4==0) {
			return true;
		}
		else {
			return false;
		}
 }

}
