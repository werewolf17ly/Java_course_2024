import java.util.HashMap;
import java.util.Map;

class Library<T extends Document> {
    private final Map<String, T> documents = new HashMap<>();

    public void addDocument(T document) throws DocumentNotFoundException {
        if (documents.containsKey(document.getId())) {
            throw new DocumentNotFoundException("Document with ID " + document.getId() + " already exists.");
        }
        documents.put(document.getId(), document);
    }

    public T getDocument(String id) throws DocumentNotFoundException {
        T document = documents.get(id);
        if (document == null) {
            throw new DocumentNotFoundException("Document with ID " + id + " not found.");
        }
        return document;
    }

    public void removeDocument(String id) throws DocumentNotFoundException {
        if (!documents.containsKey(id)) {
            throw new DocumentNotFoundException("Document with ID " + id + " not found.");
        }
        documents.remove(id);
    }
}
