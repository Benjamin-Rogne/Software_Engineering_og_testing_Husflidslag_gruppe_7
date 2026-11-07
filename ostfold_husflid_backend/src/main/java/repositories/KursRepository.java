package repositories;

import Database.DatabaseConnection;
import models.Kurs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KursRepository implements KursRepositoryInterface { // Bruk implements også her!

    private Kurs mapKurs(ResultSet rs) throws SQLException {
        Kurs kurs = new Kurs();

        kurs.setKurs_id(rs.getInt("idKurs"));
        kurs.setTittle(rs.getString("Tittel"));
        //kurs.setBeskrivelse(rs.getString("Beskrivelse"));
        kurs.setStart_dato(rs.getTimestamp("StartDato").toLocalDateTime());
        kurs.setSlutt_dato(rs.getTimestamp("SluttDato").toLocalDateTime());
        //kurs.setSted(rs.getString("Sted"));
        kurs.setPris(rs.getFloat("Pris"));
        kurs.setOmraade_id(rs.getInt("idOmraade"));
        kurs.setKursholder_id(rs.getInt("idKursholder"));

        int adresseId = rs.getInt("adresse_id");
        if (!rs.wasNull()) {
            kurs.setAdresse_id(adresseId);
        }

        //kurs.setBilde(rs.getString("Bilde"));

        return kurs;
    }

    @Override
    public List<Kurs> hentAlleKurs() {
        List<Kurs> kursListe = new ArrayList<>();
        String sql = "SELECT * FROM kurs";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                kursListe.add(mapKurs(rs));
                // Hent ut data fra databasen...
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente kurs", e);
        }
        return kursListe;
    }

    @Override
    public Optional<Kurs> hentKurs(int kurs_id) {
        String sql = "SELECT * FROM kurs WHERE idKurs = ?";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, kurs_id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapKurs(rs));

                    /*
                    Kurs kurs = new Kurs(
                            rs.getInt("kurs_id"),
                            rs.getString("tittle"),
                            rs.getTimestamp("start_dato").toLocalDateTime(),
                            rs.getTimestamp("slutt_dato").toLocalDateTime(),
                            rs.getFloat("pris"),
                            rs.getInt("omraade_id"),
                            rs.getInt("kursholder_id"),
                            rs.getInt("paamelding_id"),
                            rs.getInt("adresse")
                    );
                    return Optional.of(kurs);

                     */
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente kurs med ID: " + kurs_id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Kurs> hentKursEtterOmraade(int omraade_id) {
        List<Kurs> kursListe = new ArrayList<>();
        String sql = "SELECT * FROM kurs WHERE idOmraade = ?";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, omraade_id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    kursListe.add(mapKurs(rs));

                    /*
                    Kurs kurs = new Kurs(
                            rs.getInt("kurs_id"),
                            rs.getString("tittle"),
                            rs.getTimestamp("start_dato").toLocalDateTime(),
                            rs.getTimestamp("slutt_dato").toLocalDateTime(),
                            rs.getFloat("pris"),
                            rs.getInt("omraade_id"),
                            rs.getInt("kursholder_id"),
                            rs.getInt("paamelding_id"),
                            rs.getInt("adresse")
                    );
                    kursListe.add(kurs);

                     */
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente kurs for område_id: " + omraade_id, e);
        }
        return kursListe;
    }

    @Override
    public void leggTilKurs(Kurs nyttKurs) {
        String sql = "INSERT INTO kurs (Tittel, Beskrivelse, StartDato, SluttDato, Sted, Pris, idOmraade, idKursholder, adresse_id, Bilde) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setInt(8, nyttKurs.getAdresse_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke legge til nytt kurs", e);
        }
    }

    @Override
    public void oppdaterKurs(int kurs_id, Kurs oppdatertKurs) {

    }

    @Override
    public void slettKurs(int kurs_id) {

    }


}