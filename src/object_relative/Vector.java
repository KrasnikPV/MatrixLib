package object_relative;

import object_non_relative.MAct;
import object_non_relative.VAct;

public class Vector extends Matrix {
	public Vector(int b) {
		//builds empty vector of size b
		super(1, b);
	}
	
	public Vector (long a1, long a2, long a3){
		//builds custom 3d vector 
		super(1, 3);
		this.data[0][0] = a1;
		this.data[0][1] = a2;
		this.data[0][2] = a3;
	}
	
	public double length(){
		return Math.sqrt(VAct.sMult(this, this));
	}
	
	public long length2(Matrix G) {		
		return MAct.mult(MAct.mult(this.t(), G), this).data[0][0];
	}
	
	public long length2() {		
		return VAct.sMult(this, this);
	}
}
