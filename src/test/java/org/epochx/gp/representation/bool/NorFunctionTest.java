/*
 * Copyright 2007-2010 Tom Castle & Lawrence Beadle
 * Licensed under GNU General Public License
 * 
 * This file is part of EpochX: genetic programming software for research
 * 
 * EpochX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * EpochX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with EpochX. If not, see <http://www.gnu.org/licenses/>.
 * 
 * The latest version is available from: http:/www.epochx.org
 */
package org.epochx.gp.representation.bool;

import org.epochx.epox.*;
import org.epochx.epox.bool.NorFunction;
import org.epochx.gp.representation.AbstractBooleanNodeTestCase;

/**
 * 
 */
public class NorFunctionTest extends AbstractBooleanNodeTestCase {

	@Override
	public Node getNode() {
		return new NorFunction();
	}

	public void testEvaluateTT() {
		final NorFunction node = (NorFunction) getNode();
		final Node[] children = new Node[]{new BooleanLiteral(true),
				new BooleanLiteral(true)};
		node.setChildren(children);
		final boolean result = node.evaluate();

		assertFalse("NOR of true and true is not false", result);
	}

	public void testEvaluateTF() {
		final NorFunction node = (NorFunction) getNode();
		final Node[] children = new Node[]{new BooleanLiteral(true),
				new BooleanLiteral(false)};
		node.setChildren(children);
		final boolean result = node.evaluate();

		assertFalse("NOR of true and false is not false", result);
	}

	public void testEvaluateFT() {
		final NorFunction node = (NorFunction) getNode();
		final Node[] children = new Node[]{new BooleanLiteral(false),
				new BooleanLiteral(true)};
		node.setChildren(children);
		final boolean result = node.evaluate();

		assertFalse("NOR of false and true is not false", result);
	}

	public void testEvaluateFF() {
		final NorFunction node = (NorFunction) getNode();
		final Node[] children = new Node[]{new BooleanLiteral(false),
				new BooleanLiteral(false)};
		node.setChildren(children);
		final boolean result = node.evaluate();

		assertTrue("NOR of false and false is not true", result);
	}

}
