package main.other;


public class NDimensionalArray {
	private NDimensionalArray[] nested;

	public NDimensionalArray[] getPlanes() {
		return nested;
	}
	

	public NDimensionalArray getAt(int i) {
		return nested[i];
	}
	
	public NDimensionalArray(int[] dimlens) {
		NDimensionalArray nda = new NDimensionalArray();
		for(int dim:dimlens) {
			NDimensionalArray[] pns = new NDimensionalArray[dim];
			for(NDimensionalArray a:pns) {
				a = new NDimensionalArray(nda);
			}
			// pns recreated every iteration: array of ndimensionalarrays
			nda = new NDimensionalArray(pns);
		}
		
	}
	
	// only use the constructor below for cloning
	public NDimensionalArray(NDimensionalArray[] planes) {

		this.nested = planes;
	}

	public NDimensionalArray() {
		
	}
	
	public NDimensionalArray(NDimensionalArray n) {
		
	}
	
}
