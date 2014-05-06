package object_non_relative;

import object_relative.Matrix;
import object_relative.Vector;


public class VAct {
	public static long sMult(Vector a, Vector b){
		if (a.getB() != b.getB()) {
			System.out.println("Error: vector\'s lengths do not equal each other");
			return 0;
		}
		Matrix simpleMatrix = MAct.mult(a.t(), b);
		return simpleMatrix.data[0][0];
	}
	public static Vector vMult(Vector a, Vector b){
		
		if ((a.getB() == b.getB()) && (b.getB() == 3)) {
			Vector res = new Vector(3);
			res.data[0][0] = a.data[0][1]*b.data[0][2] - a.data[0][2]*b.data[0][1];
			res.data[0][1] = a.data[0][0]*b.data[0][2] - a.data[0][2]*b.data[0][0];
			res.data[0][2] = a.data[0][0]*b.data[0][1] - a.data[0][1]*b.data[0][0];
			return res;
		}
		else {
			System.out.println("Error: vector\'s number of dementions do not equal 3");
			return new Vector(0);
		}
	}
	
}
