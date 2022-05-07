import ProcessingUtils.WindowMaker.*;
import ProcessingUtils.error.*;
import ProcessingUtils.general.*;
import ProcessingUtils.saveandcall.*;

AClass j=new AClass();
int variable=2;
void setup() {
  
  //You can look up info about an Object
  String[][] fields=ClassAnalyser.fields(j);
  String[] methods=ClassAnalyser.methods(j);
  println("Info about some Field:");
  println(fields[0]);
  println("Info about some method:");
  println(methods[0]);
  println(ClassAnalyser.classname(j.c));
  
  
  println(ClassAnalyser.lookInto(j));
  
  //Remember the sketch is also an Object
  println(ClassAnalyser.lookInto(this));
  
  //You can also call Methods from the sketch or any Object
  ClassAnalyser.call(this,"methode");
  
  //You can also override Values
  println("Value before:"+j.value);
  ClassAnalyser.override(j,"value",2);
  println("Value after:"+ClassAnalyser.get(j,"value"));
}
void draw(){}
void methode(){
println("Method was called");
}