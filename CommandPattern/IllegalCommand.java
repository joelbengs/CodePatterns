class IllegalCommand implements Command {

    private String[] parts;

    private IllegalCommand  (String[] parts) {
        this.parts = parts;
    }

    public static Command parse(String[] parts) {
        return new IllegalCommand(parts);
    }

    public void execute(Database db, PaymentSystem ps) {
        System.out.println("Illegal command: " + String.join(",", parts));
    }
}