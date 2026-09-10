class Account {
    int balance = 1000;

    void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()
                + " trying to withdraw " + amount);

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " Left = " + balance);

            balance = balance - amount;
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " Insufficient balance");
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Account account = new Account();

        Thread t1 = new Thread(() -> account.withdraw(700), "Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(700), "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance = " + account.balance);
    }
}
