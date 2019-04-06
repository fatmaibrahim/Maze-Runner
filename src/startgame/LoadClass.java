package startgame;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class LoadClass {
	
	
	
	private JarFile jarFile;

	public String excute(String path ,String nameimage) throws IOException, ClassNotFoundException{
	jarFile = new JarFile(path);
	Enumeration<JarEntry> e = jarFile.entries();
	while (e.hasMoreElements()) {    //e.hasMoreElements()
	    JarEntry je = e.nextElement();
	    if(je.isDirectory() || !je.getName().endsWith(".png")||!je.getName().contains(nameimage)){
		   continue;
	    }
	    return je.getName();
	}
	return null;
	}
}