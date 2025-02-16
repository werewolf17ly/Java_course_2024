class Document {
    protected String id;
    protected String documentType;

    public String getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

}

class Contract extends Document {
    private final int cost;
    private final String date;

    public Contract(String id, int cost, String date) {
        this.id = id;
        this.cost = cost;
        this.date = date;
        this.documentType = "CONTRACT";
    }

    @Override
    public String toString() {
        return "Contract{id='" + id + "', cost=" + cost + ", date='" + date + "'}";
    }
}

class Receipt extends Document {
    private final int moneyAmount;

    public Receipt(String id, int moneyAmount) {
        this.id = id;
        this.moneyAmount = moneyAmount;
        this.documentType = "RECEIPT";
    }

    @Override
    public String toString() {
        return "Receipt{id='" + id + "', moneyAmount=" + moneyAmount + "}";
    }
}

class Resume extends Document {
    private final String name;

    public Resume(String id, String name) {
        this.id = id;
        this.name = name;
        this.documentType = "RESUME";
    }

    @Override
    public String toString() {
        return "Resume{id='" + id + "', name='" + name + "'}";
    }
}
