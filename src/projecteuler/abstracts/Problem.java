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
package projecteuler.abstracts;

import projecteuler.interfaces.IBenchmarkable;
import projecteuler.interfaces.ISolvable;
import projecteuler.util.Stopwatch;

/**
 * An abstract description of a Project Euler problem. This should make the actual problem classes a bit cleaner.
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public abstract class Problem implements ISolvable, IBenchmarkable {

	private Stopwatch stopwatch = new Stopwatch();
	protected String description;
	protected Long expectedAnswer;
	protected int problemNumber = -1;

	/**
	 * Initializes this problem with a description and an expected answer
	 *
	 * @param description The description for this problem in one line
	 * @param expectedAnswer The answer that is expected
	 */
	protected Problem(int problemNumber, String description, long expectedAnswer) {
		this.problemNumber = problemNumber;
		this.description = description;
		this.expectedAnswer = expectedAnswer;

	}

	/**
	 * Return the number of this problem
	 *
	 * @return
	 */
	public int getProblemNumber() {
		return this.problemNumber;
	}

	/**
	 * Return the description of this problem
	 *
	 * @return
	 */
	public String getProblemDescription() {
		return this.description;
	}

	/**
	 * Return the expected answer of this problem
	 *
	 * @return
	 */
	public long getExpectedAnswer() {
		return this.expectedAnswer;
	}

	/**
	 * The actual problem solving happens in here
	 *
	 * @return The answer to this problem as a long
	 */
	@Override
	public abstract long solve();

	@Override
	public long benchmark(int runs) {
		long avgTime = 0;
		// Do specified number of runs
		for (int i = 0; i < runs; i++) {
			stopwatch.start();
			solve();
			stopwatch.stop();
			avgTime += stopwatch.getElapsedTime();
			stopwatch.reset();
		}
		return avgTime / runs;
	}
}
