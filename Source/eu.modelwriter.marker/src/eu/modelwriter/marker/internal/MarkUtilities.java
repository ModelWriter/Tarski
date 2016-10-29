/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;

public final class MarkUtilities {
  private static transient String TARGET_ATTRIBUTE_NAME = "TARGET_MARKED_ELEMENT";
  private static transient String SOURCE_ATTRIBUTE_NAME = "SOURCE_MARKED_ELEMENT";

  public static final String GROUP_ID = "GROUP_ID";
  public static final String LEADER_ID = "LEADER_ID";
  public static final String MARKER_TYPE = "MARKER_TYPE";
  public static final String URI = "uri";
  public static final String RELATIVE_URI = "REL_URI";

  /**
   * Compares two marker with their sourceIds
   *
   * @param iMarker1
   * @param iMarker2
   * @return true if equals, false otherwise
   */
  public static boolean compare(final IMarker iMarker1, final IMarker iMarker2) {
    if (MarkUtilities.getSourceId(iMarker1).equals(MarkUtilities.getSourceId(iMarker2))) {
      return true;
    }
    return false;
  }

  public static boolean compare(final String sourceId1, final String sourceId2) {
    if (sourceId1.equals(sourceId2)) {
      return true;
    }
    return false;
  }

  public static void focusMarker(final IMarker marker) {
    Display.getDefault().syncExec(new Runnable() {

      @Override
      public void run() {
        try {
          IDE.openEditor(
              MarkerActivator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage(),
              marker);
        } catch (final PartInitException e1) {

          e1.printStackTrace();
        }
      }
    });
  }

