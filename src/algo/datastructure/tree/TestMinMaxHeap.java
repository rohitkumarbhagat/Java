/**
 * 
 */
package algo.datastructure.tree;

/**
 * @author erotkur
 * 
 */
public class TestMinMaxHeap
{
	public static void main(String[] args)
	{
		MinMaxHeap<Integer> minMaxheap = new MinMaxHeap<Integer>(Integer.class, 10);
		minMaxheap.add(1);
		minMaxheap.add(4);
		minMaxheap.add(2);
		minMaxheap.add(5);
		minMaxheap.add(3);
		minMaxheap.add(-1);
		System.out.println(minMaxheap);
		System.out.println("--------------------------");
		minMaxheap.deleteMax();
		minMaxheap.deleteMax();
		minMaxheap.deleteMax();
		minMaxheap.deleteMax();
		System.out.println(minMaxheap);
		System.out.println("--------------------------");
		minMaxheap.deleteMin();
		System.out.println(minMaxheap);

	}
}
