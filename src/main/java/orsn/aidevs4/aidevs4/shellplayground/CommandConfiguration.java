package orsn.aidevs4.aidevs4.shellplayground;

import org.jspecify.annotations.NullMarked;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.core.command.AbstractCommand;
import org.springframework.shell.core.command.Command;
import org.springframework.shell.core.command.CommandContext;
import org.springframework.shell.core.command.ExitStatus;

@NullMarked
@Configuration
public class CommandConfiguration {

    @Bean
    Command programmaticCommand() {
        return Command.builder().name("helloProg").group("Basic").execute(ctx -> "Hello from programmatic command!");
    }

    @Bean
    Command abstractCommand() {
        return new AbstractCommand("helloAbstract", "Abstract command", "Basic") {
            @Override
            public ExitStatus doExecute(CommandContext commandContext) throws Exception {
                println("Hello from abstract command!", commandContext);
                return ExitStatus.OK;
            }
        };
    }

}
