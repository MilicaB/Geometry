package utils;

public class Line {
	private Point point;
	private GeometricVector vector;

	public GeometricVector getVector() {
		return vector;
	}

	public void setVector(GeometricVector vector) {
		this.vector = vector;
	}

	public Line() {
		point = new Point();
		vector = new GeometricVector();
	}

	public Line(Point point, GeometricVector vector) {
		this.point = point;
		this.vector = vector;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPointFromLineByLambda(double lambda) {
		double x = vector.getCoordinates().getX() * lambda + point.getX();
		double y = vector.getCoordinates().getY() * lambda + point.getY();
		double z = vector.getCoordinates().getZ() * lambda + point.getX();
		return new Point(x, y, z);
	}
}
