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
		intHeap.add(5);
		intHeap.add(3);
		intHeap.add(10);
		intHeap.add(1);
		intHeap.add(12);
		System.out.println(intHeap);
		intHeap.sort();
		System.out.println("************************");
		System.out.println(intHeap);

	}
}
