package aether.project.aetherapi;

import aether.project.aetherapi.commands.CommandReg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CommandRegister extends Command implements PluginIdentifiableCommand {
    private static Plugin plugin;
    protected final CommandExecutor owner;
    protected final Object registeredWith;

    public CommandRegister(String[] aliases, String desc, String usage, CommandExecutor owner, Object registeredWith) {
        super(aliases[0], desc, usage, Arrays.asList(aliases));
        this.owner = owner;
        this.registeredWith = registeredWith;
    }

    // Weird
    static void init(Plugin apiPlugin) {
        plugin = apiPlugin;
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        return this.owner.onCommand(sender, this, label, args);
    }

    public Object getRegisteredWith() {
        return this.registeredWith;
    }

    public static void reg(CommandExecutor executor) {
        try {
            if (executor.getClass().isAnnotationPresent(CommandReg.class)) {
                CommandReg commandInfo = executor.getClass().getAnnotation(CommandReg.class);
                CommandRegister reg = new CommandRegister(commandInfo.aliases(), commandInfo.desc(), commandInfo.usage(), executor, new Object());
                Bukkit.getCommandMap().register("AetherProject", reg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
