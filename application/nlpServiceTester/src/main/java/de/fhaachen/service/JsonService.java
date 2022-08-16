package de.fhaachen.service;

import de.fhaachen.model.Data;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This interface defines methods for json operations.
 */
public interface JsonService {

    /**
     * Read Json Data from given file and returns this data in form of a list of {@link Data} objects.
     *
     * @param file given file
     * @return List of {@link Data}
     * @throws IOException
     */
    List<Data> readJsonFromFile(File file) throws IOException;
}
