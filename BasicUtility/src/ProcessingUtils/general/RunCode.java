package ProcessingUtils.general;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class RunCode {
	public static File root;
	public RunCode() {
		// TODO Auto-generated constructor stub
	}
	public static void setRoot(String path) {
		root=new File(path);
	}
	public static void run(String code) {
	  try {
	  String source = code;
	    // Save source in .java file. // On Windows running on C:\, this is C:\java.
	    File sourceFile = new File(root, "CompiledProgram.java");
	    sourceFile.getParentFile().mkdirs();
	    Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));

	    // Compile source file.
	    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	    Class<?> cls = null ;
	    compiler.run(null, null, null, sourceFile.getPath());
	    // Load and instantiate compiled class.
	    URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
	    cls = Class.forName("CompiledProgram", true, classLoader);

	    Object instance=cls.newInstance();
	    //if(errorm.length()>=1) JOptionPane.showMessageDialog(null, errorm,"Errors",JOptionPane.ERROR_MESSAGE);
	  }
	  catch(Exception e) {
	    e.printStackTrace();
	  }
	}
}
