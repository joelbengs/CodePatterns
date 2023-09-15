class CommandParser {
    //The parse method determines the correct command by the first word of the input, or defaules to IllegalCommand.
    public Command parse(String cmd){
        var parts = cmd.split(",");
        return
            switch (parts[0]) {
            case "add" -> AddEmployeeCommand.parse(parts); //Static factory-method in AddEmployeeCommand
            default -> IllegalCommand.parse(parts);
    }
}