package yt.sehrschlecht.plugintemplate;

import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPlugin extends JavaPlugin {
    private static SpigotPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    /**
     * @return An instance of the plugin, if it is enabled.
     */
    public static SpigotPlugin getInstance() {
        return instance;
    }
}
