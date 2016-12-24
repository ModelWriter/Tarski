package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;

public class CS2ASInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final CS2ASInitializer instance = new CS2ASInitializer();

  @Override
  public Object visitModule(final ModuleContext ctx) {
    ImportInitializer.instance.visit(ctx);
    PackageInitializer.instance.visit(ctx);
    ClassifierInitializer.instance.visit(ctx);
    ReferenceInitializer.instance.visit(ctx);
    return null;
  }

  public void clearInitializer() {
    PackageInitializer.instance.clear();
    ClassifierInitializer.instance.clear();
    ReferenceInitializer.instance.clear();
  }
}
