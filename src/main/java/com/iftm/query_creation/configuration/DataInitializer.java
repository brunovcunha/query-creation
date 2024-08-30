package com.iftm.query_creation.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(
                            "INSERT INTO nota_fiscal (id_nf, id_item, cod_prod, valor_unit, quantidade, desconto) VALUES "
                                    +
                                    "(1001, 1, 123, 50.00, 5, 0.00), " +
                                    "(1001, 2, 124, 30.00, 10, 5.00), " +
                                    "(1002, 3, 125, 40.00, 7, 10.00), " +
                                    "(1002, 4, 126, 70.00, 3, 0.00), " +
                                    "(1003, 5, 127, 60.00, 15, 15.00), " +
                                    "(1004, 6, 128, 80.00, 2, 0.00), " +
                                    "(1005, 7, 129, 90.00, 1, 20.00), " +
                                    "(1006, 8, 130, 20.00, 20, 0.00), " +
                                    "(1007, 9, 131, 25.00, 12, 5.00);"
                    )) {
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }
}
