package de.fhaachen.service.impl;

import de.fhaachen.service.FileService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class FileServiceImplTest {

    @Autowired
    private FileService fileService;

    @Test
    public void should_get_FileFromResources(@TempDir @NotNull Path directory) {
        Path path = directory.resolve("testdata.json");

        //File file = fileService.getFileFromName(path.getFileName().toString());

        //assertThat(file.exists(), equalTo(true));
    }

    @Test
    public void should_Not_getFileFromResources_NoJsonFile() {
        //assertThrows(FileNotFoundException.class,
        //         () -> fileService.getFileFromResources("testdata.txt"));

    }

    @Configuration
    public static class FileServiceImplTestConfig {

        @Bean
        public FileService fileService() {
            return new FileServiceImpl();
        }
    }
}