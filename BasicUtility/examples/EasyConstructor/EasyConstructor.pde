import ProcessingUtils.general.*;

void setup() {
  //You can call a constructor wich calls one of the 5 constructors
  ExampleClassWithout obj1=new ExampleClassWithout(1,5);
  obj1.outputData();
  ExampleClassWith obj2=new ExampleClassWith(1,5,6);
  obj2.outputData();
}