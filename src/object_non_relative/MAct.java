package object_non_relative;

import object_relative.Matrix;

public final class MAct {
	public static Matrix mult(Matrix A, Matrix B) {
		if (A.getA() != B.getB()) {
			Matrix result = new Matrix(0, 0);
			System.out.println("Error: can\'t multiply these matrixes");
			return result;
		}
		Matrix result = new Matrix(A.getB(), B.getA());
		
		for (int i=0; i<A.getB(); i++) {
			for (int j=0; j<B.getA(); j++){
				for (int k=0; k<A.getA(); k++){
					result.data[i][j] += A.data[k][i]*B.data[j][k];
				}
					
				
			}
		}
		
		return result.t();
	}
	
	public static Matrix sum(Matrix A, Matrix B){
		if ((A.getA() != B.getA()) || (A.getB() != B.getB())) {
			System.out.println("Error: can\'t add these matrixes");
			Matrix result = new Matrix(0, 0);
			return result;
		}
		Matrix result = new Matrix(A.getA(), B.getB());
		
		for (int i=0; i<A.getA(); i++) 
			for (int j=0; j<A.getB(); j++){
				result.data[i][j] = A.data[i][j] + B.data[i][j];
			}
		return result;
	}
	
	public static long det(Matrix A) {
		long det = 0;
		if (A.getA() != A.getB()) {
			System.out.println("Error: determinant can be calculated only if the mtr is squared");
			return det;
		}
		
		if (A.getA() == 2){
			det = A.data[0][0]*A.data[1][1] - A.data[0][1]*A.data[1][0];
			return det;
		}
		
		for (int i=0; i<A.getA(); i++) {
			if (i%2 == 0){
				det -= A.data[i][1]*MAct.det(A.minor(i, 1));
			}
			else{
				det += A.data[i][1]*MAct.det(A.minor(i, 1));
			}
		}
		
		return det;
	}
}
