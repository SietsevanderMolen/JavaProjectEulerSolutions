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
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143?
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem3Solver extends AbstractProblem {

	@Override
	void setDescription() {
		this.description = "What is the largest prime factor of the number 600851475143?";
	}

	@Override
	long solve() {
		return largestPrimeFactor(600851475143L);
	}

	/**
	 * Calculate the largest prime of a given number
	 *
	 * @param number the number to calculate the largest prime of
	 * @return the largest prime of the given number
	 */
	public int largestPrimeFactor(long number) {
		int i;
		for (i = 2; i <= number; i++) {
			if (number % i == 0) {
				number /= i;
				i--;
			}
		}
		return i;
	}
}
