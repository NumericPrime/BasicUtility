import ProcessingUtils.WindowMaker.*;
import ProcessingUtils.error.*;
import ProcessingUtils.general.*;
int test=5;
import javax.swing.*;
JTextField props=new JTextField(12);
void setup() {
  size(200, 200);
  //Sets the PApple (Processing program) to use for the Window maker. DO NOT USE IN ANOTHER CLASS!
  SwingConstructor.setPApplet(this);

  //Joins components vertically
  JButton resetButton=new JButton("Run");
  //Adds the method reset to the button
  SwingConstructor.callMethodOnClick(resetButton, "executeCommand");

  //Joins components horizonaly
  JPanel prompt=SwingConstructor.list_row(SwingConstructor.list_col(new JLabel("Command:"), props), resetButton);

  //Fiddling about with the dimensions

  //Adds the contents of the processing window to the right (East)
  JFrame mainWindow=SwingConstructor.merge(SwingConstructor.scrollable(prompt), "East");
  mainWindow.setVisible(true);
  mainWindow.setTitle("Example");
}
void draw() {
  println(test, frameCount, frameRate);
}
void testFunction() {
  println("calledFunction");
}
void executeCommand() {
  String command=props.getText();
  String components[]=command.split(" ");
  println(command);
  switch(components[0]) {
  case "exit":
    exit();
    break;
  case "overrideInt":
    ClassAnalyser.override(this, components[1], Integer.parseInt(components[2]));
    break;
  case "info":
    println("\n");
    ClassAnalyser.printAllFields(this);
    break;
  case "mute":
    //Disables all print-commands
    General.mute();
    break;
  case "unmute":
    General.unmute();
    break;
  case "execute":
    ClassAnalyser.call(this, components[1]);
    break;
  }
}