  public static int getEnd(final IMarker iMarker) {
    try {
      return (int) iMarker.getAttribute(IMarker.CHAR_END);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static String getGroupId(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute(MarkUtilities.GROUP_ID);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   *
   * @param sourceId
   * @param path
   * @return IMarker
   */
  public static IMarker getiMarker(final String sourceId, final String path) {
    final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
    return MarkerFactory.findMarkerBySourceId(file, sourceId);
  }

  public static String getLeaderId(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute(MarkUtilities.LEADER_ID);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @param marker
   * @return If marker has not group, returns the marker. <br/>
   *         If marker has a group and it is a leader, returns the marker, </br>
   *         Otherwise find and returns it's leader
   */
  public static IMarker getLeaderOfMarker(final IMarker marker) {
    if (MarkUtilities.getGroupId(marker) == null) {
      return marker;
    }

    if (MarkUtilities.getLeaderId(marker) != null) {
      return marker;
    }

    if (MarkUtilities.getGroupId(marker) != null) {
      final Iterator<IMarker> groupMarkers = MarkerFactory
          .findMarkersByGroupId(marker.getResource(), MarkUtilities.getGroupId(marker)).iterator();
      while (groupMarkers.hasNext()) {
        final IMarker iMarker = groupMarkers.next();
        if (MarkUtilities.getLeaderId(iMarker) != null) {
          return iMarker;
        }
      }
    }

    return marker;
  }

  public static int getLength(final IMarker iMarker) {
    try {
      return (int) iMarker.getAttribute(IMarker.CHAR_END) - MarkUtilities.getStart(iMarker);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static int getLinenumber(final IMarker iMarker) {
    try {
      return (int) iMarker.getAttribute(IMarker.LOCATION);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static String getMessage(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute(IMarker.MESSAGE);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getPath(final IMarker iMarker) {
    return iMarker.getResource().getFullPath().toString();
  }

  public static String getSourceAttributeName() {
    return MarkUtilities.SOURCE_ATTRIBUTE_NAME;
  }

  public static String getSourceId(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute(IMarker.SOURCE_ID);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @param iMarker
   * @return If marker has not any source returns new ArrayList, else returns list of sourceF
   *         elements
   */
  public static ArrayList<MarkElement> getSourceList(final IMarker iMarker) {
    ArrayList<MarkElement> sourceList = new ArrayList<>();
    try {
      if (iMarker.getAttribute(MarkUtilities.getSourceAttributeName()) != null) {
        sourceList = Serialization.getInstance()
            .fromString((String) iMarker.getAttribute(MarkUtilities.getSourceAttributeName()));
      }
    } catch (ClassNotFoundException | IOException | CoreException e) {
      e.printStackTrace();
    }
    return sourceList;
  }

  public static int getStart(final IMarker iMarker) {
    try {
      return (int) iMarker.getAttribute(IMarker.CHAR_START);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static String getTargetAttributeName() {
    return MarkUtilities.TARGET_ATTRIBUTE_NAME;
  }

  /**
   * @param iMarker
   * @return If marker has not any target returns new ArrayList, else returns list of target
   *         elements
   */
  public static ArrayList<MarkElement> getTargetList(final IMarker iMarker) {
    ArrayList<MarkElement> targetList = new ArrayList<>();
    try {
      if (iMarker.getAttribute(MarkUtilities.getTargetAttributeName()) != null) {
        targetList = Serialization.getInstance()
            .fromString((String) iMarker.getAttribute(MarkUtilities.getTargetAttributeName()));
      }
    } catch (ClassNotFoundException | IOException | CoreException e) {
      e.printStackTrace();
    }
    return targetList;
  }

  public static String getText(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute(IMarker.TEXT);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getType(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute(MarkUtilities.MARKER_TYPE);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getUri(final IMarker iMarker) {
    try {
      if (iMarker.getAttribute(URI) != null) {
        return iMarker.getAttribute(URI).toString();
      }
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getXpath(final IMarker iMarker) {
    try {
      return (String) iMarker.getAttribute("xpath");
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void setEnd(final IMarker iMarker, final int end) {
    try {
      iMarker.setAttribute(IMarker.CHAR_END, end);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static void setGroupId(final IMarker iMarker, final String groupId) {
    try {
      iMarker.setAttribute(MarkUtilities.GROUP_ID, groupId);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static void setLeaderId(final IMarker iMarker, final String leaderId) {
    try {
      iMarker.setAttribute(MarkUtilities.LEADER_ID, leaderId);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static void setLinenumber(final IMarker iMarker, final int linenumber) {
    try {
      iMarker.setAttribute(IMarker.LOCATION, linenumber);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  private static void setMessage(final IMarker iMarker, final String type) {
    try {
      iMarker.setAttribute(IMarker.MESSAGE,
          type == null ? "Marker Type : non-type" : "Marker Type : " + type);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static void setSourceId(final IMarker imarker, final String id) {
    try {
      imarker.setAttribute(IMarker.SOURCE_ID, id);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the MarkElement.getSourceAttributeName() named attribute of marker with given parameter
   * sourceList
   *
   * @param iMarker
   * @param sourceList
   */
  public static void setSourceList(final IMarker iMarker, final ArrayList<MarkElement> sourceList) {
    try {
      iMarker.setAttribute(MarkUtilities.getSourceAttributeName(),
          Serialization.getInstance().toString(sourceList));
    } catch (CoreException | IOException e) {
      e.printStackTrace();
    }
  }

  public static void setStart(final IMarker iMarker, final int start) {
    try {
      iMarker.setAttribute(IMarker.CHAR_START, start);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the MarkElement.getTargetAttributeName() named attribute of marker with given parameter
   * targetList
   *
   * @param iMarker
   * @param sourceList
   */
  public static void setTargetList(final IMarker iMarker, final ArrayList<MarkElement> targetList) {
    try {
      iMarker.setAttribute(MarkUtilities.getTargetAttributeName(),
          Serialization.getInstance().toString(targetList));
    } catch (CoreException | IOException e) {
      e.printStackTrace();
    }
  }

  public static void setText(final IMarker iMarker, final String text) {
    try {
      iMarker.setAttribute(IMarker.TEXT, text);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static void setType(final IMarker iMarker, final String type) {
    try {
      iMarker.setAttribute(MarkUtilities.MARKER_TYPE, type);
      MarkUtilities.setMessage(iMarker, type);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static void setUri(final IMarker iMarker, final String uri) {
    try {
      iMarker.setAttribute(URI, uri);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  public static String setXpath(final IMarker iMarker, final String xPath) {
    try {
      iMarker.setAttribute("xpath", xPath);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }
}
