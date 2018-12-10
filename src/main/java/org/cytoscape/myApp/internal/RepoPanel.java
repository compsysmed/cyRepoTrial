package org.cytoscape.myApp.internal;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.application.swing.CytoPanelState;
/**
 * CyRepo App
 * @author Sepideh Sadegh
 */
public class RepoPanel extends JPanel implements CytoPanelComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5531224818889834638L;
	private RepoApplication app;
	private JComboBox<String> criteria_option;
	private JTextArea result_area;
	private JScrollPane scrollPane_output;
	
	public RepoPanel(RepoApplication app) {
		super();
		this.app = app;
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel optionPanel = new JPanel();
		add(optionPanel);
		
		JLabel lblCriteria = new JLabel("Some criteria:");
		optionPanel.add(lblCriteria);
		
		criteria_option = new JComboBox<String>(new String[]{"criteria 1", "criteria 2", "criteria 3"});
		optionPanel.add(criteria_option);
		
		JPanel btnPanel = new JPanel();
		optionPanel.add(btnPanel);
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		
		JButton btnRunY = new JButton("Run function Y");
		btnRunY.addActionListener(new StartFuncY(app));
		btnPanel.add(btnRunY);
		
		JButton btnClose = new JButton("Close REPO panel");
		btnClose.addActionListener(new CloseRepoPanelAction(this));
		btnPanel.add(btnClose);
		
		scrollPane_output = new JScrollPane();
		scrollPane_output.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane_output);
		
		result_area = new JTextArea();
		result_area.setRows(HEIGHT);
		scrollPane_output.setBorder(BorderFactory.createTitledBorder("REPO results:"));
		scrollPane_output.setViewportView(result_area);
		result_area.setEditable(false);
	}

	public void activate() {
		// register
		this.app.getActivator().registerService(this, CytoPanelComponent.class);
		
		// focus on this panel
		CytoPanel cyto_panel = app.getCySwingApplication().getCytoPanel(getCytoPanelName());
		if (cyto_panel.getState() == CytoPanelState.HIDE) {
			cyto_panel.setState(CytoPanelState.DOCK);
		}
		
		setVisible(true);
		cyto_panel.setSelectedIndex(cyto_panel.indexOfComponent(getComponent()));
	}
	
	public void deactivate() {
		this.app.getActivator().unregisterAllServices(this);
		result_area.setText("");
		scrollPane_output.setBorder(BorderFactory.createTitledBorder("REPO results:"));
	}
	
	public String getCriteriaOption() {
		return String.valueOf(criteria_option.getSelectedItem());
	}
	
	public JTextArea getResultAreaTextArea() {
		return this.result_area;
	}
	
	public JScrollPane getOutputScrollPane() {
		return this.scrollPane_output;
	}
	
	@Override
	public Component getComponent() {
		return this;
	}

	@Override
	public CytoPanelName getCytoPanelName() {
		return CytoPanelName.WEST;
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getTitle() {
		return this.app.getAppName();
	}

}
