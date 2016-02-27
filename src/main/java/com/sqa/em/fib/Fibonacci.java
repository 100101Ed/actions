/**
 * File Name: Fibonacci.java<br>
 * Mora, Eduardo<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 25, 2016
 */
package com.sqa.em.fib;

/**
 * Fibonacci //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mora, Eduardo
 * @version 1.0.0
 * @since 1.0
 */
// public class Fibonacci {
/**
 * @param args
 */
public class Fibonacci {

	static int nthPosition = 3;

	static int count = 0;

	static int temp = 0;

	public static long fib(int n) {
		temp += n;
		count++;
		System.out.println(count + "nth = " + n);
		if (count >= nthPosition) {
			return n;
		} else {
			return fib(n) + fib(temp);
		}
	}

	public static void main(String[] args) {
		fib(3);
	}
}