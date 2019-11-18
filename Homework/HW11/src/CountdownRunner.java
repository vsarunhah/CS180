import java.io.IOException;

/**
 * A runner for a {@code CountdownServer} instance.
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- Network I/O -- Homework</p>
 * @author CS180
 * @version 1
 */
public final class CountdownRunner {
    /**
     * Creates a {@code CountdownServer} instance, then begins to serve clients.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CountdownClient client;
        CountdownServer server;

        try {
            //client = new CountdownClient();
            server = new CountdownServer();
        } catch (IOException e) {
            e.printStackTrace();

            return;
        } //end try catch

        server.serveClients();
    } //main
}