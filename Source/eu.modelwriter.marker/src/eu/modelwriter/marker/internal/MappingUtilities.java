package eu.modelwriter.marker.internal;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.intent.mapping.ide.connector.ResourceConnector;
import org.eclipse.intent.mapping.ide.resource.ITextFileLocation;
import org.eclipse.jface.text.Position;
import org.eclipse.mylyn.docs.intent.mapping.Base;
import org.eclipse.mylyn.docs.intent.mapping.MappingFactory;
import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;
import org.eclipse.mylyn.docs.intent.mapping.MappingUtils;
import org.eclipse.mylyn.docs.intent.mapping.base.IBase;
import org.eclipse.mylyn.docs.intent.mapping.base.ILink;
import org.eclipse.mylyn.docs.intent.mapping.base.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.base.ILocationContainer;
import org.eclipse.mylyn.docs.intent.mapping.emf.EObjectConnector;
import org.eclipse.mylyn.docs.intent.mapping.emf.IEObjectLocation;
import org.eclipse.mylyn.docs.intent.mapping.emf.ide.resource.IEObjectFileLocation;
import org.eclipse.mylyn.docs.intent.mapping.ide.EObjectFileLocation;
import org.eclipse.mylyn.docs.intent.mapping.ide.TextFileLocation;
import org.eclipse.mylyn.docs.intent.mapping.text.ITextLocation;
import org.eclipse.mylyn.docs.intent.mapping.text.TextConnector;
import org.eclipse.mylyn.docs.intent.mapping.text.TextRegion;

public class MappingUtilities {

  public static String xmlFileLocation = ".modelwriter\\mappingPersistence.xml";

  public static URI getUri() {
    return URI.createFileURI(MappingUtilities.getLocation());
  }

