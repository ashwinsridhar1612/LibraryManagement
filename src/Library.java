import java.util.HashMap;
import java.util.Map;

public class Library implements LibraryInterface{
    Map<Integer,Book> books = new HashMap<>();
    Validation validation = new Validation();


    @Override
    public void addBook() {
        System.out.println("Book Id : "+(Book.getNumber()+1));
        String title = validation.authorTitle("title");
        String author = validation.authorTitle("author");
        String publishingYear = validation.validYear();
        Book book = new Book(title,author,publishingYear,"Available");
        books.put(book.getId(), book);
        System.out.println("BOOK ADDED SUCCESSFULLY\n");
        showBookDetails(book);
    }

    @Override
    public void showAllBooks() {
        if(books.size()==0){
            System.out.println("NO BOOKS AVAILABLE");
            return;
        }
        System.out.printf("%-8s%-10s%-10s%-10s%-15s\n","BOOK ID","TITLE","AUTHOR","PUBLISHED","STATUS");
        for(Book book:books.values())
            System.out.printf("%-8s%-10s%-10s%-10s%-15s\n",book.getId(),book.getTitle(),book.getAuthor(),
                    book.getPublishingYear(),book.getStatus());
    }

    public void showAvailableBooks(){
        if(books.size()==0){
            System.out.println("NO BOOKS AVAILABLE");
            return;
        }
        System.out.printf("%-8s%-10s%-10s%-10s%-15s\n","BOOK ID","TITLE","AUTHOR","PUBLISHED","STATUS");
        for(Book book:books.values()) {
            if(book.getStatus().equals("Available"))
                System.out.printf("%-8s%-10s%-10s%-10s%-15s\n", book.getId(), book.getTitle(), book.getAuthor(),
                        book.getPublishingYear(), book.getStatus());
        }
    }

    @Override
    public void borrow() {
        if(books.size()==0){
            System.out.println("NO BOOKS AVAILABLE");
            return;
        }
        int id = validation.validId(books);
        if(!books.containsKey(id)) return;
        if(books.get(id).getStatus().equals("Not Available")){
            System.out.println("This Book is Currently Not Available");
            return;
        }
        books.get(id).setStatus("Not Available");
        System.out.println("borrowed Successfully\n");
        showBookDetails(books.get(id));
    }

    @Override
    public void returnBook() {
        if(books.size()==0){
            System.out.println("NO BOOKS TO RETURN");
            return;
        }
        int id = validation.validId(books);
        if(!books.containsKey(id)) return;
        if(books.get(id).getStatus().equals("Available")){
            System.out.println("We can not return this book");
            return;
        }
        books.get(id).setStatus("Available");
        System.out.println("Return Successfully\n");
        showBookDetails(books.get(id));
    }

    public void showBookDetails(Book book){
        System.out.println(" BOOK DETAILS");
        System.out.printf("%-9s : %d\n%-9s : %s\n%-9s : %s\n%-9s : %s\n","BOOK ID",book.getId(),"TITLE",
                book.getTitle(),"AUTHOR",book.getAuthor(),"PUBLISHED",book.getPublishingYear());
    }
}
