package ProcessingUtils.WindowMaker;

public interface BasicTemplate {
		abstract void settings();
		abstract void setup();
		abstract void draw();
		String programName = "";
}
