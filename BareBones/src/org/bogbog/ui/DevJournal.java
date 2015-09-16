package org.bogbog.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class DevJournal extends Composite {
	private Composite startedComposite;
	private Composite earnedComposite;
	private Composite spentComposite;
	private Text strValue;
	private Text devValue;
	private Text logValue;
	private Text wilValue;
	private Text skillsValue;
	private Text notesValue;
	private Table earnedTable;
	private Table spentTable;
	private Text advDateText;
	private Text advDPText;
	private Text advNotesText;
	private Text devDateText;
	private Text devDpText;
	private Text devDevText;
	private Text devNotesText;

	DevJournal(Composite parent, int style) {
		super(parent, style);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		setLayout(new GridLayout(1, false));

		startedComposite = new Composite(this, SWT.NONE);
		startedComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));
		startedComposite.setLayout(new GridLayout());

		Group startedGroup = new Group(startedComposite, SWT.SHADOW_IN);
		startedGroup.setLayout(new GridLayout(6, false));
		startedGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		startedGroup.setText("Where it all Started");

		Group strGroup = new Group(startedGroup, SWT.SHADOW_IN);
		strGroup.setLayout(new GridLayout());
		strGroup.setText("STR");

		strValue = new Text(strGroup, SWT.READ_ONLY);
		strValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group dexGroup = new Group(startedGroup, SWT.SHADOW_IN);
		dexGroup.setLayout(new GridLayout());
		dexGroup.setText("DEX");

		devValue = new Text(dexGroup, SWT.READ_ONLY);
		devValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group logGroup = new Group(startedGroup, SWT.SHADOW_IN);
		logGroup.setLayout(new GridLayout());
		logGroup.setText("LOG");

		logValue = new Text(logGroup, SWT.READ_ONLY);
		logValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group wilGroup = new Group(startedGroup, SWT.SHADOW_IN);
		wilGroup.setLayout(new GridLayout());
		wilGroup.setText("WIL");

		wilValue = new Text(wilGroup, SWT.READ_ONLY);
		wilValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group skillsGroup = new Group(startedGroup, SWT.NONE);
		skillsGroup.setText("Skills");
		skillsGroup.setLayout(new GridLayout(1, false));

		skillsValue = new Text(skillsGroup, SWT.READ_ONLY);
		skillsValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group notesGroup = new Group(startedGroup, SWT.NONE);
		notesGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		notesGroup.setText("Notes");
		notesGroup.setLayout(new GridLayout(1, false));

		notesValue = new Text(notesGroup, SWT.READ_ONLY);
		notesValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		earnedComposite = new Composite(this, SWT.NONE);
		earnedComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		earnedComposite.setLayout(new GridLayout());

		Group earnedGroup = new Group(earnedComposite, SWT.SHADOW_IN);
		earnedGroup.setLayout(new GridLayout());
		earnedGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		earnedGroup.setText("Adventure Log");

		earnedTable = new Table(earnedGroup, SWT.FULL_SELECTION);
		earnedTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		earnedTable.setHeaderVisible(true);
		earnedTable.setLinesVisible(true);

		TableColumn advDateColumn = new TableColumn(earnedTable, SWT.NONE);
		advDateColumn.setWidth(100);
		advDateColumn.setText("Date");

		TableColumn advDpEarnedColumn = new TableColumn(earnedTable, SWT.NONE);
		advDpEarnedColumn.setWidth(100);
		advDpEarnedColumn.setText("DP Earned");

		TableColumn advNotesColumn = new TableColumn(earnedTable, SWT.NONE);
		advNotesColumn.setWidth(159);
		advNotesColumn.setText("Adventuring Notes");

		Composite earnedTableComposite = new Composite(earnedGroup, SWT.NONE);
		earnedTableComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		earnedTableComposite.setLayout(new GridLayout(4, false));

		advDateText = new Text(earnedTableComposite, SWT.BORDER);

		advDPText = new Text(earnedTableComposite, SWT.BORDER);

		advNotesText = new Text(earnedTableComposite, SWT.BORDER);
		advNotesText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button advAddButton = new Button(earnedTableComposite, SWT.NONE);
		advAddButton.setAlignment(SWT.CENTER);
		advAddButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// replace this with a wizard for earning DP?
				if (!advDPText.getText().equals("")) {
					TableItem item = new TableItem(earnedTable, SWT.NONE);
					item.setText(new String[] { advDateText.getText(),
							advDPText.getText(), advNotesText.getText() });
					advDateText.setText("");
					advDPText.setText("");
					advNotesText.setText("");
				}
			}
		});
		advAddButton.setText("Add");

		spentComposite = new Composite(this, SWT.NONE);
		spentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		spentComposite.setLayout(new GridLayout());

		Group spentGroup = new Group(spentComposite, SWT.SHADOW_IN);
		GridLayout gl_spentGroup = new GridLayout();
		spentGroup.setLayout(gl_spentGroup);
		spentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		spentGroup.setText("Development Log");

		spentTable = new Table(spentGroup, SWT.FULL_SELECTION);
		spentTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		spentTable.setHeaderVisible(true);
		spentTable.setLinesVisible(true);

		TableColumn devDateColumn = new TableColumn(spentTable, SWT.NONE);
		devDateColumn.setWidth(100);
		devDateColumn.setText("Date");

		TableColumn devSpentColumn = new TableColumn(spentTable, SWT.NONE);
		devSpentColumn.setWidth(100);
		devSpentColumn.setText("DP Spent");

		TableColumn devDevelopedColumn = new TableColumn(spentTable, SWT.NONE);
		devDevelopedColumn.setWidth(100);
		devDevelopedColumn.setText("Developed");

		TableColumn devNotesColumn = new TableColumn(spentTable, SWT.NONE);
		devNotesColumn.setWidth(153);
		devNotesColumn.setText("Development Notes");

		Composite spentTableComposite = new Composite(spentGroup, SWT.NONE);
		spentTableComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		spentTableComposite.setLayout(new GridLayout(5, false));

		devDateText = new Text(spentTableComposite, SWT.BORDER);

		devDpText = new Text(spentTableComposite, SWT.BORDER);

		devDevText = new Text(spentTableComposite, SWT.BORDER);

		devNotesText = new Text(spentTableComposite, SWT.BORDER);
		devNotesText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button devAddButton = new Button(spentTableComposite, SWT.NONE);
		devAddButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// replace this with a wizard for spending DP?
				if (!(devDpText.getText().equals("") || devDevText.getText()
						.equals(""))) {
					TableItem item = new TableItem(spentTable, SWT.NONE);
					item.setText(new String[] { devDateText.getText(),
							devDpText.getText(), devDevText.getText(),
							devNotesText.getText() });
					devDateText.setText("");
					devDpText.setText("");
					devDevText.setText("");
					devNotesText.setText("");
				}
			}
		});
		devAddButton.setText("Add");
	}
}
