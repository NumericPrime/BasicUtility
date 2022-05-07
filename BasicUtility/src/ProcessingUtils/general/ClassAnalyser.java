package ProcessingUtils.general;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ProcessingUtils.saveandcall.Serialization;

public class ClassAnalyser {
	public static String lookInto(Object j) {
		return Serialization.info(j);
	}
	public static String classname(Object j) {
		return j.getClass().getSimpleName();
	}
	public static void call(Object ob, String method) {
		  try {
		    Method functions=ob.getClass().getMethod(method,new Class[]{});
		    functions.setAccessible(true);
		    functions.invoke(ob,new Object[]{});
		  }
		  catch(Exception e) {
		  }
		}
	public static boolean check(Object ob, String method) {
		  try {
		    Method functions=ob.getClass().getMethod(method,new Class[]{});
		    return true;
		  }
		  catch(Exception e) {
			  return false;
		  }
		}
	public static String[][] fields(Object j){
		Field[] field_=j.getClass().getDeclaredFields();
		String[][] ret=new String[field_.length][3];
		for(int i=0;i<field_.length;i++) {
			field_[i].setAccessible(true);
			try {
				if(field_[i].get(j)!=null) ret[i]=new String[] {field_[i].get(j).getClass().getSimpleName(),field_[i].getName(),field_[i].get(j).toString()};
				else  ret[i]=new String[] {"null", field_[i].getName(), "null"};
			      
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	public static String[] methods(Object j){
		Method[] method_=j.getClass().getDeclaredMethods();
		String[] ret=new String[method_.length];
		for(int i=0;i<method_.length;i++) {
			method_[i].setAccessible(true);
			try {
				if(method_[i]!=null) ret[i]=method_[i].toGenericString();
				else  ret[i]="null";
			      
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	public static Object[] fieldVals(Object j){
		Field[] field_=j.getClass().getDeclaredFields();
		Object[] ret=new Object[field_.length];
		for(int i=0;i<field_.length;i++) {
			field_[i].setAccessible(true);
			try {
				ret[i]=field_[i].get(j);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	public static void override(Object j,String target, int x) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			overr.setInt(j, x);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Object extract(Object j,String target) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			return overr.get(j);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {return null;}
	}
	public static void override(Object j,String target, long x) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			overr.setLong(j, x);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void override(Object j,String target, Object x) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			overr.set(j, x);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void override(Object j,String target, byte x) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			overr.setByte(j, x);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Object get(Object j,String target) {try {
		Field overr=j.getClass().getDeclaredField(target);
		overr.setAccessible(true);
		overr.get(j);
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {return null;}
		
	}
	public static void override(Object j,String target, float x) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			overr.setFloat(j, x);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void override(Object j,String target, double x) {
		try {
			Field overr=j.getClass().getDeclaredField(target);
			overr.setAccessible(true);
			overr.setDouble(j, x);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int maxDepth=20;
	public static void printAllFields(Object j) {
		String[][] t=fields(j);
		for(int i=0;i<t.length;i++) System.out.println(t[i][0]+" "+t[i][1]+" "+t[i][2]);
	}
	public static StringWriter out=new StringWriter();
	public static PrintWriter ps=new PrintWriter(out);
	public static String fullSerialize(Object ob){out=new StringWriter();ps=new PrintWriter(out);
	ps.println(ob.getClass().getSimpleName()+"::");
	fullSerialize(ob,0);
	return out.toString();
	}
	public static void fullSerialize(Object ob, int offset) {
	  String offs="";
	  for (int i=0; i<offset; i++) offs+=" ";if(offset<maxDepth) {
	  //check if array
	  if (ob.getClass().isArray()) {
	    ps.println(offs+ob.getClass().getSimpleName()+":");
	    for (int i=0;i<Array.getLength(ob);i++) {
	      fullSerialize(Array.get(ob,i), offset+1);
	    }
	  } else if (ob==null||ob instanceof Number||ob instanceof String) {
	    ps.println(offs+ob.getClass().getSimpleName()+","+ ob);
	  } else {
	    String[][] fields=ClassAnalyser.fields(ob);
	    Object[] fi=ClassAnalyser.fieldVals(ob);
	    for (int i=0; i<fields.length-1; i++) {
	      if (fi[i]==null||fi[i] instanceof Number||fi[i] instanceof String) {
	        ps.println(offs+fields[i][0]+","+ fields[i][1]+","+ fi[i]);
	      } else {

	        ps.println(offs+fields[i][0]+","+ fields[i][1]+":");

	        fullSerialize(fi[i], offset+1);
	      }
	    }
	  }
	}else{System.out.println(offs+"...");}}
}
