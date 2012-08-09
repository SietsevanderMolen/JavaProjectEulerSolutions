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

import java.util.ArrayList;
import java.util.List;
import projecteuler.abstracts.Problem;

/**
 * Manages problems
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class ProblemManager {

	private List<Problem> problems = new ArrayList<>();

	public void addProblem(Problem problem) {
		this.problems.add(problem);
	}

	/**
	 * Benchmark all problems known to this ProblemManager
	 *
	 * @param runs
	 */
	public void benchmarkAll(int runs) {
		for (Problem p : problems) {
			System.out.println("Problem #" + p.getProblemNumber() + ". " + p.getProblemDescription());
			System.out.println("Got " + p.solve() + " in " + p.benchmark(runs) / 1000000.0 + "ms on average");
		}
	}
}
