package Portfolio.filesort;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;

public class FileSortImpl implements FileSorter {
    private DataSource dataSource;

    public FileSortImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public File sort(File data) {
        final int BATCH_SIZE = 10000;
        batchReadAndDbWrite(data, BATCH_SIZE);
        sortAndWrite(BATCH_SIZE);
        return new File("sorted.txt");
    }

    private void sortAndWrite(int BATCH_SIZE) {
        String query = "SELECT * FROM numbers ORDER BY val DESC LIMIT " + BATCH_SIZE + " OFFSET ?;";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted.txt"));
             Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             Statement st = con.createStatement()) {
            int totalSize;
            ResultSet countVals = st.executeQuery("SELECT COUNT(val) FROM numbers;");
            countVals.next();
            totalSize = Integer.parseInt(countVals.getString(1));
            int counter = 0;
            for (int i = 0; i <= (totalSize / BATCH_SIZE); i++) {
                pst.setInt(1, counter);
                ResultSet tempLines = pst.executeQuery();
                while (tempLines.next()) {
                    writer.write(tempLines.getLong(1) + "\n");
                }
                counter += BATCH_SIZE;
            }
        } catch (SQLException | IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private void batchReadAndDbWrite(File data, int BATCH_SIZE) {
        String query = "INSERT INTO numbers(val) "
                + "VALUES(?)";
        try (BufferedReader reader = new BufferedReader(new FileReader(data));
             Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            String lineToRead;
            long currentNumber;
            int counter = 0;
            con.setAutoCommit(false);
            while ((lineToRead = reader.readLine()) != null) {
                currentNumber = Long.parseLong(lineToRead);
                pst.setLong(1, currentNumber);
                pst.addBatch();
                if (counter % BATCH_SIZE == 0) {
                    batchExec(con, pst);
                }
                counter++;
            }
            batchExec(con, pst);
        } catch (SQLException | IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
    private static void batchExec(Connection con, PreparedStatement pst) throws SQLException {
        try {
            pst.executeBatch();
            con.commit();
        } catch (BatchUpdateException exception) {
            System.err.println(exception.getMessage());
            con.rollback();
        }
    }
}

