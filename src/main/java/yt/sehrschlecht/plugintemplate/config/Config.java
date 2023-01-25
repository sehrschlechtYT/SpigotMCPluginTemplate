package yt.sehrschlecht.plugintemplate.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import yt.sehrschlecht.plugintemplate.SpigotPlugin;
import yt.sehrschlecht.schlechteutils.config.AbstractConfig;

/**
 * The Config class is used to load the configuration file.
 * @author sehrschlechtYT | https://github.com/sehrschlechtYT
 * @since 1.0
 */
public class Config extends AbstractConfig {
    private static Config instance = null;

    /*
    Example for a config option:
    @ConfigOption(key = "example", type = String.class)
    public String exampleStringOption;
    */

    /**
     * Creates a new Config instance and loads the config file.
     * @param configDocument The YamlDocument of the config file.
     */
    public Config(YamlDocument configDocument) {
        super(configDocument);
        instance = this;
        reload(configDocument);
    }

    /**
     * Reloads the file from the given YamlDocument.
     * @param configuration The YamlDocument of the config file.
     */
    public void reload(YamlDocument configuration) {
        try {
            configuration.reload();
            load(configuration);
        } catch (Exception exception) {
            SpigotPlugin.getInstance().getLogger().severe("Could not reload configuration!");
            exception.printStackTrace();
        }
    }

    /**
     * @return The Config instance, if it was created before using {@link Config#Config(YamlDocument)}.
     */
    public static Config getInstance() {
        return instance;
    }
}
