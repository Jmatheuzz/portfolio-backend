package com.jmatheus.portfolio.portfolio.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "configurations")
public class ConfigurationSite {
    public ConfigurationSite(Long id, String logoUrl){
        this.id = id;
        this.logoUrl = logoUrl;
    }
    @Id
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR DEFAULT 'Portfólio João Matheus'")
    private String siteName;

    @Column(nullable = false, columnDefinition = "VARCHAR DEFAULT '#0047ab'")
    private String primaryColor;

    @Column(nullable = false, columnDefinition = "VARCHAR DEFAULT '#a7a5a6'")
    private String secondaryColor;


    private String logoUrl;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean enableProjects;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean enableBlog;



}
