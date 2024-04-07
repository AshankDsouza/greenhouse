package Utils;

import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.reader.impl.completer.NullCompleter;

import java.io.IOException;

public class TerminalUtils {
    private static Terminal terminal;
    private static Completer completer;
    private static LineReader lineReader;

    static {
        try {
            terminal = TerminalBuilder.builder().system(true).build();
            completer = new ArgumentCompleter(
                    new StringsCompleter("bar", "baz"),
                    new StringsCompleter("foo"),
                    new StringsCompleter("ree"),
                    new NullCompleter());
            lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(completer)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Terminal getTerminal() {
        return terminal;
    }

    public static Completer getCompleter() {
        return completer;
    }

    public static LineReader getLineReader() {
        return lineReader;
    }

    // return
}

