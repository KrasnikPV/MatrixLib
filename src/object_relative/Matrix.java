package object_relative;

import java.util.Random;

public class Matrix {
	public long[][] data;
	private int a;
	private int b;
	
	public Matrix(int a, int b){
		//builds empty axb matrix 
		this.a = a;
		this.b = b;
		data = new long[a][b];
	}
	
	public Matrix(long a11, long a12, long a13,
				  long a21, long a22, long a23,
				  long a31, long a32, long a33){
		//builds custom 3x3 matrix
		this.a = this.b = 3;
		data = new long[3][3];
		data[0][0] = a11;		data[1][0] = a12;		data[2][0] = a13;
		data[0][1] = a21;		data[1][1] = a22;		data[2][1] = a23;
		data[0][2] = a31;		data[1][2] = a32;		data[2][2] = a33;
	}
	
	public Matrix minor(int xx, int xy) {		
		//returns minor 
		Matrix result = new Matrix(this.getA() - 1, this.getB() - 1);
		
		int jumpx = 0;
		int jumpy = 0;
				
		for (int i=0; i<a-1; i++){
			if (i == xx) {
				jumpx++;
			}
			for (int j=0; j<b-1; j++){
				if (j == xy) {
					jumpy++;
				}
				result.data[i][j] = this.data[i+jumpx][j+jumpy];	
			}
			jumpy = 0;
		}
		
		return result;
	}
	
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}

	public void print() {
		if (a == 0) {
			System.out.println("Matrix is empty");
		}
		for(int j=0; j<b; j++) {
			for(int i=0; i<a; i++)
				System.out.print(data[i][j]+" ");
			System.out.println();
		}
	}
	
	public void fill(int r) {
		//fills with random ints of order r
		Random x = new Random();
		for(int j=0; j<b; j++)
			for(int i=0; i<a; i++)
				data[i][j] = Math.round(Math.pow(10, r-1)) + x.nextInt((int) Math.round(Math.pow(10, r)-Math.pow(10, r-1)));
	}
	
	public void fill() {
		//fills with random ints of order 1
		Random x = new Random();
		for(int j=0; j<b; j++)
			for(int i=0; i<a; i++)
				data[i][j] = x.nextInt(10);
	}
	
	public Matrix t() {
		Matrix result = new Matrix(b,a);
		
		for(int j=0; j<b; j++)
			for(int i=0; i<a; i++)
				result.data[j][i] = data[i][j];
		
		return result;
	}
}
