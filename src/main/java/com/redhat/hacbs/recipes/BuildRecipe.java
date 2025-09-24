package com.redhat.hacbs.recipes;

import java.util.Objects;

import com.redhat.hacbs.recipes.build.BuildRecipeInfo;
import com.redhat.hacbs.recipes.build.BuildRecipeInfoManager;
import com.redhat.hacbs.recipes.scm.ScmInfo;
import com.redhat.hacbs.recipes.scm.ScmInfoManager;

/**
 * Represents a recipe file (e.g. scm.yaml) that contains build information
 * <br/>
 * This is not an enum to allow for extensibility
 */
public class BuildRecipe<T> {
    public static final String DEFAULT_RECIPE_REPO_URL = "https://github.com/redhat-appstudio/jvm-build-data";

    public static final BuildRecipe<ScmInfo> SCM = new BuildRecipe<>("scm.yaml", new ScmInfoManager());
    public static final BuildRecipe<BuildRecipeInfo> BUILD = new BuildRecipe<>("build.yaml", new BuildRecipeInfoManager());

    final String name;
    final RecipeManager<T> handler;

    public BuildRecipe(String name, RecipeManager<T> handler) {
        this.name = name;
        this.handler = handler;
    }

    public String getName() {
        return name;
    }

    public RecipeManager<T> getHandler() {
        return handler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BuildRecipe that = (BuildRecipe) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
