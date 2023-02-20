package com.Sorlo.game.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Aceasta clasa initializeaza tabela in SQL in care vor fi inregistrate starea in care se afla jocul,
 * Melodia aleasa pentru a il juca
 * numarul de butoaie
 * si numarul de chei colectate
 */
public class Table {


    /**
     * adauga intrarile in tabela pentru a ne ajuta mai departe sa vedem care este ultima intrare introduse,
     * ajutandu-ne sa reluam jocul de la nivelul ramas si cu melodia aleasa
     * @param _statement
     * @param MELODI
     * @param state
     * @param poz
     * @param nrbutoaie
     * @param nrchei
     * @throws SQLException
     */
    public static void AddEntry(Statement _statement, String MELODI, int state, int poz, int nrbutoaie, int nrchei) throws SQLException {
        String sql = "INSERT INTO PROGRAM (MELODIE,STATE,POZITIE,NRCHEI,NRBUTOAIE) " +
                "VALUES ('" + MELODI + "', " + state + ", " + poz + ", " + nrbutoaie + ", " + nrchei + ");";
        _statement.executeUpdate(sql);
    }


    /**
     * creeaza tabela care va avea coloanele MELODIE pentru melodia aleasa, STATE pentru starea in care se afla jocul, POZITIE pentru pozitia mapei in momentul in care am inchis jocul,
     * , NRCHEI pentru numarul de chei colectate si NRBUTOAIE pentru numarul de butoaie colectate
     * @param st
     * @throws SQLException
     */
    public static void createTable(Statement st) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS PROGRAM " +
                    "(MELODIE   STRING    NOT NULL, " +
                    "STATE INT , "+
                    "POZITIE INT , "+
                     "NRCHEI INT , "+
                     "NRBUTOAIE INT )";
        st.executeUpdate(sql);


    }

    /**
     * selecteaza ultima intrare din tabela din coloana de Muzica pentru a putea fi folosita la pornirea jocului de unde a ramas
     * @param s
     * @return
     * @throws SQLException
     */
    public static String SelectLast(Statement s) throws SQLException {
        String sql=("SELECT MELODIE FROM PROGRAM ORDER BY _rowid_   DESC LIMIT 1;");

        ResultSet p=s.executeQuery(sql);

        return p.getString("MELODIE");
    }


    /**
     * selecteaza ultima intrare din tabela din coloana de POZITIE pentru a putea fi folosita la pornirea jocului de unde a ramas
     * @param s
     * @return
     * @throws SQLException
     */
    public static int SelectLastP(Statement s) throws SQLException {
        String sql=("SELECT POZITIE FROM PROGRAM ORDER BY _rowid_   DESC LIMIT 1;");

        ResultSet p=s.executeQuery(sql);

        return p.getInt("POZITIE");
    }

    /**
     * selecteaza ultima intrare din tabela din coloana de NRBUTOAIE pentru a putea fi folosita la pornirea jocului de unde a ramas
     * @param s
     * @return
     * @throws SQLException
     */
    public static int SelectLastB(Statement s) throws SQLException {
        String sql=("SELECT NRBUTOAIE FROM PROGRAM ORDER BY _rowid_   DESC LIMIT 1;");

        ResultSet p=s.executeQuery(sql);

        return p.getInt("NRBUTOAIE");
    }

    /**
     * selecteaza ultima intrare din tabela din coloana de NRCHEI pentru a putea fi folosita la pornirea jocului de unde a ramas
     * @param s
     * @return
     * @throws SQLException
     */

    public static int SelectLastC(Statement s) throws SQLException {
        String sql=("SELECT NRCHEI FROM PROGRAM ORDER BY _rowid_   DESC LIMIT 1;");

        ResultSet p=s.executeQuery(sql);

        return p.getInt("NRCHEI");
    }


    /**
     * selecteaza ultima intrare din tabela din coloana de STATE pentru a putea fi folosita la pornirea jocului de unde a ramas
     * @param s
     * @return
     * @throws SQLException
     */
    public static int SelectLastS(Statement s) throws SQLException {
        String sql=("SELECT STATE FROM PROGRAM ORDER BY _rowid_   DESC LIMIT 1;");

        ResultSet p=s.executeQuery(sql);

        return p.getInt("STATE");
    }









}
