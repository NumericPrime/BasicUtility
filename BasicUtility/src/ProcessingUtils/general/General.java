package ProcessingUtils.general;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;

public class General {
	static PrintStream outp;
	static String classname(Object j) {
		return j.getClass().getSimpleName();
	}
	public static void mute() {
		outp=System.out;
		System.setOut(new PrintStream(new OutputStream() {
				public void write(int arg) {
					}
				}
		));
	}
	public static void unmute() {
		System.setOut(outp);
	}
	public static float[] randArray(int l) {
		float[] ret=new float[l];
		for(int i=0;i<l;i++) ret[i]=(float) Math.random();
		return ret;
	}
	public static float[] randArray(int l,float min,float max) {
		float[] ret=new float[l];
		for(int i=0;i<l;i++) ret[i]=min+(max-min)*((float) Math.random());
		return ret;
	}
	public static int[] randArrayInt(int l,int min,int max) {
		int[] ret=new int[l];
		for(int i=0;i<l;i++) ret[i]=min+(max-min)*((int) Math.random());
		return ret;
	}
	public static Object generateobj(Class<?> c) {
		  try {
		    return c.newInstance();
		  }
		  catch(Exception e) {
		    e.printStackTrace();
		    return null;
		  }
		}
		public static <T> void initArray(Class<T> c, Object array) {
		  if (array.getClass().isArray()) {
		    for (int i=0; i<Array.getLength(array); i++) {
		      if (Array.get(array, i)==null) Array.set(array, i, (T) generateobj(c));
		      else
		        initArray(c, Array.get(array, i));
		    }
		  }
		}
			public static <T> void callMethodArray(Class<T> c, Object array,String method) {
			  if (array.getClass().isArray()) {
			    for (int i=0; i<Array.getLength(array); i++) {
			    	  callMethodArray(c, Array.get(array, i),method);
			    }
			  }else {ClassAnalyser.call(array, method);}
			}
}
