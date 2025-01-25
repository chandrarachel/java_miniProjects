public class Customer {
    
    private int totalMoney;

    public Customer(int money) {
        totalMoney = money;
    }

    public void spend(int value) {
        totalMoney -= value;
    }

    public int getAmount() {
        return totalMoney;
    }

}
