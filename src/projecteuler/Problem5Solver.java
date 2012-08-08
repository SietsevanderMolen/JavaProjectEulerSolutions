/*
 * Copyright (C) 2012 Sietse van der Molen <sietse@vdmolen.eu>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package projecteuler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder. What is the smallest positive number that is
 * evenly divisible by all of the numbers from 1 to 20?
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem5Solver extends AbstractProblem {

	private long[] increment;
	private long[] sum;
	
	@Override
	void setDescription() {
		this.description = "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";
	}

	@Override
	long solve() {
		long[] input = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		return leastCommonMultiple(input);
	}
	
	/**
	 * Find the least common multiple of a list of floats
	 * @param input
	 * @return the least common multiple of the list of floats
	 */
	private long leastCommonMultiple(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = leastCommonMultiple(result, input[i]);
		}
		return result;
	}
	
	/**
	 * Find the least common multiple of two floats by using the gcd of both
	 * @param a
	 * @param b
	 * @return the least common multiple of the given floats
	 */
	private long leastCommonMultiple(long a, long b) {
		return a * (b / greatestCommonDivisor(a, b));
	}
	
	/**
	 * Find the greatest common divisor of two floats
	 * @param a
	 * @param b
	 * @return the greatest common divisor of the given floats
	 */
	private long greatestCommonDivisor(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
