package org.cytoscape.myApp.internal;

import java.util.Properties;

//import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.osgi.framework.BundleContext;
/**
 * CyRepo App
 * @author Sepideh Sadegh
 */
public class CyActivator extends AbstractCyActivator {

	private BundleContext context;
	private CyServiceRegistrar registrar;
	
	public CyActivator() {
		super();
	}
	
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		this.context = context;
		this.registrar = this.getService(CyServiceRegistrar.class);
		
		// start actual application
		registerService(new RepoApplication(this), RepoApplication.class);
		
/*		CyApplicationManager cyApplicationManager = getService(context, CyApplicationManager.class);
		
		MenuAction action = new MenuAction(cyApplicationManager, "cyRepo-test");
		
		Properties properties = new Properties();
		
		registerAllServices(context, action, properties);*/
		
	}
	
	 /*
	  * service-related functions
	  */
	
	public <S> S getService(Class<S> cls) {
		return this.getService(this.context, cls);
	}
	
	public <S> S getService(Class<S> cls, String properties) {
		return this.getService(this.context, cls, properties);
	}
	
	public <S> void registerService(S obj, Class<S> cls) {
		registrar.registerService(obj, cls, new Properties());
	}
	
	public void registerService(Object obj, Class<?> cls, Properties properties) {
		registrar.registerService(obj, cls, properties);
	}
	
	public <S> void unregisterService(S obj, Class<S> cls) {
		registrar.unregisterService(obj, cls);
	}
	
	public <S> void unregisterAllServices(S obj) {
		registrar.unregisterAllServices(obj);
	}

}
