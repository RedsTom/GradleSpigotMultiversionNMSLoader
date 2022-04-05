package org.redstom.plugin.v1_14_R1;

import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.redstom.plugin.IVersionLoader;

public class VersionLoader implements IVersionLoader {
    @Override
    public void load() {
        System.out.println("Loaded 1.14.R1");
        CraftPlayer player = null;
    }
}
