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
import projecteuler.util.Triplet;

/**
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
 * a² + b² = c²
 * For example,3² + 4² = 9 + 16 = 25 = 5².
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem9Solver extends Problem {
	
	public Problem9Solver() {
		super(9, "There exists exactly one Pythagorean triplet for which a + b + c = 1000, find the product abc.", 31875000L);
	}

	@Override
	public long solve() {
		// Generate all triplets where legs n and m < 100
		for (int m = 2; m < 25; m++) {
			for (int n = 1; n < 25; n++) {
				if (m > n) {
					Triplet triplet = new Triplet();
					triplet.createPythagoreanTriplet(m, n);
					
					if (triplet.getSum() == 1000) {
						return triplet.getProduct();
					}
				}
			}
		}
		return 0;
	}
}
