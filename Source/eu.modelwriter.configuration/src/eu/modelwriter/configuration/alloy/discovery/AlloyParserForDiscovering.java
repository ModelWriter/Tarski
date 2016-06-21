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

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;

public class AlloyParserForDiscovering {

  private final String filename;
  String xmlFileLoc = InstanceTranslatorDiscovering.baseFileDirectory + "reasoning.xml";

  public AlloyParserForDiscovering(final String filename) {
    this.filename = filename;
    // this.parse(filename);
  }

  public DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(this.xmlFileLoc));
    } catch (final IOException e) {
      return null;
    }
    if (list == null || list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  protected DocumentRoot parse() {
    Module world;
    A4Solution ans = null;
    try {
      final A4Reporter rep = new A4Reporter() {
        @Override
        public void warning(final ErrorWarning msg) {
          System.out.print("Relevance Warning:\n" + msg.toString().trim() + "\n\n");
          System.out.flush();
        }
      };

      world = CompUtil.parseEverything_fromFile(rep, null, this.filename);

      final A4Options options = new A4Options();
      options.solver = A4Options.SatSolver.SAT4J;

      for (final Command command : world.getAllCommands()) {

        ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command,
            options);

        if (ans.satisfiable()) {
          ans.writeXML(this.xmlFileLoc);
          final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder;
          try {
            builder = factory.newDocumentBuilder();
            final File file = new File(this.xmlFileLoc);
            final Document document = builder.parse(file);
            final Node instance = document.getElementsByTagName("instance").item(0);
            instance.getAttributes().removeNamedItem("command");

            Transformer transformer;
            try {
              transformer = TransformerFactory.newInstance().newTransformer();
              final DOMSource source = new DOMSource(document);
              final StreamResult result = new StreamResult(file);
              transformer.transform(source, result);
            } catch (final Exception e) {
            }

          } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
          }

          break;
        }
      }

    } catch (final Err e) {
      e.printStackTrace();
    }

    final DocumentRoot documentRoot = this.getDocumentRoot();

    return documentRoot;
  }

}
