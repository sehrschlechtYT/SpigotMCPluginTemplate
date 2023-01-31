package yt.sehrschlecht.plugintemplate.config;

import yt.sehrschlecht.classconfig.SimpleClassConfig;
import yt.sehrschlecht.classconfig.options.ConfigOption;

import java.io.File;

/**
 * Used to load the configuration file.<br>
 * Powered by ClassConfig (<a href="https://sehrschlecht.gitbook.io/classconfig-documentation/">Documentation</a>).
 * @author sehrschlechtYT | https://github.com/sehrschlechtYT
 * @since 1.0
 */
public class Config extends SimpleClassConfig {
    private static Config instance = null;


    //Example for a config option:
    @ConfigOption(key = "example.option", type = String.class, comments = {
            "An example config option."
    })
    public String exampleStringOption;

    /**
     * Creates a new Config instance and loads the config file. Call {@link #initialize()} after creating the instance.
     */
    public Config(File file) {
        super(file);
        instance = this;
    }

    /**
     * @return The Config instance, if it was created before using {@link Config#Config(File)}.
     */
    public static Config getInstance() {
        return instance;
    }
}
