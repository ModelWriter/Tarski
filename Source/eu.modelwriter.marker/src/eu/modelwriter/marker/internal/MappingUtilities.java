package eu.modelwriter.marker.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.intent.mapping.ide.connector.ResourceConnector;
import org.eclipse.intent.mapping.ide.resource.IFileLocation;
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
import org.eclipse.mylyn.docs.intent.mapping.base.IScope;
import org.eclipse.mylyn.docs.intent.mapping.emf.EObjectConnector;
import org.eclipse.mylyn.docs.intent.mapping.emf.IEObjectLocation;
import org.eclipse.mylyn.docs.intent.mapping.emf.ITextAdapter;
import org.eclipse.mylyn.docs.intent.mapping.emf.ide.resource.IEObjectFileLocation;
import org.eclipse.mylyn.docs.intent.mapping.ide.EObjectFileLocation;
import org.eclipse.mylyn.docs.intent.mapping.ide.TextFileLocation;
import org.eclipse.mylyn.docs.intent.mapping.text.ITextLocation;
import org.eclipse.mylyn.docs.intent.mapping.text.TextConnector;
import org.eclipse.mylyn.docs.intent.mapping.text.TextRegion;

public class MappingUtilities {

  public static String xmlFileLocation = ".modelwriter\\mappingPersistence.xml";

  public static URI getUri() {
    return URI.createFileURI(MappingUtilities.getXmlLocation());
  }

