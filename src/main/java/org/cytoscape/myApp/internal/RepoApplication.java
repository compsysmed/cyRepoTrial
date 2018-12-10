package org.cytoscape.myApp.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewManager;
/**
 * CyRepo App
 * @author Sepideh Sadegh
 */
public class RepoApplication {
	private CyActivator activator;
	private CySwingApplication application;
	private RepoPanel panel;
	private String app_name = "cyRepo";
	private String version = "1.0-test";
	
	public RepoApplication(CyActivator activator) {
		this.activator = activator;
		this.application = activator.getService(CySwingApplication.class);
		this.panel = new RepoPanel(this);
		
		this.application.addAction(new ShowRepoPanelAction(panel));
//		this.application.addAction(new RepoAboutAction(this));
	}
	
	
	/*
	 * Cytoscape-specific helper functions
	 */
	
	public CyApplicationManager getApplicationManager() {
		return activator.getService(CyApplicationManager.class);
	}
	
	public CyNetwork getCurrentNetwork() {
		return getApplicationManager().getCurrentNetwork();
	}
	
	public CyNetworkView getCurrentNetworkView() {
		return getApplicationManager().getCurrentNetworkView();
	}
	
	public CyNetworkViewManager getNetworkViewManager() {
		return activator.getService(CyNetworkViewManager.class);
	}
	
	/*
	 * Standard getters
	 */
	
	public CyActivator getActivator() {
		return activator;
	}

	public CySwingApplication getCySwingApplication() {
		return application;
	}

//	public CyrepoPanel getPanel() {
//		return panel;
//	}

	public String getAppName() {
		return app_name;
	}
	
	public String getVersion() {
		return version;
	}
}
