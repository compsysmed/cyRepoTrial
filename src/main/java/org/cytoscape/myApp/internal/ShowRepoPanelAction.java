package org.cytoscape.myApp.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;
/**
 * CyRepo App
 * @author Sepideh Sadegh
 */
public class ShowRepoPanelAction extends AbstractCyAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8122393159111330372L;
	
	private RepoPanel panel;
	
	public ShowRepoPanelAction(RepoPanel panel) {
		super("Start");
		setPreferredMenu("Apps.CyRepo");
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.panel != null)
			this.panel.activate();
	}


}
