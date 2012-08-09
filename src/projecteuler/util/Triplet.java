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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class describing a triplet of longs
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Triplet {

	private long a = 0L, b = 0L, c = 0L;

	public Triplet() {
	}

	public Triplet(long a, long b, long c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public long getProduct() {
		return a * b * c;
	}

	public long getSum() {
		return a + b + c;
	}

	/**
	 * This constructor generates a Pythagorean triplet using Euclid's method:<br>
	 * a = m² - n²<br>
	 * b = 2mn<br>
	 * c = m² + n²<br>
	 *
	 * @param m
	 * @param n
	 */
	public void createPythagoreanTriplet(long m, long n) {
		if (m > n) {
			this.a = (m * m) - (n * n);
			this.b = (2 * m) * n;
			this.c = (m * m) + (n * n);
		} else {
			try {
				throw new Exception("m should > n");
			} catch (Exception ex) {
				Logger.getLogger(Triplet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