  public static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/"
        + MappingUtilities.xmlFileLocation;
  }

  public static IBase getBase() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list = modelIO.read(MappingUtilities.getUri());
    if (list.isEmpty()) {
      return null;
    }
    final IBase base = (IBase) list.get(0);
    return base;
  }

  @SuppressWarnings("unchecked")
  public static void writeBase(final IBase base) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    modelIO.write(MappingUtilities.getUri(), (Base) base);
  }

  public static ITextFileLocation getTextFileLocation(IBase base, IMarker marker) {
    List<ILocation> Locations = base.getContents();
    String fullPath = marker.getResource().getFullPath().toString();

    for (ILocation iLocation : Locations) {
      if ((iLocation instanceof TextFileLocation)
          && ((TextFileLocation) iLocation).getFullPath().equals(fullPath)) {
        return (TextFileLocation) iLocation;
      }
    }

    MappingUtils.getBaseRegistry().register(base);

    final ResourceConnector resourceConnector = new ResourceConnector();
    try {
      ITextFileLocation fileLocation =
          (ITextFileLocation) resourceConnector.createLocation(base, null, marker.getResource());
      base.getContents().add(fileLocation);
      return fileLocation;
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;
  }

  public static void addTextLocation(IMarker marker, String type) {
    IBase base = getBase();

    if (base == null) {
      base = MappingPackage.eINSTANCE.getMappingFactory().createBase();
      base.setName("persistence");

      MappingUtils.getBaseRegistry().register(base);
    }

    ITextFileLocation fileLocation = getTextFileLocation(base, marker);

    if (fileLocation == null)
      return;

    final TextConnector textConnector = new TextConnector();
    try {
      ILocation textLocation = textConnector.createLocation(base, fileLocation,
          new TextRegion(Integer.parseInt(marker.getAttribute(IMarker.CHAR_START).toString()),
              Integer.parseInt(marker.getAttribute(IMarker.CHAR_END).toString())));
      textLocation.setContainer(fileLocation);
      fileLocation.getContents().add(textLocation);
      if (type != null)
        textLocation.setType(type);
    } catch (InstantiationException | IllegalAccessException | CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    writeBase(base);
  }

  public static void updateTextLocation(IMarker marker, Position position) {
    IBase base = getBase();

    ITextLocation textLocation = getTextLocationByMarker(base, marker);

    int newStartOffset = position.getOffset();
    int newEndOffset = position.getOffset() + position.getLength();

    textLocation.setStartOffset(newStartOffset);
    textLocation.setEndOffset(newEndOffset);

    writeBase(base);
  }

  public static ITextLocation getTextLocationByMarker(IBase base, IMarker marker) {
    ITextFileLocation fileLocation = getTextFileLocation(base, marker);

    List<ILocation> contentList = fileLocation.getContents();

    try {
      int oldStartOffset = Integer.parseInt(marker.getAttribute(IMarker.CHAR_START).toString());
      int oldEndOffset = oldStartOffset + marker.getAttribute(IMarker.TEXT).toString().length();

      for (ILocation iLocation : contentList) {
        if (iLocation instanceof ITextLocation) {
          ITextLocation textLocation = (ITextLocation) iLocation;
          if (textLocation.getStartOffset() == oldStartOffset
              && textLocation.getEndOffset() == oldEndOffset)
            return textLocation;
        }
      }
    } catch (NumberFormatException | CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;
  }

  public static void removeTextLocation(IMarker marker) {
    IBase base = getBase();

    ITextLocation textLocation = getTextLocationByMarker(base, marker);

    ILocationContainer container = textLocation.getContainer();
    container.getContents().remove(textLocation);

    if (container.getContents().isEmpty() && container instanceof ITextFileLocation) {
      ITextFileLocation fileLocation = (ITextFileLocation) container;
      ILocationContainer fileContainer = fileLocation.getContainer();
      fileContainer.getContents().remove(fileLocation);
    }

    // TODO linklerin statue leri ayarlanacak

    writeBase(base);
  }

  public static void addLinkToLocation(IMarker fromMarker, IMarker toMarker) {
    IBase base = getBase();

    ILocation fromLocation = getTextLocationByMarker(base, fromMarker);
    ILocation toLocation = getTextLocationByMarker(base, toMarker);

    ILink link = MappingFactory.eINSTANCE.createLink();

    link.setTarget(toLocation);
    link.setSource(fromLocation);

    fromLocation.getTargetLinks().add(link);
    toLocation.getSourceLinks().add(link);

    writeBase(base);
  }

  public static void addEObjectLocation(IMarker marker, EObject eObject, String type) {
    IBase base = getBase();

    if (base == null) {
      base = MappingPackage.eINSTANCE.getMappingFactory().createBase();
      base.setName("persistence");

      MappingUtils.getBaseRegistry().register(base);
    }

    IEObjectFileLocation fileLocation = getEObjectFileLocation(base, marker);

    if (fileLocation == null)
      return;

    final EObjectConnector eObjectConnector = new EObjectConnector();
    try {
      IEObjectLocation eObjectLocation =
          (IEObjectLocation) eObjectConnector.createLocation(base, fileLocation, eObject);
      eObjectLocation.setContainer(fileLocation);
      fileLocation.getContents().add(eObjectLocation);
      if (type != null)
        eObjectLocation.setType(type);
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    writeBase(base);
  }

  public static IEObjectFileLocation getEObjectFileLocation(IBase base, IMarker marker) {
    List<ILocation> Locations = base.getContents();
    String fullPath = marker.getResource().getFullPath().toString();

    for (ILocation iLocation : Locations) {
      if ((iLocation instanceof EObjectFileLocation)
          && ((EObjectFileLocation) iLocation).getFullPath().equals(fullPath)) {
        return (EObjectFileLocation) iLocation;
      }
    }

    MappingUtils.getBaseRegistry().register(base);

    final ResourceConnector resourceConnector = new ResourceConnector();
    try {
      IEObjectFileLocation fileLocation =
          (IEObjectFileLocation) resourceConnector.createLocation(base, null, marker.getResource());
      base.getContents().add(fileLocation);
      return fileLocation;
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;
  }
}

