package uk.co.real_logic.fix_gateway;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpectMessageStep implements TestStep
{
    private static final Pattern HEADER_PATTERN = Pattern.compile("^E(\\d+),.*");
    private final String line;
    private int clientId;

    public ExpectMessageStep(final String line)
    {
        this.line = line;
    }

    public void run()
    {
        final Matcher headerMatcher = HEADER_PATTERN.matcher(line);
        if (headerMatcher.matches())
        {
            clientId = Integer.parseInt(headerMatcher.group(1));
        }
        else
        {
            clientId = 1;
        }
    }
}