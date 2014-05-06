package executable;
import object_non_relative.MAct;
import object_non_relative.VAct;
import object_relative.*;

public class Main {

	public static void main(String[] args) {
		//creating 4 vectors
		Vector v1 = new Vector (1, 0 , 0);
		Vector v2 = new Vector (0, 1 , 0);
		Vector v3 = new Vector (5);
		Vector v4 = new Vector (5);
		
		v3.fill();
		v4.fill(2);
		
		Matrix G = new Matrix (2, 0, 0, 0, 2, 0, 0, 0, 2);
		Matrix A = new Matrix (3, 4);
		
		A.fill();
		
		VAct.vMult(v1, v2).print();
		System.out.println("length of v1 by G "+v1.length2(G));
		System.out.println("length of v2: "+v2.length2());
		
		System.out.println("Matrix A: ");
		A.print();
		System.out.println("Matrix A*G: ");
		MAct.mult(A, G).print();
		System.out.println("det(A): "+MAct.det(A)+" det(G): "+MAct.det(G));
	}

}
