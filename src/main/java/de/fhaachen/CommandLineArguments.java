package de.fhaachen;

import org.kohsuke.args4j.Option;

/**
 * Represents the entered command line arguments.
 */

public class CommandLineArguments {

    @Option(name = "-spring.profiles.active", hidden = true)
    private String profiles;

    /**
     * Example: testdata.json in the resource folder
     */
    @Option(name = "-filename", usage = "json-input file with test data")
    public String fileName;

    /**
     * Example: <a href="http://www.domain.com/servicename">
     */
    @Option(name = "-url", usage = "valid url to nlp-webservice including protocol")
    public String url;

    /**
     * Example:
     */
    @Option(name = "-username", usage = "valid username", hidden = true)
    public String username;

    /**
     * Example:
     */
    @Option(name = "-password", usage = "valid password", hidden = true)
    public String password;

    /**
     * Example:
     */
    @Option(name = "-projectid", usage = "valid projectId", hidden = true)
    public String projectId;

    /**
     * Example:
     */
    @Option(name = "-servicename", usage = "valid serviceName", hidden = true)
    public String serviceName;

    /**
     * Returns the filename containing the json data.
     *
     * @return filename
     */
    public String getFileName() {
        if (fileName == null) {
            return "testdata.json";
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
            // TODO remove?
            return "http://149.201.187.221/";
        }
        return url;
    }

    /**
     * Returns the username of the nlp service endpoint.
     *
     * @return username of the nlp service endpoint user
     */
    public String getUsername() {
        if (username == null) {
            return "admin";
        }
        return username;
    }

    /**
     * Returns the username of the nlp service endpoint.
     *
     * @return username of the nlp service endpoint user
     */
    public String getPassword() {
        if (password == null) {
            return "password";
        }
        return password;
    }

    /**
     * Returns the username of the nlp service endpoint.
     *
     * @return username of the nlp service endpoint user
     */
    public String getProjectId() {
        if (projectId == null) {
            return "1";
        }
        return projectId;
    }

    /**
     * Returns the username of the nlp service endpoint.
     *
     * @return username of the nlp service endpoint user
     */
    public String getServiceName() {
        if (serviceName == null) {
            return "test";
        }
        return serviceName;
    }
}
