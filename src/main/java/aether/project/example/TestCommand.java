package aether.project.example;

import aether.project.aetherapi.commands.CommandReg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandReg(aliases = {"test"})
public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        TestMenu testMenu = new TestMenu();
        if (commandSender instanceof Player) {
            // Судя по названию метода, меню открывает игрока :`)
            testMenu.open((Player) commandSender);
        }
        return true;
    }
}
