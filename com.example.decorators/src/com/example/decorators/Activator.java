package com.example.decorators;

import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
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
				.addPartListener(new IPartListener() {
					@Override
					public void partActivated(IWorkbenchPart part) {
						if (part instanceof IEditorPart
								&& part instanceof EcoreEditor) {
							EcoreEditor eEditor = (EcoreEditor) part;
							TreeViewer viewer = (TreeViewer) eEditor
									.getViewer();

							ILabelDecorator decorator = getActiveWorkbenchWindow()
									.getWorkbench().getDecoratorManager()
									.getLabelDecorator();
							viewer.setLabelProvider(new DecoratingLabelProvider(
									(ILabelProvider) viewer.getLabelProvider(),
									decorator));
						}
					}

					@Override
					public void partBroughtToTop(IWorkbenchPart part) {

					}

					@Override
					public void partClosed(IWorkbenchPart part) {

					}

					@Override
					public void partDeactivated(IWorkbenchPart part) {

					}

					@Override
					public void partOpened(IWorkbenchPart part) {

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
