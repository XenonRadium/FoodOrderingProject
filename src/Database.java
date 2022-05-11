import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/123";

    static final String USER = "sa";
    static final String PASS = "";

    Connection conn = null;
    Statement stmt = null;

    public Database(){
        super();
        CreateDatabase();
    }

    public void CreateDatabase() {
        //Step 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);

            //Step 2: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 3: Execute a Query
            //System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE   FOODORDER " +
                    "(id INTEGER not NULL, " +
                    " foodoption VARCHAR(255), " +
                    " condiments VARCHAR(255), " +
                    " price DOUBLE, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            //System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        }catch (SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally {
            //finally block used to close resources
            try{
                if (conn != null) conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    }


    public void insertDatabase(int idValue, String foodOption, String Condiments, Double price){
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println("Connected database successfully...");

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO FOODORDER " + "VALUES (" + idValue + ", '" + foodOption + "', '" + Condiments + "', " + price + ")";
            //String sql = "INSERT INTO FOODORDER " + "VALUES (101, 'PokeBowl', 'Mustard',  13)";

            stmt.executeUpdate(sql);
            //System.out.println("Inserted records into the table...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        //System.out.println("Goodbye!");
    }

    public void ReadDatabase(){
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            //System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT id, foodoption, condiments, price FROM FOODORDER";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String foodoption = rs.getString("foodoption");
                String condiments = rs.getString("condiments");
                Double price = rs.getDouble("price");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Food Option: " + foodoption);
                System.out.print(", Condiments: " + condiments);
                System.out.println(", Price: " + price);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }

    public int CountDatabase(){
        int count = 0;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            //System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM FOODORDER";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                count = rs.getInt(1);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        //System.out.println("Goodbye!");
        return count;
    }

    public void DeleteDatabase(){
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            //System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM FOODORDER ";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the remaining records
            sql = "SELECT id, foodoption, condiments, price FROM FOODORDER";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Integer> array = new ArrayList<>();

            while(rs.next()){
                // Retrieve by column name
                int id  = rs.getInt("id");
                String foodoption = rs.getString("foodoption");
                String condiments = rs.getString("condiments");
                Double price = rs.getDouble("price");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Food Option: " + foodoption);
                System.out.print(", Condiments: " + condiments);
                System.out.println(", Price: " + price);
            }
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        //System.out.println("Goodbye!");
    }

    public int SelectDatabaseAsc(){
        int idValue = 0;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            //System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM FOODORDER ORDER BY id ASC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String foodoption = rs.getString("foodoption");
                String condiments = rs.getString("condiments");
                Double price = rs.getDouble("price");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Food Option: " + foodoption);
                System.out.print(", Condiments: " + condiments);
                System.out.println(", Price: " + price);

                idValue = id;
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        //System.out.println("Goodbye!");
//        System.out.println(TotalPrice);

        return idValue;
    }


    public int SelectDatabaseDesc(){
        int idValue = 0;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            //System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM FOODORDER ORDER BY id DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String foodoption = rs.getString("foodoption");
                String condiments = rs.getString("condiments");
                Double price = rs.getDouble("price");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Food Option: " + foodoption);
                System.out.print(", Condiments: " + condiments);
                System.out.println(", Price: " + price);

                idValue = id;
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
//        System.out.println(TotalPrice);

        return idValue;
    }
}


