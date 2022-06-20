package com.hillel.homework.hw13;


import com.hillel.homework.hw13.Objects.LibraryObjects;
import com.hillel.homework.hw13.enums.AvailableActions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ExtraMethods {

    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));


    public static int findObject(List<? extends LibraryObjects> objects, String name) {
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return objects.indexOf(object);
        }
        return -1;
    }

    public static boolean checkIfHave(List<? extends LibraryObjects> objects, String name) {
        if (objects.size() == 0) return false;
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public static AvailableActions getAction() throws IOException {
        System.out.println("Enter action: add, remove, print all/press any key to exit");
        String string = READER.readLine().replaceAll(" ", "");

        AvailableActions action = null;

        for (AvailableActions avAction : AvailableActions.values()) {
            if (avAction.name().equalsIgnoreCase(string)) {
                action = AvailableActions.valueOf(string.toUpperCase());
                break;
            }
        }
        if (action == null) {
            throw new IllegalArgumentException("You can enter only action");
        }
        return action;
    }

    static int readNumber() throws IOException {
        return Integer.parseInt(READER.readLine());
    }


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
