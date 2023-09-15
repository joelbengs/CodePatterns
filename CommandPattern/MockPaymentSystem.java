class MockPaymentSystem implements PaymentSystem {
    public void transfer(String fromAccount,
                         String toAccount,
                         double amount) {
        System.out.printf("Transfer %.2f from %s to %s\n",
                          amount,
                          fromAccount,
                          toAccount);
    }
}