/**
 * 
 */
package algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erotkur
 * 
 */
public class DirectedGraph {

	private int noVertex;

	private int noEdges;

	private GraphNode[] vertex;

	private int counter = 0;

	private ArrayList<Integer[]> alternateVertexOfCycles = new ArrayList<Integer[]>();

	/**
	 * 
	 */
	public DirectedGraph(int noOfvertex) {
		this.noVertex = noOfvertex;
		vertex = new GraphNode[noOfvertex];
		for (int i = 0; i < noVertex; i++) {
			vertex[i] = new GraphNode(noOfvertex, i);
		}
		noEdges = 0;
	}

	public void addEdge(int fromVertex, int toVertex) {
		vertex[fromVertex].addEdge(toVertex);
		noEdges++;
	}

	// returns list of connnected components
	public List<List<Integer>> dfs() {

		List<List<Integer>> dfsForest = new ArrayList<List<Integer>>();
		for (int i = 0; i < noVertex; i++) {
			if (vertex[i].getColor() == 0) {
				List newDfsTree = new ArrayList<Integer>(noVertex);
				vertex[i].setParentVertexNo(i);
				dfs(i, newDfsTree);
				dfsForest.add(newDfsTree);
			}

		}
		discolor();
		// reinitialize counter
		counter = 0;

		return dfsForest;

	}

	// discolor all graph edges
	private void discolor() {
		for (GraphNode vertices : vertex) {
			vertices.setColor(0);
		}
	}

	// stores all nodes accessible from node i in nodesVisited
	private void dfs(int u, List<Integer> nodesVisited) {
		// set node has been discovered
		vertex[u].setColor(1);
		vertex[u].setDTime(counter++);
		nodesVisited.add(u);
		for (int v : vertex[u].getEdges()) {
			if (vertex[v].getColor() == 0) {
				// set parent as u
				vertex[v].setParentVertexNo(u);
				dfs(v, nodesVisited);
			} else if (vertex[v].getColor() == 1) {
				// its a back edge.. cycle exists add it to list of cycles
				Integer[] backedge = { v, u };
				alternateVertexOfCycles.add(backedge);

			}
		}
		vertex[u].setColor(2);
		vertex[u].setFTime(counter++);

	}
	
	
	public List<List<Integer>> getAllCycles(){
		List<List<Integer>> cycleList=new ArrayList<List<Integer>>();
		for(Integer[] backedge:alternateVertexOfCycles){
			// for every backedge 
			
		}
		return null;
	}

	// public List<Integer> bfs(int vertexNo)
	// {
	//
	// List<Integer> bfsTree=
	//
	// }

	@Override
	public String toString() {

		StringBuilder strResult = new StringBuilder();
		for (GraphNode vertices : vertex) {
			strResult.append(vertices.getVertexNo()).append("  :  ")
					.append(vertices.getEdges());
		}
		return strResult.toString();
	}

	public void printVertexDetails() {
		for (GraphNode vertices : vertex) {
			System.out.println(vertices.getVertexNo() + " : " + vertices);
		}
	}

}
