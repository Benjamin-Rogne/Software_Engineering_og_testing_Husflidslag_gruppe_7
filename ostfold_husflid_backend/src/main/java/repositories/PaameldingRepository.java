package repositories;

import DTOs.PaameldingDTO;
import Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    //metode for å sjekke om bruker er påmeldt
    public boolean erBrukerPaameldt(int idBruker, int idKurs) {
        String sql = "SELECT 1 FROM paamelding WHERE idbruker = ? AND idkurs = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idBruker);
            stmt.setInt(2, idKurs);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke sjekke påmelding", e);
        }
    }

    //slette bruker fra påmelding
    public boolean slettPaamelding(int idbruker, int idkurs) {
        String sql = "DELETE FROM paamelding WHERE idbruker = ? AND idkurs = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idbruker);
            stmt.setInt(2, idkurs);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke gjennomføre avmelding", e);
        }

    }


    //henter bruker sine påmeldinger
    public List<PaameldingDTO> hentPaameldingerForBruker(int idBruker) {
        String sql = "SELECT idbruker, idkurs FROM paamelding WHERE idbruker = ?";
        List<PaameldingDTO> paameldinger = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBruker);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int brukerId = rs.getInt("idbruker");
                    int kursId = rs.getInt("idkurs");
                    paameldinger.add(new PaameldingDTO(brukerId, kursId));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente påmeldinger", e);
        }
        return paameldinger;
    }
}