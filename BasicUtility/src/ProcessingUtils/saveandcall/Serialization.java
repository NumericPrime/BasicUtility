package ProcessingUtils.saveandcall;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import ProcessingUtils.general.ClassAnalyser;

public class Serialization{


public static void serializeObject(Object ob) {
  //println(sketchPath()+"\\data\\data.txt");
  try {
    FileOutputStream fileout=new FileOutputStream(standardFileOut);
    ObjectOutputStream out=new ObjectOutputStream(fileout);
    out.writeObject(ob);
    out.close();
    System.out.println("Fertig");
  }
  catch(IOException e) {
    e.printStackTrace();
  }
}
public static String standardFileOut="D:\\SerData.txt";
public static void setRoot(String filePath) {
	standardFileOut=filePath;
}
public static Object deserializeObject(String filepath) {
	Object r=null;
	try {
		FileInputStream fileout=new FileInputStream(filepath);
	    ObjectInputStream out=new ObjectInputStream(fileout);
	    r=out.readObject();
	    out.close();
	  }
	  catch(IOException e) {
	    e.printStackTrace();
	  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {return r;}
}

public static void serializeObject(Object ob,String filePath) {
  //println(sketchPath()+"\\data\\data.txt");
  try {
    FileOutputStream fileout=new FileOutputStream(filePath);
    ObjectOutputStream out=new ObjectOutputStream(fileout);
    out.writeObject(ob);
    out.close();
    System.out.println("Fertig");
  }
  catch(IOException e) {
    e.printStackTrace();
  }
}


public static StringWriter out=new StringWriter();
public static PrintWriter ps=new PrintWriter(out);
public static String info(Object ob){
	out=new StringWriter();ps=new PrintWriter(out);
ps.println(ob.getClass().getSimpleName()+"::");
info(ob,0);
return out.toString();
}
public static void info(Object ob, int offset) {
  String offs="";
  for (int i=0; i<offset; i++) offs+=" ";
  assert offset<9;
  //check if array
  if (ob.getClass().isArray()) {
    ps.println(offs+ob.getClass().getSimpleName()+":");
    for (int i=0;i<Array.getLength(ob);i++) {
    	info(Array.get(ob,i), offset+1);
    }
  } else if (ob==null||ob instanceof Number||ob instanceof String) {
    ps.println(offs+ob.getClass().getSimpleName()+","+ ob);
  } else {
    String[][] fields=ClassAnalyser.fields(ob);
    Object[] fi=ClassAnalyser.fieldVals(ob);
    for (int i=0; i<fields.length; i++) {
      if (fi[i]==null||fi[i] instanceof Number||fi[i] instanceof String) {
        ps.println(offs+fields[i][0]+","+ fields[i][1]+","+ fi[i]);
      } else {

        ps.println(offs+fields[i][0]+","+ fields[i][1]+":");

        info(fi[i], offset+1);
      }
    }
  }
}

public static String infoCallable(Object ob){out=new StringWriter();ps=new PrintWriter(out);
ps.println(ob.getClass().getSimpleName());
infoCallable(ob,0);
return out.toString();
}
public static void infoCallable(Object ob, int offset) {
  assert offset<9;
  //check if array
  if (ob.getClass().isArray()) {
    ps.println(offset+"-a-"+ob.getClass().getSimpleName()+"-"+Array.getLength(ob));
    for (int i=0;i<Array.getLength(ob);i++) {
    	infoCallable(Array.get(ob,i), offset+1);
    }
  } else if (ob==null||ob instanceof Number||ob instanceof String) {
    ps.println(offset+"-f-"+ob.getClass().getSimpleName()+","+ ob);
  } else {
    String[][] fields=ClassAnalyser.fields(ob);
    Object[] fi=ClassAnalyser.fieldVals(ob);
    for (int i=0; i<fields.length-1; i++) {
      if (fi[i]==null||fi[i] instanceof Number||fi[i] instanceof String) {
        ps.println(offset+"-f-"+fields[i][0]+","+ fields[i][1]+","+ fi[i]);
      } else {

        ps.println(offset+"-f-"+fields[i][0]+","+ fields[i][1]);

        infoCallable(fi[i], offset+1);
      }
    }
  }
}
}
