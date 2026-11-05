package repositories;

import Database.DatabaseConnection;
import models.Kurs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KursRepository {


    public List<Kurs> hentAlleKurs() {
        List<Kurs> kursListe = new ArrayList<>();
        String sql = "SELECT kurs_id, tittle, start_dato, slutt_dato, pris, omraade_id, kursholder_id, paamelding_id, adresse FROM kurs";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                rs.getInt("kurs_id");
                rs.getString("tittel");
                rs.getDate("start_dato");
                rs.getDate("slutt_dato");
                rs.getDouble("pris");
                rs.getInt("omraade_id");
                rs.getInt("kursholder_id");
                rs.getInt("paamelding_id");
                rs.getString("adresse");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente kurs", e);
        }
        return kursListe;
    }


    public Optional<Kurs> hentKurs(int kurs_id) {
        String sql = "SELECT * FROM kurs WHERE kurs_id = ?";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, kurs_id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Kurs kurs = new Kurs(
                            rs.getInt("kurs_id"),
                            rs.getString("tittle"),
                            rs.getTimestamp("start_dato").toLocalDateTime(),
                            rs.getTimestamp("slutt_dato").toLocalDateTime(),
                            rs.getFloat("pris"),
                            rs.getInt("omraade_id"),
                            rs.getInt("kursholder_id"),
                            rs.getInt("paamelding_id"),
                            rs.getString("adresse")
                    );
                    return Optional.of(kurs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente kurs med ID: " + kurs_id, e);
        }
        return Optional.empty();
    }


    public List<Kurs> hentKursEtterOmraade(int omraade_id) {
        List<Kurs> kursListe = new ArrayList<>();
        String sql = "SELECT * FROM kurs WHERE omraade_id = ?";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, omraade_id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Kurs kurs = new Kurs(
                            rs.getInt("kurs_id"),
                            rs.getString("tittle"),
                            rs.getTimestamp("start_dato").toLocalDateTime(),
                            rs.getTimestamp("slutt_dato").toLocalDateTime(),
                            rs.getFloat("pris"),
                            rs.getInt("omraade_id"),
                            rs.getInt("kursholder_id"),
                            rs.getInt("paamelding_id"),
                            rs.getString("adresse")
                    );
                    kursListe.add(kurs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente kurs for område: " + omraade_id, e);
        }
        return kursListe;
    }


    public void leggTilKurs(Kurs nyttKurs) {
        String sql = "INSERT INTO kurs (tittle, start_dato, slutt_dato, pris, omraade_id, kursholder_id, paamelding_id, adresse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, nyttKurs.getTittle());
            stmt.setTimestamp(2, Timestamp.valueOf(nyttKurs.getStart_dato()));
            stmt.setTimestamp(3, Timestamp.valueOf(nyttKurs.getSlutt_dato()));
            stmt.setFloat(4, nyttKurs.getPris());
            stmt.setInt(5, nyttKurs.getOmraade_id());
            stmt.setInt(6, nyttKurs.getKursholder_id());
            stmt.setInt(7, nyttKurs.getPaamelding_id());
            stmt.setString(8, nyttKurs.getAdresse());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke legge til nytt kurs", e);
        }
    }


    public void oppdaterKurs(int kurs_id, Kurs oppdatertKurs) {

    }


    public void slettKurs(int kurs_id) {

    }


}