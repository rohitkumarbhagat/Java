/**
 * 
 */
package algo.datastructure.tree;

/**
 * @author erotkur
 * 
 */
public class TestMinHeap
{
	public static void main(String[] args)
	{
		MinHeap<Integer> intHeap = new MinHeap<Integer>(Integer.class, 10);
		intHeap.add(1);
		intHeap.add(100);
		intHeap.add(5);
		intHeap.add(200);
		intHeap.add(300);
		intHeap.add(7);
		intHeap.add(8);
//		intHeap.add(12);
		System.out.println(intHeap);
		intHeap.deleteElement(8);
		//intHeap.sort();
		System.out.println("************************");
		System.out.println(intHeap);
		System.out.println("************************");
		intHeap.sort();
		System.out.println(intHeap);

	}
}
