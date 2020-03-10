import commands.Command;
import commands.CommandResult;
import commands.ExitCommand;
import utils.Parser;
import stock.Stock;
import ui.Ui;

/**
 * Entry point of the application.
 * Initializes the program and takes command from the user.
 * 
 */
public class Main {
    
    private Stock stock;
    private Ui ui;

    /** Driver code for the program. */
    public static void main(String... args) {
        new Main().run(args);
    }
    
    /** Runs the program until the user terminates it. */
    public void run(String[] args) {
        start(args);
        runCommandUntilExit();
        exit();
    }
    
    /** Sets up the required objects and shows a welcome message. */
    public void start(String[] args) {
        this.stock = new Stock();
        this.ui = new Ui();
        ui.showWelcomeMessage();
    }
    
    /** Read user's input, parse it into readable command format and execute it. */
    private void runCommandUntilExit() {                     
        Command command;
        do {
            String userInput = ui.getUserCommand();
            command = new Parser().parseCommand(userInput);
            CommandResult result = executeCommand(command);
        } while (!ExitCommand.isExit(command));
    }
    
    /** Executes a command. */
    private CommandResult executeCommand(Command command) {
        try {
            command.setData(this.stock);
            CommandResult output = command.execute();
            ui.showMessage(output.getCommandResult());
            return output; 
        } catch (Exception e) {
            ui.showMessage(e.getMessage());
            throw new RuntimeException(e);
        }
        
    }
    
    /** Exits the program with a goodbye message. */
    private void exit() {
        System.exit(0);
    }    

}