/**
 * 
 */
package graph;

/**
 * @author erotkur
 * 
 */
public class GraphNode
{

	private int[] edges;

	private int length = 0;

	private int capacity;

	private int color = 0;

	// time when discovered
	private int dTime;

	// time when finished processing
	private int fTime;

	private int vertexNo;

	private int parentVertexNo;

	public int getParentVertexNo()
	{
		return parentVertexNo;
	}

	public void setParentVertexNo(int parentVertexNo)
	{
		this.parentVertexNo = parentVertexNo;
	}

	public int getColor()
	{
		return color;
	}

	public void setColor(int color)
	{
		this.color = color;
	}

	public int getDTime()
	{
		return dTime;
	}

	public void setDTime(int time)
	{
		dTime = time;
	}

	public int getFTime()
	{
		return fTime;
	}

	public void setFTime(int time)
	{
		fTime = time;
	}

	/**
	 * 
	 */
	public GraphNode(int capacity, int vertexNumber)
	{
		this.capacity = capacity;
		edges = new int[capacity];
		length = 0;
		this.vertexNo = vertexNumber;

	}

	public int getVertexNo()
	{
		return vertexNo;
	}

	public int[] getEdges()
	{
		return edges;
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

	public void addEdge(int toVertex)
	{
		if (length < capacity)
		{
			edges[length++] = toVertex;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("length = ").append(length).append("  capacity = ").append(capacity).append(" color = ").append(
				color).append("  dTime = ").append(dTime).append("  ftime = ").append(fTime).append("  parentIndex = ")
				.append(parentVertexNo).append("\n").append(" Edges = ").append(edges);
		return str.toString();

	}
}
