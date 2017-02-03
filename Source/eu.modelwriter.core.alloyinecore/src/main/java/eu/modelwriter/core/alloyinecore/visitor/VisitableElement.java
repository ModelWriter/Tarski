package eu.modelwriter.core.alloyinecore.visitor;

public interface VisitableElement {
    <T> T accept(AlloyInEcoreVisitor<? extends T> visitor);
}
