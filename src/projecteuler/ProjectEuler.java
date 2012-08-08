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
 * These are my solutions for Project Euler
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class ProjectEuler {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println(new Problem1Solver().toString());
		System.out.println(new Problem2Solver().toString());
		System.out.println(new Problem3Solver().toString());
		System.out.println(new Problem4Solver().toString());
		System.out.println(new Problem5Solver().toString());
		System.out.println(new Problem6Solver().toString());
		System.out.println(new Problem7Solver().toString());
		System.out.println(new Problem8Solver().toString());
	}
}
