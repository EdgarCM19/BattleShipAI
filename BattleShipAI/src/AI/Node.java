package AI;

import java.util.ArrayList;

import obj.Board;

public class Node {

	public ArrayList<Node> nodes;
	public Board data;
	public float factor;
	int mov_x, mov_y;
	
	public Node(Board data, int depth, int mov_x, int mov_y) {
		nodes = new ArrayList<Node>();
		this.data = data;
		this.factor = Evaluation.evaluation(this.data);
		this.mov_x = mov_x;
		this.mov_y = mov_y;
	}
}
