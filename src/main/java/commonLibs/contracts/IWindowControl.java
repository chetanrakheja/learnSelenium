package commonLibs.contracts;

import java.util.Set;

public interface IWindowControl {

	
	public void switchToAnyWindow(String windowhandle) throws Exception;

	public void switchToAnyWindow(int childWindowIndex) throws Exception;

	public String getWindowHandle() throws Exception;

	public Set<String> getWindowHandles() throws Exception;

	
	
}
