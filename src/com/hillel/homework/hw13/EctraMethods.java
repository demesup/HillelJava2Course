package com.hillel.homework.hw13;


import com.hillel.homework.hw13.Objects.Book;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EctraMethods {
//    private static List<Book> enterAuthorsBooks(Author author) throws IOException, RuntimeException {
//        List<Book> authorBooks = new LinkedList<>();
//        try {
//            String choice = "yes";
//            while (choice.replaceAll(" ", "").equalsIgnoreCase("yes")) {
//                System.out.println("Enter title");
//                String title = READER.readLine();
//                int index = findObject(books, title);
//                if (index < 0) {
//                    books.add(createBook(title));
//                    index = books.size() - 1;
//                }
//                Book book = books.get(index);
//                if (book.getAuthor() == null) {
//                    book.setAuthor(author);
//                }
//                authorBooks.add(book);
//                System.out.println("Book is added to author books list");
//                System.out.println("Books:\n" + authorBooks);
//                System.out.println("Continue entering? yes/ any key");
//                choice = READER.readLine();
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Continue entering? yes/ any key");
//            if (READER.readLine().equalsIgnoreCase("yes")) enterAuthorsBooks(author);
//        } catch (ObjectDoesNorExist | ObjectAlreadyExistException e) {
//            System.out.println(e.getMessage());
//        }
//        return authorBooks;
//    }
}
