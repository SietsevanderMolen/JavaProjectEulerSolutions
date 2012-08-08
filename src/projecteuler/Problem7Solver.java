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
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem7Solver extends AbstractProblem {

	@Override
	void setDescription() {
		this.description = "What is the 10 001st prime number?";
	}

	@Override
	long solve() {
		boolean[] buffer = new boolean[150000];
		atkinsSieve(buffer);

		long counter = 0;
		for (long i = 2; i < buffer.length; ++i) {
			if (buffer[(int) i]) {
				counter++;
				if (counter == 10001) {
					return i;
				}
			}
		}
		return 0;
	}

	/**
	 * Simple implementation of Atkin's sieve
	 *
	 * @param buffer a boolean array containing
	 */
	private void atkinsSieve(boolean[] buffer) {
		int end = buffer.length;
		double limit = Math.sqrt(end);

		int n, x, x2, x2_3, y, y2;
		int k, i, m;

		// put in candidate primes:
		// integers which have an odd number of
		// representations by certain quadratic forms
		for (x = 1; x <= limit; ++x) {
			x2 = x * x;
			x2_3 = 3 * x2;

			for (y = 1; y <= limit; ++y) {
				y2 = y * y;
				n = 4 * x2 + y2;
				if ((n < end) && (n % 12 == 1 || n % 12 == 5)) {
					buffer[n] = !buffer[n];
				}

				n = x2_3 + y2; /* 3x^2 + y^2 */
				if ((n < end) && (n % 12 == 7)) {
					buffer[n] = !buffer[n];
				}

				n = x2_3 - y2; /* 3x^2 - y^2 */
				if ((x > y) && (n < end) && (n % 12 == 11)) {
					buffer[n] = !buffer[n];
				}
			}
		}

		// Eliminate composites by actually sieving
		for (n = 5; n <= limit; n += 2) {
			if (buffer[n]) {
				k = n * n;
				for (i = 1, m = k; m < end; i += 2, m = i * k) {
					buffer[m] = false;
				}
			}
		}

		buffer[3] = true;
		buffer[2] = true;
	}
}
