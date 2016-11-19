package eu.modelwriter.configuration.internal;

import java.util.regex.Pattern;

public final class Patterns {
  /**
   * Sig trace pattern. <br>
   * e.g. <br>
   * -- Trace@Alias.ClassName <br>
   * 
   * Group 1: Alias of this trace<br>
   * Group 2: EMF Metamodel @EClass name
   */
  public static final Pattern SIG_TRACE_PATTERN =
      Pattern.compile("^--\\s*trace@(\\w+)\\.(\\w+)", Pattern.CASE_INSENSITIVE);

  /**
   * Relation trace pattern. <br>
   * e.g. <br>
   * -- Trace@Alias.ClassName.ReferenceName <br>
   * 
   * Group 1: Alias <br>
   * Group 2: EMF Metamodel @EClass name <br>
   * Group 3: EMF Metamodel @EClass's @EReference
   */
  public static final Pattern REL_TRACE_PATTERN =
      Pattern.compile("^--\\s*trace@(\\w+)\\.(\\w+)\\.(\\w+)", Pattern.CASE_INSENSITIVE);

  /**
   * Sig pattern to find sig's name only. <br>
   * e.g. <br>
   * some sig SigName <br>
   * 
   * Group 1: Sig's name
   */
  public static final Pattern SIG_PATTERN =
      Pattern.compile("(\\w+)?\\s*sig\\s*(\\w+)", Pattern.CASE_INSENSITIVE);

}
