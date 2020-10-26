
import java.util.Scanner;

public class board {
	private Node root;
	private int dimension;

	// populating with random numbers
	public board(int size) {
		dimension = size;
		root = null;
		// set up whole grid
		root = new Node(dimension);

		Node marker = root;

		// creating the first row
		for (int x = 0; x < dimension - 1; x++) {
			Node temp = new Node(0);
			marker.setRight(temp);
			temp.setLeft(marker);
			marker = temp;
		}
		Node rowMarker = root;

		for (int y = 0; y < dimension - 1; y++) {
			Node temp = new Node(0);
			rowMarker.setDown(temp);
			temp.setUp(rowMarker);

			for (int x = 0; x < dimension - 1; x++) {
				marker = temp;
				temp = new Node(0);
				marker.setRight(temp);
				temp.setLeft(marker);
				temp.getLeft().getUp().getRight().setDown(temp);
				temp.setUp(temp.getLeft().getUp().getRight());
			}

			rowMarker = rowMarker.getDown();
		}
	}

	public void display() {
		Node rowMarker = root;

		while (rowMarker != null) {
			Node temp = rowMarker;
			while (temp != null) {
				System.out.print(temp.getData() + "\t");
				temp = temp.getRight();
			}
			System.out.println();
			rowMarker = rowMarker.getDown();
		}

	}

	int nummm = 1;
	int max = 64;
	int solution = 1;

	public void knightsTour(Node temp) {
		Node location = temp;

		if (nummm == max) {
			System.out.println("Solution: " + solution);
			solution++;
			display();
		}

		// PATH 1 (up, up, right)
		if (location.getUp() != null && location.getUp().getUp() != null && location.getUp().getUp().getRight() != null
				&& location.getUp().getUp().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getUp().getRight());
			location.getUp().getUp().getRight().setData(0);
			nummm--;
		}

		// PATH 2 (up, up, left)
		if (location.getUp() != null && location.getUp().getUp() != null && location.getUp().getUp().getLeft() != null
				&& location.getUp().getUp().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getUp().getLeft());
			location.getUp().getUp().getLeft().setData(0);
			nummm--;
		}

		// PATH 3 (up,right,right)
		if (location.getUp() != null && location.getUp().getRight() != null
				&& location.getUp().getRight().getRight() != null
				&& location.getUp().getRight().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getRight().getRight());
			location.getUp().getRight().getRight().setData(0);
			nummm--;
		}

		// PATH 4 (up,left,left)
		if (location.getUp() != null && location.getUp().getLeft() != null
				&& location.getUp().getLeft().getLeft() != null
				&& location.getUp().getLeft().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getLeft().getLeft());
			location.getUp().getLeft().getLeft().setData(0);
			nummm--;
		}

		// PATH 5 (down,right,right)
		if (location.getDown() != null && location.getDown().getRight() != null
				&& location.getDown().getRight().getRight() != null
				&& location.getDown().getRight().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getRight().getRight());
			location.getDown().getRight().getRight().setData(0);
			nummm--;
		}

		// PATH 6 (down,left,left)
		if (location.getDown() != null && location.getDown().getLeft() != null
				&& location.getDown().getLeft().getLeft() != null
				&& location.getDown().getLeft().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getLeft().getLeft());
			location.getDown().getLeft().getLeft().setData(0);
			nummm--;
		}  

		// PATH 7 (down,down,right)
		if (location.getDown() != null && location.getDown().getDown() != null
				&& location.getDown().getDown().getRight() != null
				&& location.getDown().getDown().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getDown().getRight());
			location.getDown().getDown().getRight().setData(0);
			nummm--;
		}

		// PATH 8 (down,down, left)
		if (location.getDown() != null && location.getDown().getDown() != null
				&& location.getDown().getDown().getLeft() != null
				&& location.getDown().getDown().getLeft().getData() == 0) {

			location.setData(nummm++);

			knightsTour(location.getDown().getDown().getLeft());
			location.getDown().getDown().getLeft().setData(0);
			nummm--;
		}
	}

	public void knightsTour() {
		Node location = root;

		// PATH 1 (up, up, right)
		if (location.getUp() != null && location.getUp().getUp() != null && location.getUp().getUp().getRight() != null
				&& location.getUp().getUp().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getUp().getRight());
			/*location.getUp().getUp().getRight().setData(0);
			nummm--;*/
		}

		// PATH 2 (up, up, left)
		if (location.getUp() != null && location.getUp().getUp() != null && location.getUp().getUp().getLeft() != null
				&& location.getUp().getUp().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getUp().getLeft());
			/*location.getUp().getUp().getLeft().setData(0);
			nummm--;*/
		}

		// PATH 3 (up,right,right)
		if (location.getUp() != null && location.getUp().getRight() != null
				&& location.getUp().getRight().getRight() != null
				&& location.getUp().getRight().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getRight().getRight());
			/*location.getUp().getRight().getRight().setData(0);
			nummm--;*/
		}

		// PATH 4 (up,left,left)
		if (location.getUp() != null && location.getUp().getLeft() != null
				&& location.getUp().getLeft().getLeft() != null
				&& location.getUp().getLeft().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getUp().getLeft().getLeft());
			/*location.getUp().getLeft().getLeft().setData(0);
			nummm--;*/
		}

		// PATH 5 (down,right,right)
		if (location.getDown() != null && location.getDown().getRight() != null
				&& location.getDown().getRight().getRight() != null
				&& location.getDown().getRight().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getRight().getRight());
			/*location.getDown().getRight().getRight().setData(0);
			nummm--;*/
		}

		// PATH 6 (down,left,left)
		if (location.getDown() != null && location.getDown().getLeft() != null
				&& location.getDown().getLeft().getLeft() != null
				&& location.getDown().getLeft().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getLeft().getLeft());
			/*location.getDown().getLeft().getLeft().setData(0);
			nummm--;*/
		}

		// PATH 7 (down,down,right)
		if (location.getDown() != null && location.getDown().getDown() != null
				&& location.getDown().getDown().getRight() != null
				&& location.getDown().getDown().getRight().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getDown().getRight());
			/*location.getDown().getDown().getRight().setData(0);
			nummm--;*/
		}

		// PATH 8 (down,down, left)
		if (location.getDown() != null && location.getDown().getDown() != null
				&& location.getDown().getDown().getLeft() != null
				&& location.getDown().getDown().getLeft().getData() == 0) {
			location.setData(nummm++);

			knightsTour(location.getDown().getDown().getLeft());
			/*location.getDown().getDown().getLeft().setData(0);
			nummm--;*/

		}
	}
}
