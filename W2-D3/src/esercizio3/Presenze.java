package esercizio3;




public class Presenze implements Runnable{

	String nome;
	int presenze;
	
	public Presenze(String n, int p) {
		this.nome = n;
		this.presenze = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome + "@" + this.presenze;
	}
	
}