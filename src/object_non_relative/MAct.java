package object_non_relative;

import object_relative.Matrix;

public final class MAct {
	public static Matrix mult(Matrix A, Matrix B) {
		if ((A == null) || (B == null)) {
			Matrix result = new Matrix(0, 0);
			System.out.println("Error: linking to non-object");
			return result;
		}
		if ((A.getN() == 0) || (A.getM() == 0) || (B.getN() == 0) || (B.getM() == 0)){
			System.out.println("Error: product can not be calculated 'cause of the previous error");
			Matrix result = new Matrix(0, 0);
			return result;
		}
		if (A.getN() != B.getM()) {
			Matrix result = new Matrix(0, 0);
			System.out.println("Error: can\'t multiply these matrixes");
			return result;
		}
		Matrix result = new Matrix(A.getM(), B.getN());
		
		for (int i=0; i<A.getM(); i++) {
			for (int j=0; j<B.getN(); j++){
				for (int k=0; k<A.getN(); k++){
					result.addData(i, j, A.getData(k, i)*B.getData(j, k));
				}
					
				
			}
		}
		
		return result.t();
	}
	
	public static Matrix sum(Matrix A, Matrix B){
		if ((A == null) || (B == null)) {
			Matrix result = new Matrix(0, 0);
			System.out.println("Error: linking to non-object");
			return result;
		}
		if ((A.getN() != B.getN()) || (A.getM() != B.getM())) {
			System.out.println("Error: can\'t add these matrixes");
			Matrix result = new Matrix(0, 0);
			return result;
		}
		if (A.getN() == 0){
			System.out.println("Error: mtr sum can not be calculated 'cause of the previous error");
			Matrix result = new Matrix(0, 0);
			return result;
		}
		Matrix result = new Matrix(A.getN(), B.getM());
		
		for (int i=0; i<A.getN(); i++) 
			for (int j=0; j<A.getM(); j++){
				result.setData(i, j, A.getData(i ,j) + B.getData(i, j));
			}
		return result;
	}
	
	public static long det(Matrix A) {
		long det = 0;
		if ((A == null)) {
			System.out.println("Error: linking to non-object");
			return det;
		}
		int a = A.getN();
		if (a != A.getM()) {
			System.out.println("Error: determinant can be calculated only if the mtr is squared");
			return det;
		}
		if (a == 0){
			System.out.println("Error: determinant can not be calculated 'cause of the previous error");
			return det;
		}
		if (a == 1){
			det = A.getData(0,0);
			return det;
		}
		if (a == 2){
			det = A.getData(0,0)*A.getData(1,1) - A.getData(0,1)*A.getData(1,0);
			return det;
		}
		
		for (int i=0; i<a; i++) {
			if (i%2 == 0){
				det -= A.getData(i, 1)*MAct.det(A.minor(i, 1));
			}
			else{
				det += A.getData(i , 1)*MAct.det(A.minor(i, 1));
			}
		}
		
		return det;
	}
}
