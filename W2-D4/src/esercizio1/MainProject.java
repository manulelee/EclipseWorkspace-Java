package esercizio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	LocalDate today = LocalDate.now();

	Customer me = new Customer( "Emanuele", 2);
	Customer otherCustomer = new Customer("Gianni", 1);
	
	Product b1 = new Product("Lord of the Rings", "book", 10.30);
	Product b2 = new Product("Harry Potter", "book", 8.90);
	Product b3 = new Product("Geronimo Stilton", "book", 7.50);
	
	Product m1 = new Product("Lord of the Rings", "movie", 10.30);
	Product m2 = new Product("Harry Potter", "movie", 8.90);
	
	List<Product> cart1 = new ArrayList<Product>();
	cart1.add(b1);
	cart1.add(b2);
	cart1.add(b3);
	cart1.add(m1);
	cart1.add(m2);
	
	List<Product> cart2 = new ArrayList<Product>();
	cart2.add(m1);
	cart2.add(m2);
	
	//Esercizio 1
	
	//filterCategoryAndPrice(cart1).forEach(p->System.out.println(p));;
	
	//Esercizio 2
	
	Order order1 = new Order ("spedito", today, LocalDate.of(2023,05,14), cart2, me);
	Order order2 = new Order ("in preparazione", today, LocalDate.of(2023,05,15), cart1, otherCustomer);
	
	List<Order> orderList = new ArrayList<Order>();
	orderList.add(order1);
	orderList.add(order2);
	
	
	//filterCategory(orderList, "ciao");
	
	
	}
	
	public static List<Product> filterCategoryAndPrice(List<Product> list){
		Stream<Product> result= list.stream().filter(p -> (p.getCategory() == "book" && p.getPrice()>10));
		
		return result.collect(Collectors.toList());
	}
	
//	public static void filterCategory(List<Order> list, String cat){
//		List<Product> listaFiltrata = new ArrayList<Product>();
//		for (Order o : list) {
//			for (Prodotto p : o) {
//				if(p.getCategory().equals(cat)) {
//					listaFiltrata.add(p);
//				}
//			}
//		}
//	//return listaFiltrata;
//		
//	}

}
