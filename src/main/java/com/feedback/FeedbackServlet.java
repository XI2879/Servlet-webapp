package com.feedback;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackServlet extends HttpServlet {
    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user_management";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Naga@123";

    public   void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String reuestBody = getRequestBody(req);
//        System.out.println(reuestBody);
        String name = req.getParameter("name");
        String book = req.getParameter("book");
        String feedback = req.getParameter("feedback");


        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO feedback (name, book, feedback) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, book);
            statement.setString(3, feedback);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // Feedback saved successfully
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<html><body><h2>Feedback Saved</h2></body></html>");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Error occurred while saving feedback
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error saving feedback");
        }

    }


//    public String getRequestBody(HttpServletRequest req) throws IOException {
//        StringBuilder requestBody = new StringBuilder();
//        ServletInputStream inputStream = req.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        String line = bufferedReader.readLine();
//        while(line!=null){
//            requestBody.append(line);
//            line = bufferedReader.readLine();
//        }
//        return requestBody.toString();
//    }

}
