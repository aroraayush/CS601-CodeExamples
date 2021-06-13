package codeCamp2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/** Problem 4: In doPost method of WelcomeServlet,
 *  we can call DatabaseHandler.getInstance().insertNameIntoDatabase(name);
 *  where name is the parameter of the request (after the usual "cleaning").
 */
public class DatabaseHandler {
    /** Makes sure only one database handler is instantiated. */
    private static DatabaseHandler singleton = new DatabaseHandler();

    private String uri = "";
    /** Used to insert a new name into the namestable */
    private static final String INSERT_NAME_SQL = "INSERT INTO names (name) " + "VALUES (?);";


    /**
     * Private constructor. So that nobody can create another instance of DatabaseHandler
     */
    private DatabaseHandler() {  }

    /**
     * Load properties file
     *
     * @param configPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private Properties loadConfig(String configPath) throws FileNotFoundException, IOException {
        Properties config = new Properties();
        config.load(new FileReader(configPath));

        return config;
    }

    /**
     * Insert the name into the names table
     * @param name The name to insert into the table
     */
    public void insertNameIntoDatabase(String name) {
        try {

            Properties config = loadConfig("database.properties");
            String uri = String.format("jdbc:mysql://%s/%s", config.getProperty("hostname"),
                    config.getProperty("database"));
            uri = uri + "?serverTimezone=UTC";

            PreparedStatement sql; // prepared statement
            try (Connection dbConnection = DriverManager.getConnection(uri, config.getProperty("username"),
                    config.getProperty("password"))) {

                sql = dbConnection.prepareStatement(INSERT_NAME_SQL);
                sql.setString(1, name);
                sql.executeUpdate();

            }
        } catch (Exception e) {
            System.err.println("Unable to connect properly to database.");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Gets the single instance of the database handler.
     *
     * @return instance of the database handler
     */
    public static DatabaseHandler getInstance() {
        return singleton;
    }

}
