class Administrator {

    public static void main(String[] args) {
        new Administrator.run();
    }

    void run(){
        process(new MockDatabase(), new MockPaymentSystem());
    }

    void process(Database db, PaymentSystem ps){
        var input = new Scanner(System.in).useDelimiter("\n");
        input.forEachRemaining(line -> parserObject.parse(line).execute(db,ps));
    }


}