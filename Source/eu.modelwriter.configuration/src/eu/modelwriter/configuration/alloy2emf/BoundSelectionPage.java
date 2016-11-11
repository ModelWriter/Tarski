package eu.modelwriter.configuration.alloy2emf;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import eu.modelwriter.configuration.internal.EcoreUtilities;

public class BoundSelectionPage extends AlloyToEMFWizardPage {

  class BoundItem {
    String sigName;
    private int initLower, lower;
    private int initUpper, upper;
    EClass eClass;
    private JSpinner lowerSpinner;
    private JSpinner upperSpinner;

    public BoundItem(String sigName, int initLower, int initUpper) {
      this.sigName = sigName;
      this.initLower = initLower;
      this.initUpper = initUpper;
      setLower(initLower);
      setUpper(initUpper);
    }

    public EClass getEClass() {
      return eClass;
    }

    public void setEClass(EClass eClass) {
      this.eClass = eClass;
    }

    public int getLower() {
      return lower;// lowerSpinner == null ? lower : (int) lowerSpinner.getValue();
    }

    public int getUpper() {
      return upper; // upperSpinner == null ? upper : (int) upperSpinner.getValue();
    }

    public int getSpinnerLower() {
      return lowerSpinner == null ? lower : (int) lowerSpinner.getValue();
    }

    public int getSpinnerUpper() {
      return upperSpinner == null ? upper : (int) upperSpinner.getValue();
    }


    public void setLower(int lower) {
      this.lower = lower;
    }

    void setUpper(int upper) {
      this.upper = upper;
    }

    public void reset() {
      setUpper(initUpper);
      setLower(initLower);
    }

    JSpinner getLowerSpinner() {
      return lowerSpinner;
    }

    void setLowerSpinner(JSpinner lowerModel) {
      lowerSpinner = lowerModel;
      lowerModel.setValue(lower);
    }

    JSpinner getUpperSpinner() {
      return upperSpinner;
    }

    void setUpperSpinner(JSpinner upperModel) {
      upperSpinner = upperModel;
      upperModel.setValue(upper);
    }

    void updateValues() {
      upperSpinner.setValue(upper);
      lowerSpinner.setValue(lower);
    }
  }

  public static final String NEW_LINE = System.getProperty("line.separator");
  private static final int DEFAULT_UPPER = 3;
  private static final String PRED_FORMAT = "\t#%s >= %d && #%s <= %d" + NEW_LINE;
  private static final String BOUND_PRED_REGEX = "#(.*) >= (\\d*) && #(.*) <= (\\d*)";

  private EObject modelRoot;
  private SafeList<Sig> sigs;
  private boolean analyzeEnabled;
  private boolean saveEnabled;
  private int intPower = 1;
  private Text predText;
  private Button saveCheck;
  private Map<String, BoundItem> sig2item = new HashMap<>();
  private Map<String, String> traceCache = new HashMap<>();
  private Composite buttonContainer;
  private Text scopeSize;
  private Button scopeCheck;
  private Composite boundContainer;
  private Frame frame;
  private JPanel panel;

  protected BoundSelectionPage(EObject modelRoot, SafeList<Sig> sigs) {
    super("SelectEMFContainer");
    this.modelRoot = modelRoot;
    this.sigs = sigs;
    setTitle("Bound Selection");
    setDescription("Enter sig bounds");
    initSigBounds();
  }

  private void initSigBounds() {
    for (Sig sig : sigs) {
      String sigName = sig.label.replace("this/", "");
      int lower = 0, upper = DEFAULT_UPPER;
      if (sig.isOne != null) {
        lower = upper = 1;
      } else if (sig.isLone != null) {
        lower = 0;
        upper = 1;
      } else if (sig.isSome != null) {
        lower = 1;
        upper = DEFAULT_UPPER;
      }
      EClass sigClass = EcoreUtilities.findEClass(modelRoot, sigName);
      if (sigClass != null && !sigClass.isAbstract()) {
        BoundItem item = new BoundItem(sigName, lower, upper);
        item.setEClass(sigClass);
        sig2item.put(sigName, item);
        traceCache.put(sigClass.getName(), sigName);
      }
    }
  }

