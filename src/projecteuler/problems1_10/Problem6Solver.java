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
package projecteuler.problems1_10;

import projecteuler.abstracts.Problem;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 1² + 2² + ... + 10² = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)² = 55² = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem6Solver extends Problem {

		
	public Problem6Solver() {
		super(6, "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.", 25164150L);
	}

	@Override
	public long solve() {
		return Math.abs(squareOfSum(100) - sumOfSquares(100));
	}

	/**
	 * Find the sum of the squares of the given number using the rule
	 * (1 + 2 + ... + n)² = n² * (n+1)² * ¼
	 * 
	 * @param numbers
	 * @return the sum of the squares of the given number
	 */
	private long sumOfSquares(int numbers) {
		return (long)(Math.pow(numbers, 2) * (long)Math.pow((numbers+1),2) / 4);
	}

	/**
	 * Find the square of the sum of the given argument using the rule
	 * 1² + 2² + ... + n² = n * (n+1) * (2n+1) * 1/6
	 * 
	 * @param numbers
	 * @return the square of the sum of the given argument
	 */
	private long squareOfSum(int numbers) {
		return numbers * (numbers+1) * (2*numbers+1) / 6;
	}
}
