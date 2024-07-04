package org.maven;

import org.testng.Reporter;

public class ArraysDemo {

	public void singleDimArray() {
		int arr[] = new int[6];

		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 60;

		for (int i = 0; i < arr.length; i++) {
			Reporter.log("Single Dimention Array values: " + arr[i], true);
		}

	}

	public void multiDimArray() {
		int[][] arr = new int[3][2];
		
		arr[0][0]=11;
		arr[0][1]=21;
		arr[1][0]=31;
		arr[1][1]=41;
		arr[2][0]=51;
		arr[2][1]=61;
		
		for (int i = 0; i < arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
			Reporter.log("Multi Dimention Array values: " + arr[i][j], true);
			}
		}
	}
	
	public static void main(String args[]) {
		ArraysDemo arraysDemo= new ArraysDemo();
		arraysDemo.singleDimArray();
		arraysDemo.multiDimArray();
	}
}
