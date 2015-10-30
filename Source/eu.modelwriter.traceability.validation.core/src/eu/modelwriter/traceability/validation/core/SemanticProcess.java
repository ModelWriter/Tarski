package eu.modelwriter.traceability.validation.core;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.CoreParser.SetContext;
import eu.modelwriter.traceability.validation.core.CoreParser.TupleContext;

@SuppressWarnings("rawtypes")
public class SemanticProcess extends CoreBaseVisitor {

  ArrayList<String> setList = new ArrayList<String>();

  @Override
  public Object visitTuple(TupleContext ctx) {
    String relationName = ((SetContext) ctx.parent).RELATION_NAME().getText();
    for (TerminalNode node : ctx.IDENTIFIER()) {
      relationName += "_" + node.getText();
    }
    setList.add(relationName);
    return super.visitTuple(ctx);
  }

}
