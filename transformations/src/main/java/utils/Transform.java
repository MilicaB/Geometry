package utils;

import java.text.DecimalFormat;

import Jama.Matrix;

public class Transform {
	private GeometricVector e1;
	private GeometricVector e2;
	private GeometricVector e3;
	private Matrix T;
	private double theta;
	private Matrix A;
	private GeometricVector O_O;

	public Transform(GeometricVector e1, GeometricVector e2, GeometricVector e3, char rotatingAxis, double theta, Point newCoordinateCenter) {
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.theta = theta;
		createAMatrix(rotatingAxis);
		T = new Matrix(
				new double[][] { e1.convertToDoubleArray(), e2.convertToDoubleArray(), e3.convertToDoubleArray() })
						.transpose();
		O_O = new GeometricVector(new Point(0, 0, 0), newCoordinateCenter);
	}

	public Matrix findAMatrix() {
		return T.times(A).times(T.inverse());
	}

	public Matrix findBVector() {
		Matrix matrixO = new Matrix(new double[][] { O_O.convertToDoubleArray() }).transpose();
		return A.times(-1).times(matrixO).plus(matrixO);
	}

	public void printAnalitical() {
		Matrix AMatrix = findAMatrix();
		Matrix bVector = findBVector();
		DecimalFormat two = new DecimalFormat("#0.00");

		System.out.print("     | ");
		for(int i=0;i<3;i++){
			System.out.print(two.format(AMatrix.get(0, i)) + " ");
		}
		System.out.println("|      | "+ two.format(bVector.get(0, 0))+" |");
		
		System.out.print(" X = | ");
		for(int i=0;i<3;i++){
			System.out.print(two.format(AMatrix.get(1, i)) + " ");
		}
		System.out.println("| X`+ | "+ two.format(bVector.get(1, 0))+" |");
		
		System.out.print("     | ");
		for(int i=0;i<3;i++){
			System.out.print(two.format(AMatrix.get(2, i)) + " ");
		}
		System.out.print("|     | "+ two.format(bVector.get(2, 0))+" |");

	}

	private void createAMatrix(char rotatingAxis) {
		double matrixArr[][] = null;
		switch (rotatingAxis) {
		case 'x':
			matrixArr = new double[][] { { 0, Math.cos(theta), -Math.sin(theta) },
					{ 0, Math.sin(theta), Math.cos(theta) }, { 1, 0, 0 } };
			break;
		case 'y':
			matrixArr = new double[][] { { Math.cos(theta), 0, -Math.sin(theta) },
					{ Math.sin(theta), 0, Math.cos(theta) }, { 0, 1, 0 } };
		case 'z':
			matrixArr = new double[][] { { Math.cos(theta), -Math.sin(theta), 0 },
					{ Math.sin(theta), Math.cos(theta), 0 }, { 0, 0, 1 } };
		}
		A = new Matrix(matrixArr);
	}

}
