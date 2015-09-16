package org.bogbog.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class Equipment extends Composite {
	private Text notesValue;
	private Text goldValue;
	private Text equipmentValue;

	public Equipment(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		Group abilitiesNotesGroup = new Group(this, SWT.NONE);
		abilitiesNotesGroup.setLayout(new GridLayout(1, false));
		abilitiesNotesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1));
		abilitiesNotesGroup.setText("Abilities/Notes");

		notesValue = new Text(abilitiesNotesGroup, SWT.BORDER | SWT.WRAP
				| SWT.V_SCROLL);
		notesValue.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		Composite rightComposite = new Composite(this, SWT.NONE);
		rightComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		rightComposite.setLayout(new GridLayout(1, false));

		Group equipmentGroup = new Group(rightComposite, SWT.NONE);
		equipmentGroup.setLayout(new GridLayout(1, false));
		equipmentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		equipmentGroup.setText("Equipment");

		equipmentValue = new Text(equipmentGroup, SWT.BORDER | SWT.WRAP
				| SWT.V_SCROLL);
		equipmentValue.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));

		Composite goldComposite = new Composite(rightComposite, SWT.NONE);
		goldComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		goldComposite.setLayout(new GridLayout(2, false));

		Label goldLabel = new Label(goldComposite, SWT.NONE);
		goldLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		goldLabel.setText("Gold");

		goldValue = new Text(goldComposite, SWT.BORDER);
		goldValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
	}
}
