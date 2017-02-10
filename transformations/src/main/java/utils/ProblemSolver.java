package utils;

public class ProblemSolver {
	private Point A;
	private Point B;
	private Point C;
	
	public ProblemSolver(Point A, Point B, Point C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}

	public void solve(double theta) {
		GeometricVector vectorAB = new GeometricVector(A, B);
		

		Line line = new Line(A, vectorAB);
		Plot plot = new Plot();
		plot.findPlotCoordinatesByPerpendicularVectorAndPoint(vectorAB, C);

		Point newO = plot.findIntersectionPoint(line);
		GeometricVector e3 = vectorAB.getNormalVector();

		GeometricVector e2 = new GeometricVector(newO, C);
		
		GeometricVector e1 = e2.getVectorProduct(e3);
		Transform t= new Transform(e1, e2, e3, 'z', theta, newO);
		t.printAnalitical();

	}
}
