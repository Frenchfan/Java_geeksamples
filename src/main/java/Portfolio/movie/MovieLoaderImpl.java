package Portfolio.movie;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieLoaderImpl implements MovieLoader {
    private DataSource dataSource;

    public MovieLoaderImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadData(File file) {
        String query = "INSERT INTO movie(year, length, title, subject, actors, actress, director, popularity, awards)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            //omitting the first two lines from the csv source
            String currentLine = reader.readLine();
            currentLine = reader.readLine();
            Movie currentMovie;
            while ((currentLine = reader.readLine()) != null) {
                currentMovie = parseToMovie(currentLine);
                addParams(pst, currentMovie);
                pst.executeUpdate();
            }
        } catch (IOException | SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private void addParams(PreparedStatement pst, Movie movie) throws SQLException {

        if (movie.getYear() != 0) {
            pst.setInt(1, movie.getYear());
        } else {
            pst.setNull(1, java.sql.Types.INTEGER);
        }
        if (movie.getLength() != 0) {
            pst.setInt(2, movie.getLength());
        } else {
            pst.setNull(2, java.sql.Types.INTEGER);
        }
        pst.setString(3, movie.getTitle());
        pst.setString(4, movie.getSubject());
        pst.setString(5, movie.getActors());
        pst.setString(6, movie.getActress());
        pst.setString(7, movie.getDirector());
        if (movie.getPopularity() != 0) {
            pst.setInt(8, movie.getPopularity());
        } else {
            pst.setNull(8, java.sql.Types.INTEGER);
        }
        pst.setBoolean(9, movie.getAwards());
    }

    private Movie parseToMovie(String currentLine) {
        Movie movie = new Movie();
        String[] temp = currentLine.split(";");
        int year = 0, length = 0, popularity = 0;
        boolean awards;
        try {
            if (!"".equals(temp[0])) {
                year = Integer.parseInt(temp[0]);
            }
            movie.setYear(year);
            if (!"".equals(temp[1])) {
                length = Integer.parseInt(temp[1]);
            }
            movie.setLength(length);
            for (int i = 2; i < 7; i++) {
                temp[i] = "".equals(temp[i]) ? null : temp[i];
            }
            movie.setTitle(temp[2]);
            movie.setSubject(temp[3]);
            movie.setActors(temp[4]);
            movie.setActress(temp[5]);
            movie.setDirector(temp[6]);
            if (!"".equals(temp[7])) {
                popularity = Integer.parseInt(temp[7]);
            }
            movie.setPopularity(popularity);
            awards = "Yes".equals(temp[8]);
            movie.setAwards(awards);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return movie;
    }
}
