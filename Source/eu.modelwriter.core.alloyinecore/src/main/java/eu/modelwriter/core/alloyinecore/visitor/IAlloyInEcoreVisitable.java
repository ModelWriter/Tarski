package eu.modelwriter.core.alloyinecore.visitor;

public interface IAlloyInEcoreVisitable {
    <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor);
}
