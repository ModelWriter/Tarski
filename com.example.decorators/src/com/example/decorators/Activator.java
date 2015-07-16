package com.example.decorators;

import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	// The shared instance
	private static Activator plugin;

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		getActiveWorkbenchWindow().getActivePage()
				.addPartListener(new IPartListener2() {
					@Override
					public void partActivated(IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub

					}

					@Override
					public void partBroughtToTop(
							IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub

					}

					@Override
					public void partClosed(IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub

					}

					@Override
					public void partDeactivated(
							IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub

					}

					@Override
					public void partOpened(IWorkbenchPartReference partRef) {
						if (partRef.getPart(false) instanceof IEditorPart
								&& partRef.getPart(
										false) instanceof EcoreEditor) {
							EcoreEditor eEditor = (EcoreEditor) partRef
									.getPart(false);
							TreeViewer viewer = (TreeViewer) eEditor
									.getViewer();

							ILabelDecorator decorator = getActiveWorkbenchWindow()
									.getWorkbench().getDecoratorManager()
									.getLabelDecorator();
							if (viewer
									.getLabelProvider() instanceof DecoratingLabelProvider) {
								return;
							} else {
								viewer.setLabelProvider(
										new DecoratingLabelProvider(
												(ILabelProvider) viewer
														.getLabelProvider(),
												decorator));
							}
						}

					}

					@Override
					public void partHidden(IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub

					}

					@Override
					public void partVisible(IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub
					}

					@Override
					public void partInputChanged(
							IWorkbenchPartReference partRef) {
						// TODO Auto-generated method stub

					}
				});
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);

	}

	public Activator() {

	}

	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}
}
