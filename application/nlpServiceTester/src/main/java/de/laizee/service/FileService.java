package de.laizee.service;

import java.io.File;

/**
 * This interface defines methods for file operations.
 */
public interface FileService {

    /**
     * Returns a resource file from given name.
     *
     * @param fileName given name
     * @return file from resource folder
     */
    File getFileFromName(String fileName);
}
