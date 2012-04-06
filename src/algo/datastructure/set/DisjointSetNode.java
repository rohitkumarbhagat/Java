package algo.datastructure.set;

public class DisjointSetNode<T> {
	private T data;
	private int parentIndex;

	public DisjointSetNode(T data, int parentIndex) {

		this.data = data;
		this.parentIndex = parentIndex;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}

}
