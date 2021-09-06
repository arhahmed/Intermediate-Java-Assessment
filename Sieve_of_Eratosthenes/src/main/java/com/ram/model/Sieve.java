package com.ram.model;

public class Sieve {

	private int limit;
	private String primes;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		this.calculatePrimes(limit);
	}

	public String getPrimes() {
		return this.primes;
	}

	public void setPrimes(String primes) {
		this.primes = primes;
	}

	public void calculatePrimes(int limit) {
		// Create boolean array to keep track of which numbers are primes or not
		boolean arr[];
		arr = new boolean[limit];
		
		// Set all numbers to be true to be eliminated 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = true;
		}
		
		// Go through the array starting from first prime and implement sieve
		// Start from 2, make sure that all numbers less than limit are checked
		for (int i = 2; Math.pow(i, 2) < limit; i++) {
			// If this number was eliminated before
			if (arr[i] == true) {
				// Check to see if this is a prime or not
				// Go by the multiple you're on
				for(double j = Math.pow(i, 2); j < limit; j+=i) { // !! Make sure to set to i² and not i !!
					arr[(int) j] = false; // eliminate
				}
				
			}
		}
		
		// Clear out any previous primes
		setPrimes("");
		
		// Go through our list of primes
		for(int i = 2; i < limit; i++) {
			
			// If it is a prime
			if(arr[i]) {
				System.out.println(i + " is a prime number");
				setPrimes(getPrimes() + Integer.toString(i) + ", "); // Add it to our primes list
			}
		}
		
		// Remove extra ", " at the end of our string to clean output
		String temp = getPrimes();
		String truePrimes = "";
		for(int i = 0; i < temp.length() - 2; i++) {
			truePrimes += temp.charAt(i);
		}
		setPrimes(truePrimes);
	}

	@Override
	public String toString() {
		return "User {limit=" + limit + ", primes= [" + primes + "]}";
	}

}
