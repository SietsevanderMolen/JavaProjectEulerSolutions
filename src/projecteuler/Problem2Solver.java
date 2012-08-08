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
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem2Solver extends AbstractProblem {

	@Override
	void setDescription() {
		this.description = "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.";
	}

	@Override
	long solve() {
		long tmp = 0;
		long fib = 0;
		int i = 1;

		while (fib < 4000000) {
			fib = fastFib(i);
			i++;
			if (fib % 2 == 0) {
				tmp += fib;
			}
		}
		return tmp;
	}

	/**
	 * Recursively calculate the nth Fibonacci number.
	 *
	 * @param n The term to compute
	 * @return the nth Fibonacci number
	 */
	static long recursiveFib(int k) {
		if (k <= 2) {
			return 1;
		} else {
			return recursiveFib(k - 1) + recursiveFib(k - 2);
		}
	}

	/**
	 * Use the math library to calculate the nth Fibonacci number
	 *
	 * @param n The term to compute
	 * @return the nth Fibonacci number
	 */
	public long fastFib(int n) {
		double termA = Math.pow((1 + Math.sqrt(5)) / 2, n);
		double termB = Math.pow((1 - Math.sqrt(5)) / 2, n);
		double factor = 1 / Math.sqrt(5);

		return Math.round(factor * (termA - termB));
	}
}
