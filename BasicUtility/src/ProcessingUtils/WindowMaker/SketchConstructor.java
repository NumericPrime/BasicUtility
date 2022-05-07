package ProcessingUtils.WindowMaker;

import java.util.ArrayList;

import ProcessingUtils.general.ClassAnalyser;
import processing.core.PApplet;

public class SketchConstructor {

	public SketchConstructor() {
		// TODO Auto-generated constructor stub
	}
	static ArrayList<String> methods(){
		ArrayList<String> ret=new ArrayList();
		ret.add("settings");
		ret.add("setup");
		ret.add("keyPressed");
		ret.add("draw");
		ret.add("mousePressed");
		ret.add("mouseDragged");
		ret.add("mouseReleased");
		ret.add("keyTyped");
		ret.add("keyReleased");
		return ret;
		
	}
	public static PApplet createSketch(final BasicTemplate reference) {
		PApplet child=new PApplet() {Object ref=reference;
	    public void settings() {
	    	reference.settings();
	    }
	    public void setup() {
	    	reference.setup();
	    }
	    public void draw() {
	    	reference.draw();
	    }
	    public void keyPressed() {
		   ClassAnalyser.call(ref, "keyPressed");
	    }
	    public void mousePressed() {
		   ClassAnalyser.call(ref, "mousePressed");
	    }
	    public void mouseDragged() {
		   ClassAnalyser.call(ref, "mouseDragged");
	    }
	    public void mouseReleased() {
		   ClassAnalyser.call(ref, "mouseReleased");
	    }
	    public void keyTyped() {
		   ClassAnalyser.call(ref, "keyTyped");
	    }
	    public void keyReleased() {
		   ClassAnalyser.call(ref, "keyReleased");
	    }
	  };
	  PApplet.runSketch(new String[]{"WindowTwo"}, child);
	  try{child.getSurface().setTitle(reference.programName);}catch(Exception e) {}
return child;
	}
	public static void start(BasicTemplate program) {
		if(program instanceof PApplet) {
		PApplet.runSketch(new String[]{program.programName}, (PApplet) program);
		try{((PApplet)program).getSurface().setTitle(program.programName);}catch(Exception e) {}
			}
		
		else throw new NoPAppletException("The Template is not part of a PApplet add \"extends PApplet\" after declaring the class.");
	}
	/*public static PApplet createSketch(final Object reference) {
		  PApplet child=new PApplet() {Object ref=reference;
			    public void settings() {
			      ClassAnalyser.call(ref, "settings");
			    }
			    public void setup() {
				   ClassAnalyser.call(ref, "setup");
			    }
			    public void draw() {
				   ClassAnalyser.call(ref, "draw");
			    }
			    public void keyPressed() {
				   ClassAnalyser.call(ref, "keyPressed");
			    }
			    public void mousePressed() {
				   ClassAnalyser.call(ref, "mousePressed");
			    }
			    public void mouseDragged() {
				   ClassAnalyser.call(ref, "mouseDragged");
			    }
			    public void mouseReleased() {
				   ClassAnalyser.call(ref, "mouseReleased");
			    }
			    public void keyTyped() {
				   ClassAnalyser.call(ref, "keyTyped");
			    }
			    public void keyReleased() {
				   ClassAnalyser.call(ref, "keyReleased");
			    }
			  };
			  PApplet.runSketch(new String[]{"WindowTwo"}, child);
			  try{child.getSurface().setTitle((String) ClassAnalyser.extract(reference, "name"));}catch(Exception e) {}
		return child;
		
		
	}*/

}
