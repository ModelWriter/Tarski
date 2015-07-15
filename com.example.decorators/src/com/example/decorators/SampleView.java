package com.example.decorators;

import java.util.ArrayList;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class SampleView extends ViewPart {

	private Tree tree;

	public SampleView() {
	}

	@Override
	public void createPartControl(Composite parent) {

		TreeViewer treeViewer = new TreeViewer(parent, SWT.BORDER);
		tree = treeViewer.getTree();
		treeViewer.setContentProvider(new SampleTreeContentProvider());

		SampleTreeLabelProvider baseLabelprovider = new SampleTreeLabelProvider();
		ILabelDecorator decorator = PlatformUI.getWorkbench()
				.getDecoratorManager().getLabelDecorator();
		treeViewer.setLabelProvider(
				new DecoratingLabelProvider(baseLabelprovider, decorator));

		ArrayList<String> elements = new ArrayList<String>();
		elements.add("First entry");
		elements.add("2nd entry");
		elements.add("3rd entry");
		elements.add("My project");
		elements.add("Whatever this is");

		treeViewer.setInput(elements);
	}

	@Override
	public void setFocus() {
		tree.setFocus();
	}
}
