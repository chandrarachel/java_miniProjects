public class Shop {
    
    private int earning;

    public Shop() {
        earning = 0;
    }

    public void earn(Customer c, int e) {
        c.spend(e);
        earning += e;
    }

    public int getProfit() {
        return earning;
    }
}
