import ProcessingUtils.WindowMaker.*;
import ProcessingUtils.error.*;
import ProcessingUtils.general.*;
import ProcessingUtils.inputs.*;
import ProcessingUtils.saveandcall.*;

InputManager im=new InputManager(this);
float r=750;
float alpha=20;
float beta=90;
void setup() {
  size(800, 800, P3D);
}
float intenc=0.06;
void draw() {
  frameRate(60);
  background(255);
  camera(r*cos(radians(alpha))*sin(radians(beta)), r*sin(radians(alpha))*sin(radians(beta)), r*cos(radians(beta)), 0, 0, 0, 0, 1, 0);
  box(30);
}
void mouseDragged() {
  //get the direction the mouse was dragged
  beta-=intenc*im.dragVector[0];
  alpha-=intenc*im.dragVector[1];
}
void mouseWheel(MouseEvent event) {
  r*=pow(1.01, 2*event.getCount());
  println(r);
}
void keyPressed() {
  //Reset the camera when crtl + r is pressed
  if (keyCode==82&&im.crtlPressed) {
    alpha=90;
    beta=20;
    r=750;
  }
}
/*
Aditional info provided by the InputManager
altPressed,shiftPressed

startMX,startMY position where you last pressed you mouse
normedDragVector drag vector with the length 1
dragLength length of the drag Vector

movementAsDrag(boolean val) Refresh the DragVector even if you arent pressing the mouse
*/