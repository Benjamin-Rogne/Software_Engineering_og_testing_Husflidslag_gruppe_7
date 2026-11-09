package controllers;

import DTOs.PaameldingDTO;
import Database.DatabaseConnection;
import repositories.PaameldingRepository;

import javax.naming.Context;
import java.sql.*;

public class PaameldingController {
    private PaameldingRepository paameldingRepository;

    public PaameldingController(PaameldingRepository paameldingRepository) {
        this.paameldingRepository = paameldingRepository;
    }

    public int leggTilPaamelding(PaameldingDTO nyPaamelding) {
        String sql = "INSERT INTO paamelding (bruker_id, kurs_id, paameldings_dato) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, nyPaamelding.getBruker_id());
            stmt.setInt(2, nyPaamelding.getKurs_id());
            stmt.setTimestamp(3, Timestamp.valueOf(nyPaamelding.getPaameldings_dato()));

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return -1;
            }

            // Henter den autogenererte paamelding_id
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke lagre påmelding", e);
        }
    }
    public boolean erBrukerPaameldt(int bruker_id, int kurs_id) {
        String sql = "SELECT COUNT(*) FROM paamelding WHERE bruker_id = ? AND kurs_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bruker_id);
            stmt.setInt(2, kurs_id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Returnerer true hvis tellingen er > 0
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke sjekke påmelding", e);
        }
        return false;
    }
}