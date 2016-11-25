/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.configuration.alloy.discovery;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class AlloyParserForDiscovering {
  private final String alsPath;

  public AlloyParserForDiscovering(final String alsPath) {
    this.alsPath = alsPath;
  }

  public A4Solution parse() {
    Module world;
    A4Solution solution = null;
    try {
      final A4Reporter rep = new A4Reporter() {
        @Override
        public void warning(final ErrorWarning msg) {
          System.out.print("Relevance Warning:\n" + msg.toString().trim() + "\n\n");
          System.out.flush();
        }
      };

      world = CompUtil.parseEverything_fromFile(rep, null, alsPath);
      final A4Options options = new A4Options();
      options.solver = A4Options.SatSolver.SAT4J;

      for (final Command command : world.getAllCommands()) {
        solution = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command,
            options);

        if (solution.satisfiable()) {
          break;
        }
      }
    } catch (final Err e) {
      e.printStackTrace();
    }
    return solution;
  }
}
