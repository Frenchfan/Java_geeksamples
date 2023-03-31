package Portfolio.movie;

import Portfolio.DbUtil;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;

public class MovieTest {
  public static void main(String[] args) throws SQLException {
    DataSource dataSource = initDb();
    MovieLoader movieLoader = new MovieLoaderImpl(dataSource);

    File dataFile = new File("film.csv");
    movieLoader.loadData(dataFile);

    /**
     * Тут написать в комментариях запрос получения всех фильмов, сгруппированных по жанрам
     * SELECT subject, COUNT(*) AS count from movie GROUP BY SUBJECT;
     */
  }

  private static DataSource initDb() throws SQLException {
    String createMovieTable = "drop table if exists movie;"
                                  + "CREATE TABLE IF NOT EXISTS movie (\n"
                                  + "\tid bigserial NOT NULL,\n"
                                  + "\t\"year\" int4,\n"
                                  + "\tlength int4,\n"
                                  + "\ttitle varchar,\n"
                                  + "\tsubject varchar,\n"
                                  + "\tactors varchar,\n"
                                  + "\tactress varchar,\n"
                                  + "\tdirector varchar,\n"
                                  + "\tpopularity int4,\n"
                                  + "\tawards bool,\n"
                                  + "\tCONSTRAINT movie_pkey PRIMARY KEY (id)\n"
                                  + ");";
    DataSource dataSource = DbUtil.buildDataSource();
    DbUtil.applyDdl(createMovieTable, dataSource);
    return dataSource;
  }
}
