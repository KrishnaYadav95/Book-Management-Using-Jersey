package com.krishna;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    Connection con=null;
    public BookRepository() {
        String url="jdbc:mysql://localhost:3306/bookDb";
        String username="root";
        String password="12345678";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, username , password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadBook(BookModel bookname){
        String sql = "insert into book values(?, ? , ?)";
        try{
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1, bookname.getBookNumber());
            st.setString(2, bookname.getBookName());
            st.setString(3, bookname.getAuthor());
            int rowAffected= st.executeUpdate();
            if(rowAffected>0){
                System.out.println("Book Inserted");
            }else{
                System.out.println("Failed to Insert");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBook(BookModel booknumber){
        String sql= "delete from book where BookNumber=?";
        try{
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1, booknumber.getBookNumber());
            int row=st.executeUpdate();
            if(row>0){
                System.out.println("Book Deleted");
            }else{
                System.out.println("Failed to Delete");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public BookModel getBookById(int id){
        String sql= "select * from book where BookNumber= ?";
        BookModel book = null;
        try{
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                book= new BookModel();
                book.setBookNumber(rs.getInt("BookNumber"));  // "id" -> "BookNumber"
                book.setBookName(rs.getString("BookName"));
                book.setAuthor(rs.getString("Author"));       // setBookName -> setAuthor
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
    public List<BookModel> getAllBooks(){
        List<BookModel> books= new ArrayList<>();
        String sql = "select * from book";
        try{
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                BookModel bm =new BookModel();
                bm.setBookNumber(rs.getInt(1));
                bm.setBookName(rs.getString(2));
                bm.setAuthor(rs.getString(3));

                books.add(bm);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public void updateBook(BookModel booknumber) {
        String sql = "update book set BookName=? , Author=? where BookNumber=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1 , booknumber.getBookName());
            st.setString(2 , booknumber.getAuthor());
            st.setInt(3, booknumber.getBookNumber());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
