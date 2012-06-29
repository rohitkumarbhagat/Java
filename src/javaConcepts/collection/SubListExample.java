package javaConcepts.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubListExample {
	public static void main(String[] args) {
		Integer[] a={1,2,3,4,5,6,7,8,9};
		List<Integer> alist=new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> sub=alist.subList(0, 4);
		alist.remove(0);
		sub.clear();
		
		
		System.out.println();
		alist.remove(0);
		sub.toString();
		
		
	}

}
