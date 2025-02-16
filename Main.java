import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentParser parser = new DocumentParser();
        Library<Document> library = new Library<>();

        try {
            // Example of parsing a document from a JSON file
            Document contract = parser.parse("src/tests/contract.json");
            library.addDocument(contract);
            System.out.println("Added: " + contract);

            Document receipt = parser.parse("src/tests/receipt.json");
            library.addDocument(receipt);
            System.out.println("Added: " + receipt);

            Document resume = parser.parse("src/tests/resume.json");
            library.addDocument(resume);
            System.out.println("Added: " + resume);

            // Example of retrieving a document
            Document retrieved = library.getDocument("A1");
            System.out.println("Retrieved: " + retrieved);

            // Example of removing a document
            library.removeDocument("A1");
            System.out.println("Document A1 removed.");

        } catch (IOException | DocumentParseException | DocumentNotFoundException | UnsupportedValueTypeException |
                 MissingFieldException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}