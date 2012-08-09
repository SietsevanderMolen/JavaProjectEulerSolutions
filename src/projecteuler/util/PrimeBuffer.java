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
package projecteuler.util;

/**
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class PrimeBuffer {
	private boolean[] _buffer;

	public PrimeBuffer(int bufferSize) {
		this._buffer = new boolean[bufferSize];
	}

	/**
	 * Checks if the given number is a prime number
	 *
	 * @param prime the number to test
	 * @return true if prime is a prime number
	 */
	public boolean checkForPrimality(int prime) {
		return this._buffer[prime];
	}

	/**
	 * Simple implementation of Atkin's sieve
	 *
	 * @param buffer a boolean array containing
	 */
	public void sieveUsingAtkins() {
		int end = _buffer.length;
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
					_buffer[n] = !_buffer[n];
				}

				n = x2_3 + y2; /* 3x^2 + y^2 */
				if ((n < end) && (n % 12 == 7)) {
					_buffer[n] = !_buffer[n];
				}

				n = x2_3 - y2; /* 3x^2 - y^2 */
				if ((x > y) && (n < end) && (n % 12 == 11)) {
					_buffer[n] = !_buffer[n];
				}
			}
		}

		// Eliminate composites by actually sieving
		for (n = 5; n <= limit; n += 2) {
			if (_buffer[n]) {
				k = n * n;
				for (i = 1, m = k; m < end; i += 2, m = i * k) {
					_buffer[m] = false;
				}
			}
		}

		_buffer[3] = true;
		_buffer[2] = true;
	}	
}
