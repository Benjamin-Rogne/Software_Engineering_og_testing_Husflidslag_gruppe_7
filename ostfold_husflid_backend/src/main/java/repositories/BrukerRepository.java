package repositories;
import models.Bruker;
import java.util.List;
import java.util.Optional;

// henter data fra databasen og sender den videre til service og deretter controller til slutt react
/*
public class BrukerRepository {

    public List<Bruker> hentAlleBrukere() {
        return List.copyOf(DummyDatabase.brukere);
    }

    public Optional<Bruker> hentBruker(int id) {
        return DummyDatabase.brukere.stream()
                .filter(bruker -> bruker.getBruker_id() == id)
                .findFirst();
    }
}
*/

import Database.DatabaseConnection;
import models.Bruker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrukerRepository {

    public List<Bruker> hentAlleBrukere() {

        List<Bruker> brukere = new ArrayList<>();

        String sql = "SELECT idBruker, Navn, Epost, Passord, Rolle FROM bruker";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Bruker bruker = new Bruker(
                        rs.getInt("idBruker"),
                        rs.getString("Navn"),
                        rs.getString("Epost"),
                        rs.getString("Passord"),
                        rs.getString("Rolle")
                );

                brukere.add(bruker);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente brukere fra databasen", e);
        }

        return brukere;
    }
    public Optional<Bruker> hentBruker(int id) {

        String sql = """
        SELECT idBruker, Navn, Epost, Passord, Rolle
        FROM bruker
        WHERE idBruker = ?
        """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Bruker bruker = new Bruker(
                            rs.getInt("idBruker"),
                            rs.getString("Navn"),
                            rs.getString("Epost"),
                            rs.getString("Passord"),
                            rs.getString("Rolle")
                    );

                    return Optional.of(bruker);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Kunne ikke hente bruker fra databasen", e
            );
        }

        return Optional.empty();
    }
    public Bruker opprettBruker(Bruker bruker) {

        String sql = """
        INSERT INTO bruker (Navn, Epost, Passord, Rolle)
        VALUES (?, ?, ?, ?)
        """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS
                )
        ) {

            stmt.setString(1, bruker.getNavn());
            stmt.setString(2, bruker.getEpost());
            stmt.setString(3, bruker.getPassord());
            stmt.setString(4, bruker.getRolle());

            int antall = stmt.executeUpdate();

            if (antall != 1) {
                throw new SQLException("Brukeren ble ikke opprettet");
            }

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    bruker.setBruker_id(keys.getInt(1));
                } else {
                    throw new SQLException("Ingen bruker-ID ble returnert");
                }
            }

            return bruker;

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Kunne ikke opprette bruker i databasen", e
            );
        }
    }
    public boolean oppdaterBruker(int id, String navn, String epost) {
        String sql = """
        UPDATE bruker
        SET Navn = ?, Epost = ?
        WHERE idBruker = ?
        """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, navn);
            stmt.setString(2, epost);
            stmt.setInt(3, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke oppdatere bruker", e);
        }
    }

    public boolean slettBruker(int id) {
        String sql = "DELETE FROM bruker WHERE idBruker = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke slette bruker", e);
        }
    }
}