package utils;

public class GeometricVector {
	private Point coordinates;

	public GeometricVector(Point coordinates) {
		this.coordinates = coordinates;
	}

	public GeometricVector(Point start, Point end) {
		this.coordinates = new Point(end.getX() - start.getX(), end.getY() - start.getY(), end.getZ() - start.getZ());
	}

	public GeometricVector() {
		this(new Point());
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public double dot(GeometricVector vector) {
		return coordinates.getX() * vector.coordinates.getX() + coordinates.getY() * vector.coordinates.getY()
				+ coordinates.getZ() * vector.coordinates.getZ();
	}

	public double length() {
		return Math.sqrt(dot(this));
	}

	public boolean isCollinear(GeometricVector vector) {
		return dot(vector) == 0;
	}

	public GeometricVector sum(GeometricVector vector) {
		Point point = new Point();
		point.setX(coordinates.getX() + vector.getCoordinates().getX());
		point.setY(coordinates.getY() + vector.getCoordinates().getY());
		point.setZ(coordinates.getZ() + vector.getCoordinates().getZ());
		return new GeometricVector(point);
	}

	public double[] convertToDoubleArray() {
		return new double[] { coordinates.getX(), coordinates.getY(), coordinates.getZ() };
	}

	public GeometricVector getNormalVector() {
		Point point = new Point();
		point.setX(coordinates.getX() / length());
		point.setY(coordinates.getY() / length());
		point.setZ(coordinates.getZ() / length());
		return new GeometricVector(point);
	}

	public GeometricVector getVectorProduct(GeometricVector vector) {
		Point point = new Point();
		point.setX(coordinates.getY() * vector.getCoordinates().getZ()
				- coordinates.getZ() * vector.getCoordinates().getY());
		point.setY(coordinates.getZ() * vector.getCoordinates().getX()
				- coordinates.getX() * vector.getCoordinates().getZ());
		point.setX(coordinates.getX() * vector.getCoordinates().getY()
				- coordinates.getY() * vector.getCoordinates().getX());
		return new GeometricVector(point);
	}
}
