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

import projecteuler.problems1_10.Problem10Solver;
import projecteuler.problems1_10.Problem1Solver;
import projecteuler.problems1_10.Problem2Solver;
import projecteuler.problems1_10.Problem3Solver;
import projecteuler.problems1_10.Problem4Solver;
import projecteuler.problems1_10.Problem5Solver;
import projecteuler.problems1_10.Problem6Solver;
import projecteuler.problems1_10.Problem7Solver;
import projecteuler.problems1_10.Problem8Solver;
import projecteuler.problems1_10.Problem9Solver;

/**
 * These are my solutions for Project Euler
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class ProjectEuler {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ProblemManager problemManager = new ProblemManager();
		problemManager.addProblem(new Problem1Solver());
		problemManager.addProblem(new Problem2Solver());
		problemManager.addProblem(new Problem3Solver());
		problemManager.addProblem(new Problem4Solver());
		problemManager.addProblem(new Problem5Solver());
		problemManager.addProblem(new Problem6Solver());
		problemManager.addProblem(new Problem7Solver());
		problemManager.addProblem(new Problem8Solver());
		problemManager.addProblem(new Problem9Solver());
		problemManager.addProblem(new Problem10Solver());

		problemManager.benchmarkAll(50);
	}
}
