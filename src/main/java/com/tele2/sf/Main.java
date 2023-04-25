package com.tele2.sf;

import com.tele2.sf.service.GameSimulationService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.configuration.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@QuarkusMain
@Slf4j
public class Main {

    private static final String QUARKUS_PROFILE = "QUARKUS_PROFILE";
    private static final String SYSTEM_PROFILE = "quarkus.profile";
    private static final String ACTIVE_PROFILE = ConfigUtils.getProfiles().get(0);
    private static final String JRE_VERSION = String.valueOf(Runtime.version().version().get(0));

    public static void main(String... args) {
        String quarkusProfile = System.getenv(QUARKUS_PROFILE);
        if (quarkusProfile == null) {
            System.setProperty(SYSTEM_PROFILE, "local");
        }
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {
        @ConfigProperty(name = "quarkus.application.name", defaultValue = "som-mhp-puzzle")
        String APP_NAME;

        @Override
        public int run(String... args) {
            try {
                log.info("Quarkus App {} loaded with {} profile is now running on JRE {}",
                        APP_NAME, ACTIVE_PROFILE, JRE_VERSION);
                new GameSimulationService();
                Quarkus.waitForExit();
                return 0;
            } catch (Exception e) {
                log.error("(Quarkus App = {}] failed to start with [Exception = {}]", APP_NAME, e.getMessage());
                return -1;
            }
        }
    }
}
