package orsn.aidevs4.aidevs4.shellplayground;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.core.command.CommandContext;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandRegistryCommand {
    private static final org.springframework.shell.core.command.Command DYNAMIC_COMMAND = org.springframework.shell.core.command.Command.builder().name("helloDyn").group("Dynamic").execute(ctx -> "Hello from dynamic command!");

    @Command(name = "registerDynamic", group = "Dynamic")
    public String registerDynamicCommand(CommandContext context) {
        context.commandRegistry().registerCommand(DYNAMIC_COMMAND);
        return DYNAMIC_COMMAND.getName() + " registered";
    }

    @Command(name = "unregisterDynamic", group = "Dynamic")
    public String unregisterDynamicCommand(CommandContext context) {
        context.commandRegistry().unregisterCommand(DYNAMIC_COMMAND);
        return DYNAMIC_COMMAND.getName() + " unregistered";
    }

}
