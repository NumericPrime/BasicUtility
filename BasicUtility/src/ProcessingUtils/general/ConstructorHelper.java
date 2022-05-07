package ProcessingUtils.general;

public class ConstructorHelper {
	static boolean autoCheck=true;
	static boolean cutLength=false;
	public static <T, L> void constructorCreator(T ret, String vars, L... args) {
		    String fieldnames[]=vars.split(" ");
		    if(cutLength&&autoCheck&&args.length>fieldnames.length) 
		    	System.err.println("To many inputs given, cutting at the "+fieldnames.length+" entry.");
		    if(autoCheck&&!cutLength) checkValidLength(args,0,fieldnames.length);
		    for (int i=0; i<args.length&&(!cutLength||i<fieldnames.length); i++) ClassAnalyser.override(ret, fieldnames[i], args[i]);
		  } 
	public  static <T,L> void manipulate(T ret, String vars, L... args) {
		    /*String fieldnames[]=vars.split(" ");
		    if(autoCheck) checkValidLength(args,0,fieldnames.length);
		    for (int i=0; i<args.length; i++) ClassAnalyser.override(ret, fieldnames[i], args[i]);
		  */
		constructorCreator(ret,vars,args);}
	public static <T> void checkValidLength(T[] input,int minLength) {
		if(input.length<minLength) throw new InvalidInputException("You need at least "+minLength+" inputs. Current inputs: "+input.length);
	}
	public static <T> void checkValidLength(T[] input,int minLength,int maxLength) {
		if(input.length<minLength) throw new InvalidInputException("You need at least "+minLength+" inputs. Current inputs: "+input.length);
		if(input.length>maxLength) throw new InvalidInputException("You can have at most "+maxLength+" inputs. Current inputs: "+input.length);
	}
	public static void autoCheckLength(boolean val) {
		autoCheck=val;
	}
	public static void autoCutLength(boolean val) {
		cutLength=val;
	}
}
