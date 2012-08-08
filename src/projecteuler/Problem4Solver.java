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
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem4Solver extends AbstractProblem {

	@Override
	void setDescription() {
		this.description = "Find the largest palindrome made from the product of two 3-digit numbers.";
	}

	@Override
	long solve() {
		return largestPalindrome(3);
	}

	/**
	 * This finds the largest palindrome made from the product of all numbers with given digits
	 *
	 * @param digits the amount of digits to use
	 * @return the largest palindrome
	 */
	private long largestPalindrome(int digits) {
		// Find max possible number for the given digits
		long max = 0;
		for (int i = 0; i < digits; i++) {
			max += Math.pow(10, i) * 9;
		}

		// Find the largest palindrome
		// I use ¾ of the highest possible number here as the lower range because that seems reasonable
		// TODO: find a more optimal solution
		long largestPalindrome = 0L;
		for (long i = max; i > max * 0.75; i--) {
			for (long j = max; j > max * 0.75; j--) {
				if (isPalindrome(i * j)) {
					if (i * j > largestPalindrome) {
						largestPalindrome = i * j;
					}
				}
			}
		}
		return largestPalindrome;
	}

	/**
	 * Check if the given number is a palindrome
	 *
	 * @param number number to check for palindromity™
	 * @return true if the number is a palindrome, false otherwise
	 */
	private boolean isPalindrome(long number) {
		long temp, reversedNumber = 0;
		long originalNumber = number;

		// Reverse the number here
		while (number > 0) {
			temp = number % 10;
			number = number / 10;
			reversedNumber = reversedNumber * 10 + temp;
		}
		// Check against original
		if (reversedNumber == originalNumber) {
			return true;
		} else {
			return false;
		}
	}
}
