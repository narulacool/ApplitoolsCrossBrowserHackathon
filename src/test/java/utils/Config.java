package utils;

import java.util.HashMap;
import java.util.Map;

public class Config {

	public String fileNameV1 = "Traditional-V1-TestResults.txt";
	public String fileNameV2 = "Traditional-V2-TestResults.txt";
    
	public Map<Devices, String> viewPortSize = new HashMap<Devices, String>() {{
        put(Devices.LAPTOP, "1200x700");
        put(Devices.TABLET, "850x700");
        put(Devices.MOBILE, "500x700");
    }};
    
    public enum Browsers {
    	   CHROME,
    	   FIREFOX,
    	   EDGECHROMIUM,
    	}
    
    public enum Devices {
    	LAPTOP,
    	TABLET,
    	MOBILE,
 	}
    
}
