import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

//  -XX:+CreateCoredumpOnCrash
public class Test {
    public static void main(String[] args) {
		
		Sigar si = new Sigar();
		try {
			int num = si.getCpuList().length;
			System.out.println(num);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		  
		 
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}