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

import java.math.BigInteger;
import projecteuler.abstracts.Problem;
import projecteuler.util.PrimeBuffer;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem10Solver extends Problem {

	public Problem10Solver() {
		super(10, "Find the sum of all the primes below two million.", 0L);
	}
	
	@Override
	public long solve() {
		long counter = 0;
		
		PrimeBuffer primeBuffer = new PrimeBuffer(2000000);
		primeBuffer.sieveUsingEratosthenes();
		for(long i = 0; i < 2000000; i++) {
			if(primeBuffer.checkForPrimality(i)) {
				counter += i;
			}
		}
		return counter;
	}
}
