package aether.project.aetherapi;

import aether.project.aetherapi.gui.MenuListener;
import aether.project.example.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandRegister.init(this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        // Register example command
        CommandRegister.reg(new TestCommand());
    }
}
