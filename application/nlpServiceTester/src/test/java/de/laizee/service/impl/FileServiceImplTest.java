package de.laizee.service.impl;

import de.laizee.service.FileService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class FileServiceImplTest {

    @Autowired
    private FileService fileService;

    @Configuration
    public static class FileServiceImplTestConfig {

        @Bean
        public FileService fileService() {
            return new FileServiceImpl();
        }
    }
}