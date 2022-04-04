package org.redstom.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        String[] version = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
        try {
            Class<? extends IVersionLoader> loaderClass =
                (Class<? extends IVersionLoader>) this.getClass().getClassLoader()
                .loadClass("org.redstom.plugin." + version[version.length - 1].split("-")[0].replace(".", "_") +
                    ".VersionLoader");

            IVersionLoader loader = loaderClass.getConstructor().newInstance();
            loader.load();

        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported version : " + version[version.length - 1] + " !");
        }

    }
}
