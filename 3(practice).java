class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    double getCharge() {
        return 0;
    }

    void display() {
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Charge: Rs. " + getCharge());
        System.out.println("Total: Rs. " + (amount + getCharge()));
    }
}

class NetBanking extends Payment {

    NetBanking(double amount) {
        super(amount);
    }

    @Override
    double getCharge() {
        return 12;
    }
}

class Main {
    public static void main(String[] args) {
        Payment payment = new NetBanking(1000);
        payment.display();
    }
}
