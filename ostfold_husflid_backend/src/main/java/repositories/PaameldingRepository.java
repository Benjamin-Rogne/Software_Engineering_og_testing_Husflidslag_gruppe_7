package repositories;

import Database.DatabaseConnection;
import java.sql.*;

public class PaameldingRepository {

    // Metode for å melde en bruker på et kurs
    public boolean leggTilPaamelding(int idbruker, int idkurs, int aktivitet_id) {
        String sql = "INSERT INTO paamelding (idbruker, idkurs, aktivitet_id, datoTid) VALUES (?, ?, ?, NOW())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idbruker);
            stmt.setInt(2, idkurs);
            stmt.setInt(3, aktivitet_id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returnerer true om påmeldingen gikk i tastaturet/databasen

        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke gjennomføre påmelding", e);
        }
    }


    public boolean MeldSegAVPaamelding(int idBruker, int idKurs, int aktivitet_id){
        try(){}

        catch (){}



    }
}