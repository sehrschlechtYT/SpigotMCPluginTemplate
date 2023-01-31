package yt.sehrschlecht.plugintemplate;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import yt.sehrschlecht.plugintemplate.config.Config;

import java.io.File;

public final class SpigotPlugin extends JavaPlugin {

    private static SpigotPlugin instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        createConfig();
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    /**
     * Loads the config.yml file.<br>
     * After calling this method, you can access the config via {@link Config#getInstance()}.
     */
    private void createConfig() {
        new Config(new File(getDataFolder(), "config.yml")).initialize();
    }

    /**
     * Registers the commands of this plugin.
     */
    @SuppressWarnings("ConstantConditions")
    private void registerCommands() {

    }

    /**
     * Registers the listeners of this plugin.
     */
    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();

    }

    /**
     * @return An instance of the plugin, if it is enabled.
     */
    public static SpigotPlugin getInstance() {
        return instance;
    }

}
