class ExampleClassWith {
  int a, b, c, d, e;
  //one constructor for 1-5 inputs
  ExampleClassWith(Integer... inputs) {
    ConstructorHelper.manipulate(this, "a b c d e", inputs);
  }
  void outputData() {
    println(a, b, c, d, e);
  }
}