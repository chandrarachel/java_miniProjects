public class Mouse extends Animal {
    public Mouse(String n) {super(n);}

    @Override
	public String getMyName() {return getName();}
    @Override
	public int getRunSpeed() {return 2;}
}
