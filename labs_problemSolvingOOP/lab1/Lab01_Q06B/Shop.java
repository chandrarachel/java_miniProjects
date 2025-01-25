public class Shop {
    
    private int totalProfit = 0;

    public void earn(Customer c, int e) {
        c.spend(e);
        totalProfit += e;
    }

    public void earn(Group g, int e) {
        g.spend(e);
        totalProfit += e;
    }

    public int getProfit() {
        return totalProfit;
    }
}
