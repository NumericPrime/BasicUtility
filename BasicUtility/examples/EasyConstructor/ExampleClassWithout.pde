class ExampleClassWithout {
  int a, b, c, d, e;
  //5 constructors for different Data
  ExampleClassWithout(int a) {
    this.a=a;
  }
  ExampleClassWithout(int a, int b) {
    this.a=a;
    this.b=b;
  }
  ExampleClassWithout(int a, int b, int c) {
    this.a=a;
    this.b=b;
    this.c=c;
  }
  ExampleClassWithout(int a, int b, int c, int d) {
    this.a=a;
    this.b=b;
    this.c=c;
    this.d=d;
  }
  ExampleClassWithout(int a, int b, int c, int d, int e) {
    this.a=a;
    this.b=b;
    this.c=c;
    this.d=d;
    this.e=e;
  }
  void outputData() {
    println(a, b, c, d, e);
  }
}