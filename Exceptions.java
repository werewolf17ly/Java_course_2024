class DocumentParseException extends Exception {
    public DocumentParseException(String message) {
        super(message);
    }
}

class DocumentNotFoundException extends Exception {
    public DocumentNotFoundException(String message) {
        super(message);
    }
}

class UnsupportedValueTypeException extends Exception {
    public UnsupportedValueTypeException(String message) {
        super(message);
    }
}

class MissingFieldException extends Exception {
    public MissingFieldException(String message) {
        super(message);
    }
}