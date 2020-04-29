import java.io.File;

/**
 * A runner for a {@code CensoringServer} instance.
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- Network I/O -- Lab</p>
 */
public final class CensoringRunner {
    /**
     * Creates a {@code CensoringServer} object and serves the clients that connect.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CensoringServer server;

        try {
            //server = new CensoringServer(new File("Lab 12/badWords.txt"));
            server = new CensoringServer(new File("/homes/shah519/IdeaProjects/cs180/Lab12/src/badWords.txt"));
        } catch (Exception e) {
            e.printStackTrace();

            return;
        } //end try catch

        server.serveClients();
    } //main
}