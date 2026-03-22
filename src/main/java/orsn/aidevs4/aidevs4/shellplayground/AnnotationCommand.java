package orsn.aidevs4.aidevs4.shellplayground;

import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
public class AnnotationCommand {

    @Command(name = "helloComp", group = "Basic")
    public String helloCommand() {
        //This will be printed to the shell output
        return "Hello from annotation command component!";
    }
}
