/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    {INITIAL AUTHOR} - initial API and implementation and/or initial documentation
 *    ...
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping;

import java.util.LinkedList;

import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;

import org.eclipse.mylyn.docs.intent.mapping.internal.BaseRegistry;

/**
 * Mapping utility class.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public final class MappingUtils {

	/**
	 * Diff and match wrapping class.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class DiffMatch {

		/**
		 * The list of differences.
		 */
		final LinkedList<Diff> diffs;

		/**
		 * Constructor.
		 * 
		 * @param txt1
		 *            the first text
		 * @param txt2
		 *            the second text
		 */
		private DiffMatch(String txt1, String txt2) {
			diffs = DIFF_MATCH_PATCH.diff_main(txt1, txt2);
		}

		/**
		 * Reduce the number of edits by eliminating operationally trivial equalities.
		 */
		public void cleanupEfficdiency() {
			DIFF_MATCH_PATCH.diff_cleanupEfficiency(diffs);
		}

		/**
		 * Reorder and merge like edit sections. Merge equalities. Any edit section can move as long as it
		 * doesn't cross an equality.
		 */
		public void cleanupMerge() {
			DIFF_MATCH_PATCH.diff_cleanupMerge(diffs);
		}

		/**
		 * Reduce the number of edits by eliminating semantically trivial equalities.
		 */
		public void cleanupSemantic() {
			DIFF_MATCH_PATCH.diff_cleanupSemantic(diffs);
		}

		/**
		 * Look for single edits surrounded on both sides by equalities which can be shifted sideways to align
		 * the edit to a word boundary. e.g: "The c<ins>at c</ins>ame." -> "The <ins>cat </ins>came".
		 */
		public void cleanupSemanticLossless() {
			DIFF_MATCH_PATCH.diff_cleanupSemanticLossless(diffs);
		}

		/**
		 * Gets the <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance</a>.
		 * 
		 * @return the <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance</a>
		 */
		public int getLevenshteinDistance() {
			return DIFF_MATCH_PATCH.diff_levenshtein(diffs);
		}

		/**
		 * Gets the index in text2 from corresponding to the index in text1.
		 * 
		 * @param index
		 *            the index in text1
		 * @return the index in text2 from corresponding to the index in text1
		 */
		public int getIndex(int index) {
			return DIFF_MATCH_PATCH.diff_xIndex(diffs, index);
		}

	}

	/**
	 * The {@link IBaseRegistry}.
	 */
	private static final BaseRegistry REGISTRY = new BaseRegistry();

	/**
	 * Diff match patch instance.
	 */
	private static final diff_match_patch DIFF_MATCH_PATCH = new diff_match_patch();

	/**
	 * Constructor.
	 */
	private MappingUtils() {
		// nothing to do here
	}

	/**
	 * Gets a {@link DiffMatch} for the two given {@link String}.
	 * 
	 * @param txt1
	 *            the first text
	 * @param txt2
	 *            the second text
	 * @return a {@link DiffMatch} for the two given {@link String}
	 */
	public static DiffMatch getDiffMatch(String txt1, String txt2) {
		return new DiffMatch(txt1, txt2);
	}

	/**
	 * Gets the index of the matching pattern in the given text, near the given index. The match is based on
	 * an heuristic between the editing distance and the index distance.
	 * 
	 * @param text
	 *            the text
	 * @param pattern
	 *            the pattern to match (not longer than {@link Long#SIZE})
	 * @param index
	 *            the expected index in text
	 * @return the index of the matching pattern in the given text, near the given index
	 */
	public static int fuzzyMatch(String text, String pattern, int index) {
		return DIFF_MATCH_PATCH.match_main(text, pattern, index);
	}

	/**
	 * Gets the {@link IBaseRegistry}.
	 * 
	 * @return the {@link IBaseRegistry}
	 */
	public static IBaseRegistry getRegstry() {
		return REGISTRY;
	}

}
