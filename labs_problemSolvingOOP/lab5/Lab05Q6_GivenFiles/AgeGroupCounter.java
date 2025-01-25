public class AgeGroupCounter extends Counter 
{
    private int num1, num2;

    public AgeGroupCounter(int num1, int num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void countData(Record r) {
		if (r.getAge() >= num1 && r.getAge() <= num2)
			super.countData(r);
	}

    public String toString()
    {
        return String.format("[Age %d to %d] Count = %d", num1, num2, getCount());
    }
}
