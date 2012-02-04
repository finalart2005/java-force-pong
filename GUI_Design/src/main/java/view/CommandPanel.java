package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import listeners.CommandPanelListener;

public class CommandPanel extends JPanel {
	public Window		window;

	public JPanel		buttonBox;
	public JButton		button;
	public JSpinner		spinner;
	public JCheckBox	checkBox;

	public CommandPanel(Window window) {
		this.window = window;

		setLayout(new FlowLayout());

		buttonBox = new JPanel(new FlowLayout());

		button = new JButton("Button");
		button.addActionListener(new CommandPanelListener(this));
		buttonBox.add(button);

		this.add(buttonBox);

		SpinnerNumberModel numSectionsSpinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
		spinner = new JSpinner(numSectionsSpinnerModel);
		spinner.addChangeListener(new CommandPanelListener(this));
		this.add(spinner);

		checkBox = new JCheckBox("Checkbox");
		checkBox.setSelected(false);
		checkBox.addItemListener(new CommandPanelListener(this));
		this.add(checkBox);
	}
}
