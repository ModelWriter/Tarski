package eu.modelwriter.core.alloyinecore.visitor;

public interface IVisitor<T,R> {

    R visit(T element);

    R visitChildren(T element);

}
