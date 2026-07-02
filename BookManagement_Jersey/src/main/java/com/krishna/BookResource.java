package com.krishna;
import java.util.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("books")
public class BookResource {
    BookRepository repo= new BookRepository();

    @PUT
    @Path("uploadbookbyid")
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public void uploadBook(BookModel b1){
        if(repo.getBookById(b1.getBookNumber())==null){
            System.out.println("Inserting book " + b1.getBookNumber());
            repo.uploadBook(b1);
        }else{
            System.out.println("Updating book " + b1.getBookNumber());
            repo.updateBook(b1);
        }
    }

    @DELETE
    @Path("delete/{BookNumber}")
    public BookModel delete(@PathParam("BookNumber") int Booknumber ){
        BookModel bm= repo.getBookById(Booknumber);
        if(bm!=null){
            System.out.println("Book Deleted");
            repo.deleteBook(bm);
        }
        return bm;
    }

    @POST
    @Path("uploadbyname")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
    public BookModel uploadBookByName(BookModel BookName){
        System.out.println(BookName);
        repo.uploadBook(BookName);
        return BookName;
    }

    @PUT
    @Path("update/{BookNumber}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BookModel updateBook(@PathParam("BookNumber") int BookNumber, BookModel b1){
        if(repo.getBookById(BookNumber) == null){
            repo.uploadBook(b1);
        }else{
            repo.updateBook(b1);
        }
        return b1;
    }
    @GET
    @Path("Allbooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookModel> getAllBooks(){
        return repo.getAllBooks();
    }
    @GET
    @Path("onebook/{BookNumber}")
    @Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
    public BookModel getBookById(@PathParam("BookNumber") int BookNumber){
        return repo.getBookById(BookNumber);
    }
}
