package de.fhaachen.service.impl;

import de.fhaachen.service.FileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This Service class defines methods for file operations.
 */
@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = Logger.getLogger(FileServiceImpl.class);

    @Override
    public File getFileFromName(String fileName)  {
        if (!fileName.endsWith(".json")) {
            LOGGER.info("File must be a .json file");
            LOGGER.info("Aborting...");
            System.exit(0);
        }

        File file = new File(fileName);

        if (!file.exists()) {
            LOGGER.info("File '" + fileName + "' not found!");
            LOGGER.info("Aborting...");
            System.exit(0);
        }
        return file;
    }
}
