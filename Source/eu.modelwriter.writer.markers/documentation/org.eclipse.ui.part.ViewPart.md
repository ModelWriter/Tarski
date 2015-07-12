**org.eclipse.ui.part.ViewPart**

Abstract base implementation of all workbench views. 

This class should be subclassed by clients wishing to define new views. The name of the subclass should be given as the "class" attribute in a view extension contributed to the workbench's view extension point (named "org.eclipse.ui.views"). For example, the plug-in's XML markup might contain: 

 <extension point="org.eclipse.ui.views">
      <view id="com.example.myplugin.view"
         name="My View"
         class="com.example.myplugin.MyView"
         icon="images/eview.gif"
      />
 </extension>
 
where com.example.myplugin.MyView is the name of the ViewPart subclass. 

Subclasses must implement the following methods: 

 * createPartControl - to create the view's controls 
 * setFocus - to accept focus


Subclasses may extend or reimplement the following methods as required: 

 * setInitializationData - extend to provide additional initialization when view extension is instantiated
 * init(IWorkbenchPartSite) - extend to provide additional initialization when view is assigned its site
 * dispose - extend to provide additional cleanup
 * getAdapter - reimplement to make their view adaptable
