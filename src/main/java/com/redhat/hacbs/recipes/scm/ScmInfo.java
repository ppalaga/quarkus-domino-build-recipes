package com.redhat.hacbs.recipes.scm;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScmInfo extends RepositoryInfo {
    public ScmInfo() {
    }

    public ScmInfo(String type, String uri) {
        super(type, uri);
    }

    public ScmInfo(String type, String uri, String path) {
        super(type, uri, path);
    }

    private List<RepositoryInfo> legacyRepos = new ArrayList<>();

    public List<RepositoryInfo> getLegacyRepos() {
        return legacyRepos;
    }

    public ScmInfo setLegacyRepos(List<RepositoryInfo> legacyRepos) {
        this.legacyRepos = legacyRepos;
        return this;
    }
}
