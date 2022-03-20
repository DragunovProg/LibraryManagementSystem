package ua.dragunov.library.database;

import org.apache.log4j.Logger;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LibraryDataSource {
    private static final Logger LOGGER = Logger.getLogger(LibraryDataSource.class);

    private LibraryDataSource() {}

    public static DataSource getLibraryDataSource() {
        PGSimpleDataSource libraryDatasource = new PGSimpleDataSource();

        try(FileReader propertiesReader =
                    new FileReader("src/main/resources/application.properties")) {

            Properties databaseProperties = new Properties();
            databaseProperties.load(propertiesReader);

            libraryDatasource.setURL(databaseProperties.getProperty("postgresUrl"));
            libraryDatasource.setUser(databaseProperties.getProperty("postgresUser"));
            libraryDatasource.setPassword(databaseProperties.getProperty("postgresPassword"));
        } catch (FileNotFoundException e) {
            LOGGER.info("LibraryDataSource::getLibraryDataSource : ", e);
        } catch (IOException e) {
            LOGGER.info("LibraryDataSource::getLibraryDataSource : ", e);
        }

        return libraryDatasource;
    }
}
