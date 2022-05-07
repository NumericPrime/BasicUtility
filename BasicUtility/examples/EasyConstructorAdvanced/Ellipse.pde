class Ellipse {
  float x, y, r1, r2, r, g, b;
  Ellipse(Integer... inputs) {
    //this asserts that x, y and r1 are given
    ConstructorHelper.checkValidLength(inputs, 3);
    ConstructorHelper.manipulate(this, "x y r1 r2 r g b", inputs);
    //If r1 but not r2 is given r2 will be set to r1
    if(inputs.length==3) r2=r1;
  }
  void paint(){
    fill(r,g,b);
    ellipse(x,y,r1,r2);
  }
}