  /**
   * @return location to save the xml file
   */
  public static String getXmlLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/"
        + MappingUtilities.xmlFileLocation;
  }

  /**
   * @return base which from xml file.If xml is not exist,return new created base.
   */
  public static IBase getBase() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list = modelIO.read(MappingUtilities.getUri());
    if (list.isEmpty()) {
      return createBase();
    }
    final IBase base = (IBase) list.get(0);
    MappingUtils.getBaseRegistry().register(base);
    return base;
  }

  /**
   * Write the given base to xml file
   * 
   * @param base
   */
  @SuppressWarnings("unchecked")
  public static void writeBase(final IBase base) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    modelIO.write(MappingUtilities.getUri(), (Base) base);
  }

  /**
   * Find TextFileLocation or EObjectFileLocation by resource of marker in base
   * 
   * @param base
   * @param marker
   * @return
   */
  public static ILocation getFileLocation(IBase base, IMarker marker) {
    List<ILocation> Locations = base.getContents();
    String fullPath = marker.getResource().getFullPath().toString();

    for (ILocation iLocation : Locations) {
      if (((iLocation instanceof TextFileLocation)
          && ((TextFileLocation) iLocation).getFullPath().equals(fullPath))
          || ((iLocation instanceof EObjectFileLocation)
              && ((EObjectFileLocation) iLocation).getFullPath().equals(fullPath))) {
        return iLocation;
      }
    }

    return null;
  }

  /**
   * Create location(TextFileLocation or EObjectFileLocation) by resource of marker and return this
   * location
   * 
   * @param base
   * @param marker
   * @return
   */
  public static ILocation createFileLocation(IBase base, IMarker marker) {

    final ResourceConnector resourceConnector = new ResourceConnector();
    try {
      ILocation fileLocation = resourceConnector.createLocation(base, null, marker.getResource());
      base.getContents().add(fileLocation);
      return fileLocation;
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Create TextLocation and add to TextFileLocation of resource of marker
   * 
   * @param marker
   * @param type
   */
  public static void addTextLocation(IMarker marker, String type) {
    IBase base = getBase();

    ILocation fileLocation = getFileLocation(base, marker);

    if (fileLocation == null)
      fileLocation = createFileLocation(base, marker);

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

  /**
   * Update TextLocation offsets by given position
   * 
   * @param marker
   * @param position
   */
  public static void updateTextLocation(IMarker marker, Position position) {
    IBase base = getBase();

    ITextLocation textLocation = (ITextLocation) getLocationByMarker(base, marker);
    if (textLocation == null)
      return;

    int newStartOffset = position.getOffset();
    int newEndOffset = position.getOffset() + position.getLength();

    textLocation.setStartOffset(newStartOffset);
    textLocation.setEndOffset(newEndOffset);

    writeBase(base);
  }

  /**
   * Find TextLocation or EObjectLocation in base by given marker
   * 
   * @param base
   * @param marker
   * @return
   */
  public static ILocation getLocationByMarker(IBase base, IMarker marker) {
    ILocation fileLocation = getFileLocation(base, marker);

    List<ILocation> contentList = fileLocation.getContents();

    try {
      if (MarkUtilities.getUri(marker) == null) {
        int oldStartOffset =
            Integer.parseInt(marker.getAttribute(MarkUtilities.START_OFFSET).toString());
        int oldEndOffset =
            Integer.parseInt(marker.getAttribute(MarkUtilities.END_OFFSET).toString());

        for (ILocation iLocation : contentList) {
          if (iLocation instanceof ITextLocation) {
            ITextLocation textLocation = (ITextLocation) iLocation;
            if (textLocation.getStartOffset() == oldStartOffset
                && textLocation.getEndOffset() == oldEndOffset)
              return textLocation;
          }
        }
      } else {
        String uri = MarkUtilities.getUri(marker);

        for (ILocation iLocation : contentList) {
          if (iLocation instanceof IEObjectLocation) {
            IEObjectLocation eObjectLocation = (IEObjectLocation) iLocation;
            if (eObjectLocation.getEObject() != null
                && EcoreUtil.getURI(eObjectLocation.getEObject()).toString().equals(uri))
              return eObjectLocation;
          }
        }


      }
    } catch (NumberFormatException | CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Remove TextLocation or EObjectLocation in base
   * 
   * @param marker
   */
  public static void removeLocation(IMarker marker) {
    IBase base = getBase();

    ILocation textLocation = getLocationByMarker(base, marker);

    ILocationContainer container = textLocation.getContainer();
    container.getContents().remove(textLocation);

    if (container.getContents().isEmpty() && container instanceof IFileLocation) {
      IFileLocation fileLocation = (IFileLocation) container;
      ILocationContainer fileContainer = fileLocation.getContainer();
      fileContainer.getContents().remove(fileLocation);
    }

    // TODO linklerin statue leri ayarlanacak

    writeBase(base);
  }

  /**
   * Find locations by markers and create link between these locations
   * 
   * @param fromMarker
   * @param toMarker
   * @param type
   */
  public static void addLinkToLocation(IMarker fromMarker, IMarker toMarker, String type) {
    IBase base = getBase();

    ILocation fromLocation = getLocationByMarker(base, fromMarker);
    ILocation toLocation = getLocationByMarker(base, toMarker);

    ILink link = MappingFactory.eINSTANCE.createLink();

    link.setTarget(toLocation);
    link.setSource(fromLocation);

    fromLocation.getTargetLinks().add(link);
    toLocation.getSourceLinks().add(link);

    if (type != null)
      link.setType(type);

    writeBase(base);
  }

  /**
   * Create EObjectLocation and add to EObjectFileLocation of resource of marker
   * 
   * @param marker
   * @param eObject
   * @param type
   */
  public static void addEObjectLocation(IMarker marker, EObject eObject, String type) {
    IBase base = getBase();

    ILocation fileLocation = getFileLocation(base, marker);

    if (fileLocation == null)
      fileLocation = createFileLocation(base, marker);

    final EObjectConnector eObjectConnector = new EObjectConnector();
    try {
      IEObjectLocation eObjectLocation =
          (IEObjectLocation) eObjectConnector.createLocation(base, fileLocation, eObject);
      eObjectLocation.setContainer(fileLocation);
      final ITextAdapter textAdapter =
          EObjectConnector.getTextAdapter(eObjectLocation.getEObject());
      textAdapter.setLocationFromEObject(eObjectLocation);
      fileLocation.getContents().add(eObjectLocation);
      if (type != null)
        eObjectLocation.setType(type);
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    writeBase(base);
  }

  public static void addScopeToLocation(ILocation location, ILocation scopeLocation) {
    IScope scope = location.getScope();

    if (scope == null) {
      scope = MappingFactory.eINSTANCE.createScope();
      location.setScope(scope);
    }

    scope.getLocations().add(scopeLocation);
  }

  /**
   * Create base
   * 
   * @return
   */
  public static IBase createBase() {
    IBase base = MappingPackage.eINSTANCE.getMappingFactory().createBase();
    base.setName("persistence");

    MappingUtils.getBaseRegistry().register(base);
    return base;
  }

  /**
   * Find Location by marker and change type of location
   * 
   * @param marker
   * @param type
   */
  public static void changeTypeOfLocation(IMarker marker, String type) {
    IBase base = getBase();

    ILocation location = getLocationByMarker(base, marker);

    location.getContents().clear();

    for (ILink link : location.getSourceLinks()) {
      link.getSource().getTargetLinks().remove(link);
    }
    location.getSourceLinks().clear();

    for (ILink link : location.getTargetLinks()) {
      link.getTarget().getSourceLinks().remove(link);
    }
    location.getTargetLinks().clear();

    location.setType(type);

    writeBase(base);
  }

  /**
   * Find marker by given location
   * 
   * @param location
   * @return
   */
  public static IMarker getMarkerByLocation(ILocation location) {
    IFileLocation fileLocation = (IFileLocation) location.getContainer();
    Path path = new Path(fileLocation.getFullPath());
    IResource resource = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

    if (location.getContainer() instanceof ITextFileLocation) {
      return MarkerFactory.findMarkerWithAbsolutePosition(resource,
          ((ITextLocation) location).getStartOffset(), ((ITextLocation) location).getEndOffset());
    } else if (location.getContainer() instanceof IEObjectFileLocation) {
      return MarkerFactory.findMarkersByUri(resource,
          EcoreUtil.getURI(((IEObjectLocation) location).getEObject()).toString());
    }

    return null;
  }

  // deletehandlerdaki findCandidateToTypeChangingMarkers da kullanılacak
  // SourceViewRefreshHandler da kulanılacak
  // getRelationsOfSecondSideMarker(IMarker) yerine
  /**
   * find source markers of given marker
   * 
   * @param marker
   * @return
   */
  public static ArrayList<IMarker> getSourcesOfMarker(IMarker marker) {
    IBase base = getBase();

    ILocation location = getLocationByMarker(base, marker);

    List<ILink> linksOfLocation = location.getSourceLinks();

    ArrayList<IMarker> sourceMarkerList = new ArrayList<IMarker>();

    for (ILink iLink : linksOfLocation) {
      IMarker sourceMarker = getMarkerByLocation((ITextLocation) iLink.getSource());
      sourceMarkerList.add(sourceMarker);
    }

    return sourceMarkerList;
  }

  // TargetViewRefreshHandler da kulanılacak
  /**
   * find target markers of given marker
   * 
   * @param marker
   * @return
   */
  public static ArrayList<IMarker> getTargetsOfMarker(IMarker marker) {
    IBase base = getBase();

    ILocation location = getLocationByMarker(base, marker);

    List<ILink> linksOfLocation = location.getTargetLinks();

    ArrayList<IMarker> targetMarkerList = new ArrayList<IMarker>();

    for (ILink iLink : linksOfLocation) {
      IMarker targetMarker = getMarkerByLocation((ITextLocation) iLink.getTarget());
      targetMarkerList.add(targetMarker);
    }

    return targetMarkerList;
  }

  /**
   * Find locations by markers and remove link between these locations
   * 
   * @param sourceMarker
   * @param targetMarker
   */
  public static void removeLink(IMarker sourceMarker, IMarker targetMarker) {
    IBase base = getBase();

    ILocation sourceLocation = getLocationByMarker(base, sourceMarker);
    ILocation targetLocation = getLocationByMarker(base, targetMarker);

    Iterator<ILink> linksIter = sourceLocation.getTargetLinks().iterator();
    while (linksIter.hasNext()) {
      ILink iLink = (ILink) linksIter.next();
      if (iLink.getTarget().equals(targetLocation)) {
        targetLocation.getSourceLinks().remove(iLink);
        linksIter.remove();
      }
    }

    writeBase(base);
  }

}

