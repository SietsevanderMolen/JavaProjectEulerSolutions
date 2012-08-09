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

/**
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 *
 * @author Sietse van der Molen <sietse@vdmolen.eu>
 */
public class Problem8Solver extends Problem {
	
	public Problem8Solver() {
		super(8, "Find the greatest product of five consecutive digits in the 1000-digit number", 40824L);
	}

	@Override
	public long solve() {
		return findLargestConsecutive5("73167176531330624919225119674426574742355349194934969835203127745063262395783180169848018694788518438586156078911294949545950173795833195285328805511125406987471585238630507156932909632952274430435576689664895044524452316173185640309871112172238311362229893423380308135336276614282806444486645238749303589072962904915044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572255397536978179778461740649551492908625693219784686224828397224137565705605749026140797296865241453510047482166370484403199890008895243450658541227588666881164271714799244429283086346567481391912316282458617866458359124566529476545682848912883142607690042242190226710556263211111093705442175069416589604080719840385096245544436298123098787992724428490188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
	}

	/**
	 * This iterates over the string and tries all possible combinations of 5 digits
	 *
	 * @param number
	 * @return the consecutive five numbers found in the input string with the highest product
	 */
	private long findLargestConsecutive5(String number) {
		long biggest = 0;
		for (int i = 0; i < number.length() - 5; i++) {
			int n = Integer.parseInt(number.substring(i, i + 1))
				* Integer.parseInt(number.substring(i + 1, i + 2))
				* Integer.parseInt(number.substring(i + 2, i + 3))
				* Integer.parseInt(number.substring(i + 3, i + 4))
				* Integer.parseInt(number.substring(i + 4, i + 5));

			biggest = Math.max(n, biggest);
		}
		return biggest;
	}
}
