package org.cytoscape.myApp.internal;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.cytoscape.application.swing.AbstractCyAction;
//import org.cytoscape.view.model.CyNetworkView;
//import org.cytoscape.work.TaskIterator;
//import org.cytoscape.work.swing.DialogTaskManager;
/**
 * CyRepo App
 * @author Sepideh Sadegh
 */
public class StartFuncY extends AbstractCyAction{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 4466283122745077648L;
	private RepoApplication app;
	
	public StartFuncY(RepoApplication app) {
		super("Run");
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Write your own function here.
		JOptionPane.showMessageDialog(null, "Welcome to REPO-TRIAL World!");
		
//	    CyNetworkView currentNetworkView = app.getCurrentNetworkView();
//	    
//	    // check if a network is selected
//	    if (currentNetworkView == null)
//	       return;
//	    
//		DialogTaskManager taskmanager = app.getActivator().getService(DialogTaskManager.class);
//		taskmanager.execute(new TaskIterator(new FuncYTask(app)));

	}

}
