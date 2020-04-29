import java.net.Socket;
import java.util.Set;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * A handler for requests made to a censoring server.
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- Network I/O -- Lab</p>
 */
public final class CensoringRequestHandler implements Runnable {
    /**
     * The client socket of this request handler.
     */
    private Socket clientSocket;

    /**
     * The bad words of this request handler.
     */
    private Set<String> badWords;

    /**
     * Constructs a newly allocated {@code CensoringRequestHandler} object with the specified client socket and
     * {@code Set} of bad words.
     *
     * @param clientSocket the client socket to be used in construction
     * @param badWords the {@code Set} of bad words to be used in construction
     * @throws NullPointerException if the specified client socket or {@code Set} of bad words is {@code null}
     */
    public CensoringRequestHandler(Socket clientSocket, Set<String> badWords) throws NullPointerException {
        Objects.requireNonNull(clientSocket, "the specified client socket is null");

        Objects.requireNonNull(badWords, "the specified Set of bad words is null");

        this.clientSocket = clientSocket;
        this.badWords = badWords;
    } //CensoringRequestHandler

    /**
     * Handles the requests of the client connected to this request handler's client socket.
     */
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line = reader.readLine();
            while(line != null){
                String[] words = line.split(" ");
                for(int i = 0; i < words.length; i++){
                    String word = words[i];
                    if(badWords.contains(word)){
                        String s = "";
                        for(int j = 0; j < word.length(); j++){
                            s += "*";
                        }
                        words[i] = s;
                    }
                }
                String s = "";
                for(String word: words){
                    s += word + " ";
                }
                s = s.substring(0,s.length()-1);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                writer.write(s);
                writer.newLine();
                writer.flush();
                line = reader.readLine();
                //writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //run

    /**
     * Returns the hash code of this request handler.
     *
     * @return the hash code of this request handler
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 31 * result + Objects.hashCode(this.clientSocket);

        result = 31 * result + Objects.hashCode(this.badWords);

        return result;
    } //hashCode

    /**
     * Determines whether or not the specified object is equal to this request handler. {@code true} is returned if and
     * only if the specified object is an instance of {@code CensoringRequestHandler} and its client socket and
     * {@code Set} of bad words are equal to this request handler's.
     *
     * @param object the object to be used in the comparisons
     * @return {@code true}, if the specified object is equal to this request handler and {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object instanceof CensoringRequestHandler) {
            boolean equal;

            equal = Objects.equals(this.clientSocket, ((CensoringRequestHandler) object).clientSocket);

            equal &= Objects.equals(this.badWords, ((CensoringRequestHandler) object).badWords);

            return equal;
        } else {
            return false;
        } //end if
    } //equals

    /**
     * Returns the {@code String} representation of this request handler. The returned {@code String} consists of a
     * comma separated list of this request handler's client socket and {@code Set} of bad words surrounded by this
     * class' name and square brackets ("[]").
     *
     * @return the {@code String} representation of this request handler
     */
    @Override
    public String toString() {
        String format = "CensoringRequestHandler[%s, %s]";

        return String.format(format, this.clientSocket, this.badWords);
    } //toString
}