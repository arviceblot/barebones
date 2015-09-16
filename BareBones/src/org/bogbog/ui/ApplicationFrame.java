package org.bogbog.ui;

import org.bogbog.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class ApplicationFrame {

	private Shell shell;
	private Session session;

	public ApplicationFrame() {
		session = new Session();
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationFrame window = new ApplicationFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setLayout(new GridLayout(1, false));
		shell.setText("BareBones");

		TabFolder tabs = new TabFolder(shell, SWT.NONE);
		tabs.setLayout(new GridLayout());
		tabs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TabItem characterTab = new TabItem(tabs, SWT.NONE);
		characterTab.setText("Character");
		CharacterSheet characterSheet = new CharacterSheet(tabs, SWT.NONE,
				session);
		characterTab.setControl(characterSheet);

		TabItem equipmentTab = new TabItem(tabs, SWT.NONE);
		equipmentTab.setText("Equipment");
		Equipment equipment = new Equipment(tabs, SWT.NONE);
		equipmentTab.setControl(equipment);

		TabItem combatTab = new TabItem(tabs, SWT.NONE);
		combatTab.setText("Combat");
		Combat combat = new Combat(tabs, SWT.NONE);
		combatTab.setControl(combat);

		TabItem developmentTab = new TabItem(tabs, SWT.NONE);
		developmentTab.setText("Development");
		DevJournal development = new DevJournal(tabs, SWT.NONE);
		developmentTab.setControl(development);

		shell.setSize(800, 600);

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem fileMenuItem = new MenuItem(menu, SWT.CASCADE);
		fileMenuItem.setText("&File");

		Menu fileMenu = new Menu(fileMenuItem);
		fileMenuItem.setMenu(fileMenu);

		MenuItem newFile = new MenuItem(fileMenu, SWT.CASCADE);
		newFile.setText("&New");

		Menu newFileSubmenu = new Menu(newFile);
		newFile.setMenu(newFileSubmenu);

		MenuItem newCharacterMenu = new MenuItem(newFileSubmenu, SWT.NONE);
		newCharacterMenu.setText("Character");

		MenuItem newRaceMenu = new MenuItem(newFileSubmenu, SWT.NONE);
		newRaceMenu.setText("Race");

		MenuItem newClassMenu = new MenuItem(newFileSubmenu, SWT.NONE);
		newClassMenu.setText("Class");

		MenuItem openFile = new MenuItem(fileMenu, SWT.NONE);
		openFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog openDialog = new FileDialog(shell, SWT.OPEN);
				openDialog.setFilterNames(new String[] { "BBF Files (*.bbf)",
						"All Files (*.*)" });
				openDialog.setFilterExtensions(new String[] { "*.bbf", "*.*" });
				openDialog.setFilterPath("~/");
				Session.loadCharacter(openDialog.open());
				System.out.println("Open file: " + openDialog.open());
			}
		});
		openFile.setText("&Open");

		new MenuItem(fileMenu, SWT.SEPARATOR);

		MenuItem saveFile = new MenuItem(fileMenu, SWT.NONE);
		saveFile.setText("&Save");

		MenuItem saveFileAs = new MenuItem(fileMenu, SWT.NONE);
		saveFileAs.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog saveDialog = new FileDialog(shell, SWT.SAVE);
				saveDialog.setFilterNames(new String[] { "BBF Files (*.bbf)",
						"All Files (*.*)" });
				saveDialog.setFilterExtensions(new String[] { "*.bbf", "*.*" });
				saveDialog.setFilterPath("~/"); // linux path... but seems to
												// work on Windows as well
				saveDialog.setFileName("untitled.bbf");
				System.out.println("Save to: " + saveDialog.open());
			}
		});
		saveFileAs.setText("Save As...");

		new MenuItem(fileMenu, SWT.SEPARATOR);

		MenuItem mntmImport = new MenuItem(fileMenu, SWT.NONE);
		mntmImport.setText("Import...");

		MenuItem mntmExport = new MenuItem(fileMenu, SWT.NONE);
		mntmExport.setText("Export...");

		new MenuItem(fileMenu, SWT.SEPARATOR);

		MenuItem exitFile = new MenuItem(fileMenu, SWT.NONE);
		exitFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.getDisplay().dispose();
				System.exit(0);
			}
		});
		exitFile.setText("E&xit");

		MenuItem editMenuItem = new MenuItem(menu, SWT.CASCADE);
		editMenuItem.setText("&Edit");

		Menu editMenu = new Menu(editMenuItem);
		editMenuItem.setMenu(editMenu);

		MenuItem editPreferences = new MenuItem(editMenu, SWT.NONE);
		editPreferences.setText("Preferences");

		MenuItem helpMenuItem = new MenuItem(menu, SWT.CASCADE);
		helpMenuItem.setText("&Help");

		Menu helpMenu = new Menu(helpMenuItem);
		helpMenuItem.setMenu(helpMenu);

		MenuItem helpAbout = new MenuItem(helpMenu, SWT.NONE);
		helpAbout.setText("&About");
	}
}