  @Override
  public void createControl(Composite parent) {
    final Composite topContainer = new Composite(parent, SWT.NONE);
    topContainer.setLayout(new org.eclipse.swt.layout.GridLayout(1, false));
    // Checkbox: save this pred
    saveCheck = new Button(topContainer, SWT.CHECK);
    saveCheck.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    saveCheck.setText("Save this bounds as");
    saveCheck.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        saveEnabled = saveCheck.getSelection();
        predText.setEnabled(saveEnabled);
      }
    });
    saveCheck.setSelection(false);

    // Textbox: pred name
    predText = new Text(topContainer, SWT.BORDER);
    predText.setMessage("Enter a name");
    predText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    predText.setEnabled(false);
    predText.addModifyListener(new ModifyListener() {

      @Override
      public void modifyText(ModifyEvent e) {
        setPageComplete(true);
      }
    });
    scopeCheck = new Button(topContainer, SWT.CHECK);
    scopeCheck.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    scopeCheck.setText("A generic model for number of elements:");
    scopeCheck.setSelection(false);
    scopeSize = new Text(topContainer, SWT.BORDER);
    scopeSize.setMessage("Enter number of elements");
    scopeSize.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    scopeSize.setEnabled(false);

    // Append the grid
    makeSigTable(topContainer);
    makeBottomButtons(topContainer);

    scopeCheck.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        scopeSize.setEnabled(scopeCheck.getSelection());
        boolean enabled = !scopeCheck.getSelection();
        setEnabledRecursive(panel, enabled);
        setEnabledRecursive(buttonContainer, enabled);
      }

    });
    setControl(topContainer);
  }

  public static void setEnabledRecursive(final Composite composite, final boolean enabled) {
    Control[] children = composite.getChildren();
    for (int i = 0; i < children.length; i++) {
      if (children[i] instanceof Composite) {
        setEnabledRecursive((Composite) children[i], enabled);
      } else {
        children[i].setEnabled(enabled);
      }
    }
    composite.setEnabled(enabled);
  }

  public static void setEnabledRecursive(final Container container, final boolean enabled) {
    Component[] children = container.getComponents();
    for (int i = 0; i < children.length; i++) {
      if (children[i] instanceof Container) {
        setEnabledRecursive((Container) children[i], enabled);
      } else {
        children[i].setEnabled(enabled);
      }
    }
    container.setEnabled(enabled);
  }

  private void makeBottomButtons(Composite container) {
    buttonContainer = new Composite(container, SWT.NONE);
    buttonContainer.setLayout(new org.eclipse.swt.layout.GridLayout(3, false));
    Button restoreButton = new Button(buttonContainer, SWT.PUSH);
    // restoreButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    restoreButton.setText("Restore Lower Bounds");
    restoreButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (BoundItem boundItem : sig2item.values()) {
          boundItem.setLower(boundItem.initLower);
          boundItem.setUpper(boundItem.initUpper);
          boundItem.updateValues();
        }
      }
    });

    Button incButton = new Button(buttonContainer, SWT.PUSH);
    // incButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    incButton.setText("Increment Lower Bounds");
    incButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (BoundItem boundItem : sig2item.values()) {
          boundItem.setLower(boundItem.getLower() + 1);
          boundItem.updateValues();
        }
      }
    });

    Button decButton = new Button(buttonContainer, SWT.PUSH);
    // decButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    decButton.setText("Decrement Lower Bounds");
    decButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (BoundItem boundItem : sig2item.values()) {
          boundItem.setLower(boundItem.getLower() - 1);
          boundItem.updateValues();
        }
      }
    });
    Button restoreUpperButton = new Button(buttonContainer, SWT.PUSH);
    // restoreButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    restoreUpperButton.setText("Restore Upper Bounds");
    restoreUpperButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (BoundItem boundItem : sig2item.values()) {
          boundItem.setLower(boundItem.initLower);
          boundItem.setUpper(boundItem.initUpper);
          boundItem.updateValues();
        }
      }
    });

    Button incUpperButton = new Button(buttonContainer, SWT.PUSH);
    // incButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    incUpperButton.setText("Increment Upper Bounds");
    incUpperButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (BoundItem boundItem : sig2item.values()) {
          boundItem.setUpper(boundItem.getUpper() + 1);
          boundItem.updateValues();
        }
      }
    });

    Button decUpperButton = new Button(buttonContainer, SWT.PUSH);
    // decButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    decUpperButton.setText("Decrement Upper Bounds");
    decUpperButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (BoundItem boundItem : sig2item.values()) {
          boundItem.setUpper(boundItem.getUpper() - 1);
          boundItem.updateValues();
        }
      }
    });
  }

  private void makeSigTable(final Composite topContainer) {
    boundContainer = new Composite(topContainer, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    boundContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    boundContainer.setLayout(new FillLayout());
    setTheme();
    frame = SWT_AWT.new_Frame(boundContainer);
    frame.setBackground(null);
    GridLayout layout = new GridLayout(0, 3);
    panel = new JPanel(layout);
    JLabel labelSig = new JLabel("Sig");
    JLabel labelLower = new JLabel("Lower Bound");
    JLabel labelUpper = new JLabel("Upper Bound");
    panel.add(labelSig);
    panel.add(labelLower);
    panel.add(labelUpper);
    for (Entry<String, BoundItem> entry : sig2item.entrySet()) {
      BoundItem boundItem = entry.getValue();
      String sigName = entry.getKey();
      JLabel sigLabel = new JLabel(sigName);
      SpinnerNumberModel lowerModel =
          new SpinnerNumberModel(boundItem.getLower(), boundItem.initLower, 1000, 1);
      SpinnerNumberModel upperModel =
          new SpinnerNumberModel(boundItem.getUpper(), boundItem.initLower, 1000, 1);
      JSpinner upper = new JSpinner(upperModel);
      JSpinner lower = new JSpinner(lowerModel);
      panel.add(sigLabel);
      panel.add(lower);
      panel.add(upper);
      lowerModel.addChangeListener(new ChangeListener() {
        int prevValue = boundItem.initLower;

        @Override
        public void stateChanged(ChangeEvent e) {
          int l = (int) lower.getValue();
          if (l > (int) upper.getValue()) {
            lowerModel.setValue(--l);
            return;
          }
          if (analyzeEnabled)
            analyzeBounds(sigName, l - prevValue, true);
          prevValue = l;
        }
      });
      upperModel.addChangeListener(new ChangeListener() {
        int prevValue = boundItem.initUpper;

        @Override
        public void stateChanged(ChangeEvent e) {
          int u = (int) upper.getValue();
          if (u < (int) lower.getValue()) {
            upperModel.setValue(++u);
            return;
          }
          updateInt(u);
          if (analyzeEnabled)
            analyzeBounds(sigName, u - prevValue, false);
          prevValue = u;
        }
      });
      boundItem.setLowerSpinner(lower);
      boundItem.setUpperSpinner(upper);
    }
    frame.add(panel, BorderLayout.CENTER);
  }

  private void analyzeBounds(String sigName, int inc, boolean lowerChanged) {
    BoundItem item = sig2item.get(sigName);
    if (item == null || inc == 0)
      return;

    for (EReference eRef : item.getEClass().getEReferences()) {
      String relSigName = traceCache.get(eRef.getEReferenceType().getName());
      BoundItem relBoundItem = sig2item.get(relSigName);
      int newUpper = relBoundItem.getUpper();
      int newLower = relBoundItem.getLower();

      if (lowerChanged && eRef.getLowerBound() > 0) {
        int change = eRef.getLowerBound() * inc;
        newLower = relBoundItem.getLower() + change;
        // TODO check this
        // if (relBoundItem.getLower() < (eRef.getLowerBound() * item.getSpinnerLower())) {
        // if (eRef.isContainment()) {
        // relBoundItem.setUpper(item.getSpinnerUpper() * inc
        // * (eRef.getUpperBound() < 1 ? 1 : eRef.getUpperBound()));
        // relBoundItem.setLower(item.getSpinnerLower() * change);
        // } else {
        // relBoundItem.setUpper(relBoundItem.getUpper() + change);
        // relBoundItem.setLower(relBoundItem.getLower() + change);
        // }
        // }
      } else if (!lowerChanged) {
        int change = eRef.getUpperBound() < 1 ? 1 : eRef.getUpperBound() * inc;
        newUpper = relBoundItem.getUpper() + change;
        // relBoundItem.setUpper(relBoundItem.getUpper() + change);
      }
      relBoundItem.setUpper(newUpper);
      relBoundItem.setLower(newLower);
      relBoundItem.updateValues();
    }
  }

  private void updateInt(int upperBound) {
    if (upperBound > Math.pow(2, intPower) - 1) {
      intPower = 32 - Integer.numberOfLeadingZeros(upperBound - 1);
    }
  }

  private void setTheme() {
    try {
      /*
       * TODO BUG
       * 
       * A Fatal Error occurs while setting GTK look and feel on Ubuntu 16.04
       * (com.sun.java.swing.plaf.gtk.GTKLookAndFeel).
       * 
       */
      final String LaF = UIManager.getSystemLookAndFeelClassName();
      if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(LaF)) {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } else {
        UIManager.setLookAndFeel(LaF);
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {
      e1.printStackTrace();
    }
  }

  public void setSelectedCommand(Command selectedCommand) {
    final Pattern boundPredPattern = Pattern.compile(BOUND_PRED_REGEX, Pattern.CASE_INSENSITIVE);
    predText.setText("");
    if (selectedCommand == null)
      return;

    predText.setText(selectedCommand.label);
    // saveCheck.setSelection(true);
    // saveEnabled = true;
    List<String> pred = getAlloyToEMF().getPredLines(selectedCommand.label);
    for (String line : pred) {
      Matcher matcher = boundPredPattern.matcher(line);
      if (matcher.matches() && matcher.group(1).equals(matcher.group(3))) {
        int lower = -1, upper = -1;
        String sigName = matcher.group(1);
        lower = Integer.parseInt(matcher.group(2));
        upper = Integer.parseInt(matcher.group(4));
        BoundItem item = sig2item.get(sigName);
        if (item != null) {
          item.setLower(lower);
          item.setUpper(upper);
        }
      }
    }
  }

  public String generatePredAndRun(String predName) {
    StringBuilder sb = new StringBuilder();
    sb.append("//" + predName + NEW_LINE);
    sb.append("pred " + predName + " {" + NEW_LINE);
    String scope = "";
    if (!scopeCheck.getSelection()) {
      for (Entry<String, BoundItem> entry : sig2item.entrySet()) {
        BoundItem boundItem = entry.getValue();
        if (boundItem.getLower() != boundItem.initLower
            || boundItem.getUpper() != boundItem.initUpper) {
          sb.append(String.format(PRED_FORMAT, boundItem.sigName, boundItem.getLower(),
              boundItem.sigName, boundItem.getUpper()));
          if (boundItem.getUpper() > DEFAULT_UPPER) {
            if (!scope.isEmpty())
              scope += ", ";
            scope += boundItem.getUpper() + " " + boundItem.sigName;
          }
        }
      }
    }
    sb.append("}" + NEW_LINE);
    if (!scopeCheck.getSelection())
      sb.append("run " + predName + " for " + DEFAULT_UPPER);
    else
      sb.append("run " + predName + " for " + Integer.parseInt(scopeSize.getText()));

    if (!scope.isEmpty()) {
      sb.append(" but " + scope);
      if (intPower > 1)
        sb.append(" ," + intPower + " Int");
    }
    sb.append(NEW_LINE + "//end" + NEW_LINE);
    return sb.toString();
  }

  @Override
  public boolean backPressed() {
    for (Entry<String, BoundItem> entry : sig2item.entrySet()) {
      entry.getValue().reset();
    }
    return super.backPressed();
  }

  @Override
  public boolean nextPressed() throws Exception {
    // if save enabled, make sure pred has a name that not starts with number
    if (saveEnabled && (Character.isDigit(getPredName().charAt(0)) || getPredName().isEmpty())) {
      predText.forceFocus();
      return false;
    }

    String predName = getPredName();
    if (!saveEnabled)
      predName = "temp_pred_name";

    A4Solution solution =
        getAlloyToEMF().executePred(predName, generatePredAndRun(predName), saveEnabled);
    if (solution != null) {
      AlloySolutionSelectionPage nextPage = (AlloySolutionSelectionPage) getNextPage();
      nextPage.setFirstSolution(solution);
      return true;
    } else {
      MessageDialog messageDialog = new MessageDialog(getShell(), "Error", null,
          "No instance found, try changing the bounds.", MessageDialog.INFORMATION, 0,
          new String[] {"OK"});
      messageDialog.open();
      return false;
    }
  }

  private String getPredName() {
    return predText.getText();
  }

}
