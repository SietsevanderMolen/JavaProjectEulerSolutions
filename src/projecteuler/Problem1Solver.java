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

import projecteuler.util.Stopwatch;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem1Solver extends AbstractProblem {

	/**
	 * The dumb way to solve a problem like this
	 *
	 * @return The sum of all multiples of 3 or 5 below 1000
	 */
	@Override
	public long _solve() {
		int tmp = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				tmp += i;
			}
		}
		return tmp;
	}

	@Override
	void setDescription() {
		this.description = "Find the sum of all the multiples of 3 or 5 below 1000.";
	}
}
