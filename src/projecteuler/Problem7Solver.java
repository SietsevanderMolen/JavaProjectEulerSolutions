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

import projecteuler.util.PrimeBuffer;

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
		PrimeBuffer primeBuffer = new PrimeBuffer(150000);
		primeBuffer.sieveUsingAtkins();

		long counter = 0;
		for (long i = 2; i < buffer.length; ++i) {
			if (primeBuffer.getAt((int)i)) {
				counter++;
				if (counter == 10001) {
					return i;
				}
			}
		}
		return 0;
	}
}
