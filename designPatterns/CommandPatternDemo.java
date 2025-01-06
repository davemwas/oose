/*
 
Command interface: Defines the execute() method that all concrete command classes will implement.
Concrete Command classes (LightOnCommand & LightOffCommand): These are specific implementations of the Command interface that encapsulate a request to turn a light on or off. Each command contains a reference to the receiver (Light) and calls the corresponding method (turnOn() or turnOff()).
Receiver class (Light): The receiver is the object that performs the actual action. In this case, it controls the light, turning it on or off.
Invoker class (RemoteControl): The invoker class holds a reference to the command and invokes the command's execute() method when the button is pressed. It decouples the action from the user interface.
CommandPatternDemo class: Demonstrates how the command pattern is used by creating LightOnCommand and LightOffCommand objects, setting them in a RemoteControl, and pressing the button to execute the commands.


*/


// Command Interface
interface Command {
    void execute();
}

// Concrete Command 1
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command 2
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}


class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}


class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();

        // Concrete commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        // Turn the light on
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        // Turn the light off
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }
}
