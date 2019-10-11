package javaapplication34;

import java.io.*;
import javax.xml.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

public class ValidatorX {

    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename = "filex.xml";
        String schemaName = "schema.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {// создание схемы
            Schema schema = factory.newSchema(schemaLocation);// создание валидатора на основе схемы
            Validator validator = schema.newValidator();// проверка документа
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println(filename + " is valid.");
        } catch (SAXException e) {
            System.err.print("validation " + filename + " is not valid because "
                    + e.getMessage()
            );
        } catch (IOException e) {
            System.err.print(filename + " is not valid because "
                    + e.getMessage()
            );
        }
    }
}
