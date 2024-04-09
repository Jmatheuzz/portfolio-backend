package com.jmatheus.portfolio.portfolio.database.seeds;

import com.jmatheus.portfolio.portfolio.models.ConfigurationSite;
import com.jmatheus.portfolio.portfolio.repositories.ConfigurationSiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationSiteDefaultSeed implements CommandLineRunner {
    @Autowired
    private ConfigurationSiteRepository configurationSiteRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
    }

    private void seedRoles() {
        if (configurationSiteRepository.count() == 0) {
            ConfigurationSite config = new ConfigurationSite(
                    1L, "Portfólio João Matheus", "#0047ab", "#a7a5a6", "url-logo", true, true
            );
            configurationSiteRepository.save(config);



        }
    }
}
