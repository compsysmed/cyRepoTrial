package org.cytoscape.myApp.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;

/**
 * CyRepo App
 * @author Sepideh Sadegh
 */
public class CloseRepoPanelAction extends AbstractCyAction{
	
//	private static final long serialVersionUID = -603427773732936948L;
	
	private RepoPanel panel;
	
	public CloseRepoPanelAction(RepoPanel panel) {
		super("Close");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.panel != null)
			this.panel.deactivate();
	}

}
