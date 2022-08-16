package de.fhaachen;

import org.junit.jupiter.api.Test;
import org.kohsuke.args4j.CmdLineParser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommandLineArgumentsTest {

    private CommandLineArguments getArgs(String... args) throws Exception {
        CommandLineArguments arguments = new CommandLineArguments();
        new CmdLineParser(arguments).parseArgument(args);
        return arguments;
    }

    @Test
    public void shouldReturnUrl_default() throws Exception {
        CommandLineArguments args = getArgs();
        assertThat(args.getUrl().toString(), is("http://149.201.187.221/"));
    }

    @Test
    public void shouldReturnUrl_given() throws Exception {
        CommandLineArguments args = getArgs("-url", "url");
        assertThat(args.getUrl().toString(), is("url"));
    }

    @Test
    public void shouldReturnFileName_default() throws Exception {
        CommandLineArguments args = getArgs();
        assertThat(args.getFileName().toString(), is("testdata.json"));
    }

    @Test
    public void shouldReturnFileName_given() throws Exception {
        CommandLineArguments args = getArgs("-filename", "file");
        assertThat(args.getFileName().toString(), is("file"));
    }

}
