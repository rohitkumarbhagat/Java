package algo.datastructure.tree;

public class MinHeapNode<T extends Comparable<T>> implements Comparable<T> {
	T data;
	int index;

	@Override
	public int compareTo(T o) {
		String a="";
		// TODO Auto-generated method stub
		return data.compareTo(o);
	}
}