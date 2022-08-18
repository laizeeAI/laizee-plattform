package de.laizee;

import lombok.Getter;
import org.kohsuke.args4j.Option;

/**
 * Represents the entered command line arguments.
 */

public class CommandLineArguments {

    @Option(name = "-spring.profiles.active", hidden = true)
    private String profiles;

    /**
     * Example: ../testdata.json in the resource folder
     */
    @Option(name = "-filename", usage = "json-input file with test data" )
    public String fileName;

    /**
     * Example: <a href="https://staging.taggingmatters.de/">
     */
    @Option(name = "-url", usage = "valid url to nlp-webservice including protocol")
    public String url;

    /**
     * Example:
     */
    @Option(name = "-username", usage = "valid username", hidden = true, required = true)
    @Getter
    public String username;

    /**
     * Example:
     */
    @Option(name = "-password", usage = "valid password", hidden = true, required = true)
    @Getter
    public String password;

    /**
     * Example:
     */
    @Option(name = "-projectid", usage = "valid projectId", hidden = true, required = true)
    @Getter
    public String projectId;

    /**
     * Example:
     */
    @Option(name = "-servicename", usage = "valid serviceName", hidden = true, required = true)
    @Getter
    public String serviceName;

    /**
     * Returns the filename containing the json data.
     *
     * @return filename
     */
    public String getFileName() {
        if (fileName == null) {
            return "../testdata-de.json";
        }
        return fileName;
    }

    /**
     * Returns the url of the nlp service endpoint.
     *
     * @return url of the nlp service endpoint
     */
    public String getUrl() {
        if (url == null) {
            return "https://staging.taggingmatters.de/";
        }
        return url;
    }
}
