/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation and/or initial documentation
 *    ...
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping.tests.text;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.tests.LocationFactoryTests.TestLocation;
import org.eclipse.mylyn.docs.intent.mapping.text.ITextContainer;
import org.eclipse.mylyn.docs.intent.mapping.text.ITextLocation;
import org.eclipse.mylyn.docs.intent.mapping.text.TextConnector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TextConnector} ICon.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
@RunWith(Parameterized.class)
public class TextConnectorTests {

	/**
	 * Test {@link ITextContainer}.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class TestTextContainerLocation extends TestLocation implements ITextContainer {

	/**
	 * The {@link List} of children.
	 */
	private final List<ILocation> children = new ArrayList<ILocation>();

	/**
	 * The containing text.
	 */
	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public List<ILocation> getContents() {
		return children;
	}

	}

	/**
	 * Test {@link ITextLocation}.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class TestTextLocation extends TestLocation implements ITextLocation {

	/**
	 * the container.
	 */
	private ILocation container;

	/**
	 * The text.
	 */
	private String text;

	/**
	 * The offset.
	 */
	private int textOffset;

	@Override
	public void setContainer(ILocation location) {
		container = location;
	}

	@Override
	public ILocation getContainer() {
		return container;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setTextOffset(int offset) {
		textOffset = offset;
	}

	public int getTextOffset() {
		return textOffset;
	}

	}

	/**
	 * The original {@link ITextLocation#getText() text}.
	 */
	private final String original;

	/**
	 * The altered {@link ITextLocation#getText() text}.
	 */
	private final String altered;

	/**
	 * The text to test.
	 */
	private String testText;

	public TextConnectorTests(String original, String altered) {
	this.original = original;
	this.altered = altered;
	try {
		testText = getContent(TextConnectorTests.class.getResourceAsStream("/text.txt"), "UTF-8");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	@Parameters(name = "{0}")
	public static Iterable<String[]> data() {
	return Arrays.asList(new String[][] {{"or Fragment may be", "or Fragment may not be", }, {
		"FEATURE LICENSES, AND FEATURE UPDATE LICENSES MAY REFER TO THE EPL OR",
		"FEATURE LICENSES, AND FEATURE UPDATE LICENSES MAY REFER TO THE LICENSES MAY REFER TO THE EPL OR", },
		{"Eclipse Public License Version 1.0 (\"EPL\"). A copy of the EPL is provided with this Content and is also available at http://www.eclipse.org/legal/epl-v10.html.",
			"Eclipse Public License Version 1.0 (\"EPL\"). A copy of the EPL is provided with this  Some new text at the Content and is also available at http://www.eclipse.org/legal/epl-v10.html.", },
		{"Each Feature may be packaged as a sub-directory",
			"Each Some new text at the Feature may be packaged as a sub-directory", },

		{"is a bundle of one or more Plug-ins and/or Fragments",
			"is a bundle of one or more Plug-ins and", },

		{"(available at http://www.opengroup.org/openmotif/supporters/metrolink/license.html)",
			"www.opengroup.org/openmotif/supporters/metrolink/license.html)", }, });
	}

	/**
	 * Gets the {@link ITextLocation} to test.
	 * 
	 * @param container
	 *            the {@link TestTextContainerLocation}that will contain created {@link ITextLocation}
	 * @param useAltered
	 *            if <code>true</code> {@link AbstractTextConnectorTests#altered} is used,
	 *            {@link AbstractTextConnectorTests#original} is used otherwise
	 * @param shift
	 *            the value to add to {@link ITextLocation#getTextOffset() text offset}.
	 * @return the {@link ITextLocation} to test
	 */
	protected ITextLocation createTextLocations(TestTextContainerLocation container) {
	final ITextLocation res = new TestTextLocation();

	res.setText(original);
	res.setTextOffset(container.getText().indexOf(original));
	res.setContainer(container);
	container.getContents().add(res);

	return res;
	}

	protected String createString(int length) {
	final StringBuilder builder = new StringBuilder(length);

	for (int i = 0; i < length; ++i) {
		builder.append(' ');
	}

	return builder.toString();
	}

	/**
	 * Gets the content of the given {@link InputStream}.
	 * 
	 * @param stream
	 *            the {@link InputStream}
	 * @param charsetName
	 *            The name of a supported {@link java.nio.charset.Charset </code>charset<code>}
	 * @return a {@link CharSequence} of the content of the given {@link InputStream}
	 * @throws IOException
	 *             if the {@link InputStream} can't be read
	 */
	public static String getContent(InputStream stream, String charsetName) throws IOException {
	final int len = 8192;
	StringBuilder res = new StringBuilder(len);
	if (len != 0) {
		InputStreamReader input = new InputStreamReader(new BufferedInputStream(stream), charsetName);
		char[] buffer = new char[len];
		int length = input.read(buffer);
		while (length != -1) {
		res.append(buffer, 0, length);
		length = input.read(buffer);
		}
		input.close();
	}
	return res.toString();
	}

	@Test
	public void updateText() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = location.getText();
	final int expectedTextOffset = location.getTextOffset();

	connector.update(container, container.getText());

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextPlusShift() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = location.getText();
	final int expectedTextOffset = location.getTextOffset() + 20;

	final String newText = createString(20) + container.getText();
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextMinusShift() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = location.getText();
	final int expectedTextOffset = location.getTextOffset() - 20;

	final String newText = container.getText().substring(20);
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextAltered() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = altered;
	final int expectedTextOffset = location.getTextOffset();

	final String newText = container.getText().replace(original, altered);
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextPlusShiftAltered() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = altered;
	final int expectedTextOffset = location.getTextOffset() + 20;

	final String newText = createString(20) + container.getText().replace(original, altered);
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextMinusShiftAltered() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = altered;
	final int expectedTextOffset = location.getTextOffset() - 20;

	final String newText = container.getText().replace(original, altered).substring(20);
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	private void assertTextLocation(ITextLocation location, String expectedText, int expectedTextOffset) {
	assertEquals(expectedText, location.getText());
	assertEquals(expectedTextOffset, location.getTextOffset());
	}

	@Test
	public void updateTextRemoved() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = "";
	final int expectedTextOffset = location.getTextOffset();

	final String newText = container.getText().replace(original, "");
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextPlusShiftRemoved() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = "";
	final int expectedTextOffset = location.getTextOffset() + 20;

	final String newText = createString(20) + container.getText().replace(original, "");
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

	@Test
	public void updateTextMinusShiftRemoved() {
	final TestTextContainerLocation container = new TestTextContainerLocation();
	container.setText(testText);
	final ITextLocation location = createTextLocations(container);
	final TextConnector connector = new TextConnector();

	final String expectedText = "";
	final int expectedTextOffset = location.getTextOffset() - 20;

	final String newText = container.getText().replace(original, "").substring(20);
	connector.update(container, newText);

	assertTextLocation(location, expectedText, expectedTextOffset);
	}

}
