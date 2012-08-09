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

import java.util.Arrays;

/**
 * This is a boolean array where all the primes are true. (Some people prefer to use a BitSet here, because a BitSet uses just 1 bit per boolean, whereas in
 * contrast a boolean[] uses a byte per boolean. It's superior speed of operation made me use an array of booleans though.)
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class PrimeBuffer {

	public boolean[] _buffer;

	public PrimeBuffer(int bufferSize) {
		this._buffer = new boolean[bufferSize];
	}

	/**
	 * Returns the nth prime from the buffer
	 * @param n
	 * @return 
	 */
	public long getNthPrime(int n) {
		int counter = 0;
		for (long i = 2; i < _buffer.length; ++i) {
			if (_buffer[(int)i]) {
				counter++;
				// Is this the 10001st prime?
				if (counter == n) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Checks if the given number is a prime number
	 *
	 * @param prime the number to test
	 * @return true if prime is a prime number
	 */
	public boolean checkForPrimality(long prime) {
		return this._buffer[(int)prime];
	}

	/**
	 * Simple implementation of Atkin's sieve
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

	/**
	 * Simple implementation of Eratosthenes' sieve
	 */
	public void sieveUsingEratosthenes() {
		Arrays.fill(_buffer, Boolean.TRUE);
		_buffer[0] = false;
		_buffer[1] = false;

		for (int i = 0; i * i < _buffer.length; i++) {
			if (this._buffer[i]) {
				for (int j = i * i; j < _buffer.length; j += i) {
					_buffer[j] = false;
				}
			}
		}
	}
}
