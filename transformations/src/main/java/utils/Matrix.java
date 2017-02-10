package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
	private List<GeometricVector> matrix;
	
	public Matrix(){
		matrix = new ArrayList<GeometricVector>();
	}
	public Matrix(GeometricVector... vectors){
		matrix = new ArrayList<GeometricVector>(Arrays.asList(vectors));
	}

	public List<GeometricVector> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<GeometricVector> matrix) {
		this.matrix = matrix;
	}
	
	public int getVectorsNumberInMatrix(){
		return matrix.size();
	}
	
	public void addVector(GeometricVector vector){
		matrix.add(vector);
	}
	
}
