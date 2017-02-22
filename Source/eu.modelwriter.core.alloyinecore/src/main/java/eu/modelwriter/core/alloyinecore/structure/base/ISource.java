package eu.modelwriter.core.alloyinecore.structure.base;

import eu.modelwriter.core.alloyinecore.structure.model.Model;

import java.util.List;
import java.util.stream.Collectors;

public interface ISource extends ISegment {

    default List<ISegment> getTargets() {
        Element<?> model = this.getOwner().getOwner(Model.class);
        return model.getAllOwnedElements().stream()
                .filter(e -> e instanceof ITarget)
                .map(e -> (ISegment) e)
                .collect(Collectors.toList());
    }
}
