package algo.datastructure.tree;

public class TestMedianHeap {
public static void main(String[] args) {
	MedianHeap medianHeap=new MedianHeap(10);
	medianHeap.add(3);
	System.out.println(medianHeap);
	System.out.println("Median = "+medianHeap.getMedian());
	medianHeap.add(6);
	medianHeap.add(1);
	//medianHeap.add(-11);
	medianHeap.add(5);
	medianHeap.add(100);
	medianHeap.add(9);
	medianHeap.add(7);
	medianHeap.add(9);
	medianHeap.add(8);
	medianHeap.add(198);
	System.out.println(medianHeap);
	System.out.println("Median = "+medianHeap.getMedian());
}
}
