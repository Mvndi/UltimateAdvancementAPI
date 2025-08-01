package com.fren_gor.ultimateAdvancementAPI;

import com.google.common.base.Preconditions;
import net.byteflux.libby.LibraryManager;
import net.byteflux.libby.logging.adapters.JDKLogAdapter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ConfigManagerTest {

    @Rule
    public TemporaryFolder tmpFolder = TemporaryFolder.builder().assureDeletion().build();

    @Test
    public void configVersionTest() throws Exception {
        var configURL = ConfigManager.class.getResource("/config.yml");
        Preconditions.checkNotNull(configURL, "config.yml not found");
        YamlConfiguration config = new YamlConfiguration();
        config.load(new File(configURL.toURI()));

        String failMessage = "CONFIG_VERSION in ConfigManager class is not the same as 'config-version' in config.yml. Please update the ConfigManager.CONFIG_VERSION constant.";
        assertEquals(failMessage, ConfigManager.CONFIG_VERSION, config.getInt("config-version", -1));
    }

    @Test
    public void configUpdaterDownloadTest() throws Exception {
        Logger logger = Logger.getLogger("ConfigManagerTest");
        MockLibraryManager manager = new MockLibraryManager(logger);

        try {
            assertTrue(Files.exists(manager.downloadLibrary(ConfigManager.CONFIG_UPDATER)));
        } catch (Exception e) {
            fail("Failed to download config updater!");
        }
    }

    private final class MockLibraryManager extends LibraryManager {
        public MockLibraryManager(Logger logger) throws IOException {
            super(new JDKLogAdapter(logger), tmpFolder.newFolder().toPath(), ".libs");
        }

        @Override
        protected void addToClasspath(Path file) {
            throw new UnsupportedOperationException();
        }
    }
}
