package ProcessingUtils.inputs;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class InputManager {
	public boolean moveisdrag=false;
	public boolean crtlPressed=false;
	public boolean shiftPressed=false;
	public boolean altPressed=false;
	public PApplet ref;
	public int startMX,startMY;
	public int beginDragMX,beginDragMY;
	public int dragVector[]= {0,0};
	public float normedDragVector[]= {0,0};
	float dragLength=0;
	public InputManager() {
	}
	public InputManager(PApplet ref) {
		setup(ref);
	}
	public void setup(PApplet ref) {
		 ref.registerMethod("keyEvent", this);
		 ref.registerMethod("mouseEvent", this);
	}	
	public void keyP(KeyEvent evt) {
		 if(evt.getKeyCode()==PConstants.CONTROL) crtlPressed=true;
		 if(evt.getKeyCode()==PConstants.SHIFT) shiftPressed=true;
		 if(evt.getKeyCode()==PConstants.ALT) altPressed=true;
	}
	public void keyR(KeyEvent evt) {
	    if(evt.getKeyCode()==PConstants.CONTROL) crtlPressed=false;
		 if(evt.getKeyCode()==PConstants.SHIFT) shiftPressed=false;
		 if(evt.getKeyCode()==PConstants.ALT) altPressed=false;
	}
	public void keyEvent(final KeyEvent evt){
	  if(evt.getAction()==KeyEvent.PRESS) keyP(evt);
	  if(evt.getAction()==KeyEvent.RELEASE) keyR(evt);
	  }
	public void mouseP(final MouseEvent evt) {
		startMX=evt.getX();
		startMY=evt.getY();
		beginDragMX=evt.getX();
		beginDragMY=evt.getY();
	}
	public void mouseR(final MouseEvent evt) {}
	public void mouseD(final MouseEvent evt) {
		dragVector[0]=evt.getX()-beginDragMX;
		dragVector[1]=evt.getY()-beginDragMY;
		
		float dst=PApplet.dist(0, 0, dragVector[0],  dragVector[1]);
		if(dst==0) dst=1;
		normedDragVector[0]=((float)dragVector[0])/dst;
		normedDragVector[1]=((float)dragVector[1])/dst;
		dragLength=dst;
		beginDragMX=evt.getX();
		beginDragMY=evt.getY();
	}
	public void mouseEvent(final MouseEvent evt) {
		if(evt.getAction()==MouseEvent.PRESS) mouseP(evt);
		if(evt.getAction()==MouseEvent.DRAG) mouseD(evt);
		if(moveisdrag) if(evt.getAction()==MouseEvent.MOVE) mouseD(evt);
	}
	public void movementAsDrag(boolean val) {
		moveisdrag=val;
	}

}
