package org.redstom.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        String[] versionPackage = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
        String version = versionPackage[versionPackage.length - 1];

        try {
            Class<?> loaderClass = this.getClass().getClassLoader().loadClass(
                "org.redstom.plugin." + version.split("-")[0].replace(".", "_") + ".VersionLoader");

            IVersionLoader.class.getMethod("load").invoke(loaderClass.getConstructor().newInstance());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported version : " + version + " !");
        }

    }
}
