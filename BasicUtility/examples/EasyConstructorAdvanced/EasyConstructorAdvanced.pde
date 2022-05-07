import ProcessingUtils.general.*;
Ellipse e1,e2,e3;
void setup() {
  size(300,300);
  //Sometimes it might be a good ideo to not allow the contructor
  //to have less than a certain number of inputs if I called the constructor with
  //new Ellipse(x,y); it would throw an Exeption
  e1=new Ellipse((int)random(0,width),(int)random(0,height),(int)random(5,20),(int)random(5,20));
  e2=new Ellipse((int)random(0,width),(int)random(0,height),(int)random(5,20),(int)random(5,20),(int) random(0,255),(int) random(0,255),(int) random(0,255));
  
  //There is also the posibility of having too many inputs. The constructor helper allows cutting too long inputs when enabled
  //This option is disabled by default
  ConstructorHelper.autoCutLength(true);
  //Additionally you can automaticly report too many inputs. It automaticly writes if something is wrong 
  //and automaticly throws an exception if the length is cut
  //This option is enabled by default
  ConstructorHelper.autoCheckLength(true);
  //Feel free to play around with the options and see how this too long constructor is handled
  e3=new Ellipse(150,150,30,30,100,200,0,0,1,2,3,4);
}
void draw(){
  background(255);
  e1.paint();
  e2.paint();
  e3.paint();
}