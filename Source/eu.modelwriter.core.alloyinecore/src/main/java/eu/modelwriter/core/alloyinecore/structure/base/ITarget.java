package eu.modelwriter.core.alloyinecore.structure.base;

import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;

public interface ITarget extends ISegment {

    default String getRelativeSegment() {
        String path = this.getSegment();
        for (Element parent = this.getOwner(); parent != null; parent = parent.getOwner()) {
            if (parent instanceof ISegment) {
                String parentsPathName = ((ISegment) parent).getSegment();
                if (!parentsPathName.isEmpty()) {
                    path = parentsPathName + "::" + path;
                }
                if (parent instanceof RootPackage || parent instanceof Import) {
                    break;
                }
            }
        }
        return path;
    }

}
