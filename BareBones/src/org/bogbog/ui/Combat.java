package org.bogbog.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Combat extends Composite {
	private Table spellsTable;
	private Table weaponsTable;

	Combat(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		spellsTable = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		spellsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		spellsTable.setHeaderVisible(true);
		spellsTable.setLinesVisible(true);

		TableColumn spellNameColumn = new TableColumn(spellsTable, SWT.NONE);
		spellNameColumn.setWidth(100);
		spellNameColumn.setText("Spell");

		TableColumn spellRangeColumn = new TableColumn(spellsTable, SWT.NONE);
		spellRangeColumn.setWidth(100);
		spellRangeColumn.setText("Range");

		TableColumn spellUsageColumn = new TableColumn(spellsTable, SWT.NONE);
		spellUsageColumn.setWidth(100);
		spellUsageColumn.setText("Usage");

		TableColumn spellDurationColumn = new TableColumn(spellsTable, SWT.NONE);
		spellDurationColumn.setWidth(100);
		spellDurationColumn.setText("Duration");

		TableColumn spellResistColumn = new TableColumn(spellsTable, SWT.NONE);
		spellResistColumn.setWidth(100);
		spellResistColumn.setText("Resist");

		TableColumn spellEffectColumn = new TableColumn(spellsTable, SWT.NONE);
		spellEffectColumn.setWidth(100);
		spellEffectColumn.setText("Effect");

		weaponsTable = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		weaponsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		weaponsTable.setHeaderVisible(true);
		weaponsTable.setLinesVisible(true);

		TableColumn weaponNameColumn = new TableColumn(weaponsTable, SWT.NONE);
		weaponNameColumn.setWidth(100);
		weaponNameColumn.setText("Weapon");

		TableColumn weaponRangeColumn = new TableColumn(weaponsTable, SWT.NONE);
		weaponRangeColumn.setWidth(100);
		weaponRangeColumn.setText("Range");

		TableColumn weaponScoreColumn = new TableColumn(weaponsTable, SWT.NONE);
		weaponScoreColumn.setWidth(100);
		weaponScoreColumn.setText("Score");

		TableColumn weaponDamageColumn = new TableColumn(weaponsTable, SWT.NONE);
		weaponDamageColumn.setWidth(100);
		weaponDamageColumn.setText("Damage");

		TableColumn weaponAmmoColumn = new TableColumn(weaponsTable, SWT.NONE);
		weaponAmmoColumn.setWidth(100);
		weaponAmmoColumn.setText("Ammo");

		TableColumn weaponNotesColumn = new TableColumn(weaponsTable, SWT.NONE);
		weaponNotesColumn.setWidth(100);
		weaponNotesColumn.setText("Notes");

		TableItem defaultUnarmedWeapon = new TableItem(weaponsTable, SWT.NONE);
		defaultUnarmedWeapon
				.setText(new String[] { "Unarmed", "--", "", "1D/2" });
	}
}
