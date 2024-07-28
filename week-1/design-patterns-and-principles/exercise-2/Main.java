// Creating the interfaces for the documents.
interface Document {
    void create();
}

interface WordDocument extends Document {
    void edit();
}

interface PdfDocument extends Document {
    void view();
}

interface ExcelDocument extends Document {
    void calculate();
}

// Creating the concrete class
class Word implements WordDocument {
    @Override
    public void create() {
        System.out.println("Creating the word document.");
    }

    @Override
    public void edit() {
        System.out.println("Editing the word document.");
    }
}

class Pdf implements PdfDocument {
    @Override
    public void create() {
        System.out.println("Creating the Pdf document.");
    }

    @Override
    public void view() {
        System.out.println("Viewing the Pdf document.");
    }
}

class Excel implements ExcelDocument {
    @Override
    public void create() {
        System.out.println("Creating the Excel document.");
    }

    @Override
    public void calculate() {
        System.out.println("Calculating the Excel data.");
    }
}

// Now creating the factory here

interface DocumentFactory {
    Document createDocument();
}

class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new Word();
    }
}

class PdfDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new Pdf();
    }
}

class ExcelDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new Excel();
    }
}

public class Main {
    public static void main(String[] args) {
        //        pdf file
        DocumentFactory factory = new PdfDocumentFactory();
        Document pdf = factory.createDocument();
        pdf.create();
        ((PdfDocument) pdf).view();

        //      Word File
        factory = new WordDocumentFactory();
        Document word = factory.createDocument();
        word.create();
        ((WordDocument) word).edit();

        //      Excel File
        factory = new ExcelDocumentFactory();
        Document excel = factory.createDocument();
        excel.create();
        ((ExcelDocument) excel).calculate();
    }
}



