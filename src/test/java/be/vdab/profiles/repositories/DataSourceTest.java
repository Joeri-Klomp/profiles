package be.vdab.profiles.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DataSourceTest {
    private final DataSource dataSource;

    public DataSourceTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    void dataSourceTest() throws SQLException {
        try(var connection = dataSource.getConnection()) {
            System.out.println(connection.getCatalog());
//            assertThat(connection.getCatalog()).isEqualTo("productiedatabase");
            assertThat(connection.getCatalog()).isEqualTo("ontwikkeldatabase");

        }
    }
}

//Afhankelijk van het actief zijn van een profile, kan je een bean wel of niet maken. Als je voor een class
// @Profile("dev") typt, maakt Spring van die class enkel een bean als het dev profile actief is.
