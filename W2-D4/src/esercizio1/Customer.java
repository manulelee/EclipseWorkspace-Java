package esercizio1;

public class Customer {
private static long id = 0;
private String name;
private int tier;


public Customer( String name, int tier) {
	this.name = name;
	this.tier = tier;
	id++;
}


}
