package esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import esercizio1.FirstMain;


public class SecondMain {

	static Logger log = LoggerFactory.getLogger(FirstMain.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = orderedList(10);
		//myList.forEach(li -> System.out.println(li));
		//System.out.println("");
		myList.forEach(li -> log.info(li.toString()));
		System.out.println("");
		List<Integer> revertedList = returnReverted(myList);
		revertedList.forEach(li -> log.info(li.toString()));
		System.out.println("");
		printEvenOdd(myList, true);
		printEvenOdd(myList, false);
	}
	
	public static List<Integer>  orderedList (int n) {
		List<Integer> numberList = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			numberList.add(randomNumberGenerator());
		}
		return numberList;
	}
	public static int randomNumberGenerator() {
		  Random r = new Random();
		   int n = r.nextInt(101);
			return n;
		}
	
	public static List<Integer>  returnReverted(List<Integer> list) {
		List<Integer> revertedList = new ArrayList<Integer>();
		Object[] arr = list.toArray();
		//revertedList=list;
		for (int i=arr.length-1; i>0; i--) {
			revertedList.add((Integer) arr[i]);
		}
		return revertedList;
	}

	public static void printEvenOdd(List<Integer> list, boolean b) {
		
		Object[] arr = list.toArray();
		for (int i=0; i<arr.length; i++) {
			if (b) {
				if (i%2==0) {
					log.info("Indice pari "+ i + ": " + arr[i]);
				}
			}
			else {
				if (i%2!=0) {
					log.info("Indice dispari "+ i + ": " + arr[i]);
				}
			}
		}
		
	}
}
