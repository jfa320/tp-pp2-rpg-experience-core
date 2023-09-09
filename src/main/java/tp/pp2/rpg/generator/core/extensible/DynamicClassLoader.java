package tp.pp2.rpg.generator.core.extensible;

import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader extends URLClassLoader {
	public DynamicClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}
}