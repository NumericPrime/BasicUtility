class BClass {
  int value;
  BClass(int val) {
    value=val;
  }
  public int getValue() {
    return value;
  }
}
class AClass {
  int value;
  BClass c=new BClass(1);
  public int getValue() {
    return value;
  }
}