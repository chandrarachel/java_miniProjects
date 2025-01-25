public class Cat extends Animal {
    public Cat(String n) {super(n);}

    @Override
    public String getMyName() {return getName();}
    @Override
    public int getRunSpeed() {return 5;}
    
    public void chase(Runnable t){
        if(this.getRunSpeed() > t.getRunSpeed())
            System.out.println(getMyName() + " Catches " + t.getMyName());
        else{
            System.out.println(getMyName() + " Cannot Catch " + t.getMyName());
        }
    }
}
