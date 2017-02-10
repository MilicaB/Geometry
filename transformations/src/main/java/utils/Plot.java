package utils;

public class Plot {
	private double A;
	private double B;
	private double C;
	private double D;

	public void findPlotCoordinatesByPerpendicularVectorAndPoint(GeometricVector vector, Point point) {
		Point normalVectorCoord = vector.getNormalVector().getCoordinates();
		A = normalVectorCoord.getX();
		B = normalVectorCoord.getY();
		C = normalVectorCoord.getZ();
		D = (A * point.getX() + B * point.getY() + C * point.getZ());
	}

	public Point findIntersectionPoint(Line l) {
		Point linePoint = l.getPoint();
		Point lineVectorCoordinates = l.getVector().getCoordinates();
		double lambda = -(D + A * linePoint.getX() + B * linePoint.getY() + C * linePoint.getZ())
				/ (A * lineVectorCoordinates.getX() + B * lineVectorCoordinates.getY()
						+ C * lineVectorCoordinates.getZ());
		return l.getPointFromLineByLambda(lambda);
	}
}
