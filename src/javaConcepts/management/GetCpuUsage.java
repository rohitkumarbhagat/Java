package javaConcepts.management;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class GetCpuUsage {
	public static void main(String[] args) {
	
	 System.out.println(getJVMCpuTime());
	/** Get JVM CPU time in milliseconds */
	
}
	public static long getJVMCpuTime( ) {
	    OperatingSystemMXBean bean =
	        ManagementFactory.getOperatingSystemMXBean( );
	    if ( ! (bean instanceof com.sun.management.OperatingSystemMXBean) )
	        return 0L;
	    com.sun.management.OperatingSystemMXBean   bean1=(com.sun.management.OperatingSystemMXBean)bean;
	    System.out.println(bean1.getProcessCpuLoad());
	   System.out.println(bean1.getSystemCpuLoad()); 
	    return ((com.sun.management.OperatingSystemMXBean)bean)
	        .getProcessCpuTime( );
	}
}
