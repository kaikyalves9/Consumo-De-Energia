import java.sql.*;

public class BancoDados {
    private Connection connection;

    public BancoDados(String url) throws SQLException {
        connection = DriverManager.getConnection(url);
        criarTabela();
    }

    private void criarTabela() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS consumo (id TEXT PRIMARY KEY, consumo REAL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void inserirConsumo(ConsumoEnergia consumo) {
        String sql = "INSERT OR REPLACE INTO consumo (id, consumo) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, consumo.getId());
            pstmt.setDouble(2, consumo.getConsumo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fechar() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
