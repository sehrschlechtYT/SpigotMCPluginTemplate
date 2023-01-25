package yt.sehrschlecht.plugintemplate;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import yt.sehrschlecht.plugintemplate.config.Config;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class SpigotPlugin extends JavaPlugin {

    private static SpigotPlugin instance;
    private YamlDocument configuration;

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
        try {
            configuration = YamlDocument.create(
                    new File(getDataFolder(), "config.yml"),
                    Objects.requireNonNull(getResource("config.yml")),
                    GeneralSettings.DEFAULT,
                    LoaderSettings.builder().setAutoUpdate(true).build(),
                    DumperSettings.DEFAULT,
                    UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build()
            );
        } catch (IOException e) {
            getLogger().severe("Could not create config.yml!");
            e.printStackTrace();
            return;
        }

        new Config(configuration);
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
