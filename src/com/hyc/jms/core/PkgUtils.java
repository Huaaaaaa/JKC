package com.hyc.jms.core;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 查找某个包下面的消费者处理类
 * 
 * @author huayingcao
 *
 */
public class PkgUtils {
	public static List<Class<? extends MessagerHandler>> getClassUnderPkg(
			String path) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL url = classLoader.getResource(path.replace(".", "/"));
		return getClasses(new File(url.getFile()), path);
	}

	/**
	 * 获取指定包下面的所有类
	 * 
	 * @param path
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public static List getClsses(String path) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL url = classLoader.getResource(path.replace(".", "/"));
		return getClasses(new File(url.getFile()), path);

	}

	/**
	 * 获取当前类路径下的所有类
	 * 
	 * @param cls
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public static List getClasses(Class cls) throws ClassNotFoundException {
		String pkg = cls.getPackage().getName();
		String path = pkg.replace(".", "/");
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL url = classLoader.getResource(path);
		return getClasses(new File(url.getFile()), path);

	}

	@SuppressWarnings("unchecked")
	public static List getClasses(File dir, String pkg)
			throws ClassNotFoundException {
		List classList = new ArrayList();
		if (!dir.exists()) {
			return classList;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classList.addAll(getClasses(f, pkg + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				classList.add(Class.forName(pkg + "."
						+ name.substring(0, name.length() - 6)));
			}
		}
		return classList;
	}
}
