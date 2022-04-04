package org.redstom.plugin.v1_13_R2;

import org.redstom.plugin.IVersionLoader;

public class VersionLoader implements IVersionLoader {

    @Override
    public void load() {
        System.out.println("Version 1.13.2");
    }

}
