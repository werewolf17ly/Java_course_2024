import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

class DocumentParser {

    public Document parse(String fileName) throws IOException, DocumentParseException, UnsupportedValueTypeException, MissingFieldException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        reader.close();

        String json = jsonBuilder.toString();
        return parseJson(json);
    }

    private Document parseJson(String json) throws DocumentParseException, UnsupportedValueTypeException, MissingFieldException {
        String id = extractField(json, "id");
        String documentType = extractField(json, "document_type");

        if (documentType == null) {
            throw new MissingFieldException("Missing field: document_type");
        }

        switch (documentType) {
            case "CONTRACT":
                int cost = Integer.parseInt(Objects.requireNonNull(extractField(json, "cost")));
                String date = extractField(json, "date");
                return new Contract(id, cost, date);
            case "RECEIPT":
                int moneyAmount = Integer.parseInt(Objects.requireNonNull(extractField(json, "money_amount")));
                return new Receipt(id, moneyAmount);
            case "RESUME":
                String name = extractField(json, "name");
                return new Resume(id, name);
            default:
                throw new UnsupportedValueTypeException("Unsupported document type: " + documentType);
        }
    }

    private String extractField(String json, String field) {
        String key = "\"" + field + "\":";
        int startIndex = json.indexOf(key);
        if (startIndex == -1) return null;

        startIndex += key.length();
        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = json.indexOf("}", startIndex);
        }

        String value = json.substring(startIndex, endIndex).trim();
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else {
            return value;
        }
    }
}