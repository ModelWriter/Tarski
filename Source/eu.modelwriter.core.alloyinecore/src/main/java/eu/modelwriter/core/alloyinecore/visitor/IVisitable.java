package eu.modelwriter.core.alloyinecore.visitor;

public interface IVisitable {
    <T> T accept(IVisitor<? extends T> visitor);
}
