package gaej2;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
	
	private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("GAEJ2");
	private PMF() {}
	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}
}
