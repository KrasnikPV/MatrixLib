package object_non_relative;

import object_relative.Matrix;
import object_relative.Vector;


public class VAct {
	public static long sMult(Vector a, Vector b){ //scalar
		if ((a == null) || (b == null)) {
			System.out.println("Error: linking to non-object");
			return 0;
		}
		if (a.getM() != b.getM()) {
			System.out.println("Error: vector\'s lengths do not equal each other");
			return 0;
		}
		Matrix simpleMatrix = MAct.mult(a.t(), b);
		return simpleMatrix.getData(0, 0);
	}
	public static Vector vMult(Vector a, Vector b){ // vector
		if ((a == null) || (b == null)) {
			Vector res = new Vector(0);
			System.out.println("Error: linking to non-object");
			return res;
		}		
		if ((a.getM() == b.getM()) && (b.getM() == 3)) {
			Vector res = new Vector(3);
			res.setData(0, 0, a.getData(0, 1)*b.getData(0, 2) - a.getData(0, 2)*b.getData(0, 1));
			res.setData(0, 1, a.getData(0, 0)*b.getData(0, 2) - a.getData(0, 2)*b.getData(0, 0));
			res.setData(0, 2, a.getData(0, 0)*b.getData(0, 1) - a.getData(0, 1)*b.getData(0, 0));
			return res;
		}
		else {
			System.out.println("Error: vector\'s number of dementions do not equal 3");
			return new Vector(0);
		}
	}
	
	public static long form(Vector a, Matrix G, Vector b) {	//sqr form
		if ((a == null) || (b == null) || (G ==null)) {
			System.out.println("Error: linking to non-object");
			return 0;
		}	
		if (a.getSize() != G.getN()) {
			System.out.println("Error: can\'t multiply the first vector on the matrix");
			return 0;
		}
		if (b.getSize() != G.getM()) {
			System.out.println("Error: can\'t multiply the matrix on the first vector");
			return 0;
		}
		return MAct.mult(MAct.mult(a.t(), G), b).getData(0, 0);
	}
	public static Vector sum(Vector a, Vector b){
		if ((a == null) || (b == null)) {
			Vector res = new Vector(0);
			System.out.println("Error: linking to non-object");
			return res;
		}
		if ((a.getN() != 1) || (b.getN() != 1)) {
			System.out.println("Error: the vectors you trying to sum up are not vectors at all");
		}
		if (a.getSize() != b.getSize()) {
			System.out.println("Error: the vectors you trying to sum up have different dementional size");
		}
		Vector res = new Vector (a.getSize());
		
		for (int j=0; j<a.getSize(); j++) {
			res.setData(j, a.getData(j)+b.getData(j));
		}
		
		return res;
	}
	
	public static long mMult(Vector v1, Vector v2, Vector v3){ //mixed
		return v1.getData(0)*v2.getData(1)*v3.getData(2) - v1.getData(0)*v3.getData(1)*v2.getData(2) +
				+ v2.getData(0)*v3.getData(1)*v1.getData(2) - v2.getData(0)*v2.getData(1)*v3.getData(2) +
				+ v3.getData(0)*v1.getData(1)*v2.getData(2) - v3.getData(0)*v2.getData(1)*v1.getData(2);
	}

	
}
