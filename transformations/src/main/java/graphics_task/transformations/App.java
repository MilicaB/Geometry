package graphics_task.transformations;

import utils.Point;
import utils.ProblemSolver;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Point A = new Point();
		Point B = new Point(1, 1, 2);
		Point C = new Point(0, 1, 0);
		Point D = new Point(1, 0, 1);
		new ProblemSolver(A, B, C, D).solve(1.57);
	}
}
