package com.redhat.hacbs.recipes.mavenrepo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.redhat.hacbs.recipes.RecipeManager;

public class MavenRepositoryInfoManager implements RecipeManager<MavenRepositoryInfo> {

    public static MavenRepositoryInfoManager INSTANCE = new MavenRepositoryInfoManager();

    @Override
    public MavenRepositoryInfo parse(InputStream file) throws IOException {
        return MAPPER.readValue(file, MavenRepositoryInfo.class);
    }

    @Override
    public void write(MavenRepositoryInfo data, OutputStream out) throws IOException {
        MAPPER.writeValue(out, data);
    }
}
