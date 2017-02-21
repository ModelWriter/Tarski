package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.base.Element;

import javax.tools.Diagnostic;
import java.util.HashSet;
import java.util.Set;

public class Trace {
    private Set<Element<?>> tokens;
    private String fileName;
    private int lineNumber, startOffset, endOffset;

    public Trace(String fileName, int lineNumber, int startOffset, int endOffset) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        tokens = new HashSet<>();
    }

    public void addToken(Element<?> token) {
        tokens.add(token);
    }

    public Set<Element<?>> getTokens() {
        return tokens;
    }

    public boolean overlaps(Diagnostic diagnostic) {
        return ((JavaSourceFromString) diagnostic.getSource()).getRawName().equals(fileName) &&
                startOffset <= diagnostic.getStartPosition() - 1
                && diagnostic.getEndPosition() - 1 <= endOffset
                && diagnostic.getLineNumber() - 1 == lineNumber;
    }

    public boolean overlaps(int start, int end) {
        return startOffset <= start && end <= endOffset;
    }
}
