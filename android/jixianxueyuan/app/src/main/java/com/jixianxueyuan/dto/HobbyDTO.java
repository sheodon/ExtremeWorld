package com.jixianxueyuan.dto;

import java.io.Serializable;
import java.util.List;

public class HobbyDTO implements Serializable {

    public static final int ALL_HOBBY_ID = 0;

    private Long id;
    private String eName;
    private String name;
    private List<TaxonomyDTO> taxonomys;
    private AppConfigDTO appConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaxonomyDTO> getTaxonomys() {
        return taxonomys;
    }

    public void setTaxonomys(List<TaxonomyDTO> taxonomys) {
        this.taxonomys = taxonomys;
    }

    public AppConfigDTO getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(AppConfigDTO appConfig) {
        this.appConfig = appConfig;
    }
}
