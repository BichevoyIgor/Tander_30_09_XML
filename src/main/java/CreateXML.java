
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreateXML {
    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document doc;

    public CreateXML() throws ParserConfigurationException {
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.newDocument();
    }

    void xmlWithAttribute(List<Article> articles) {
        Element root = doc.createElement("articles");
        for (Article article : articles) {
            Element inner = doc.createElement("articles");
            inner.setAttribute("id_art", String.valueOf(article.getId_art()));
            inner.setAttribute("name", article.getName());
            inner.setAttribute("code", article.getCode());
            inner.setAttribute("username", article.getUserName());
            inner.setAttribute("guid", article.getGuid());
            root.appendChild(inner);
        }
        doc.appendChild(root);
        writeXML(doc);
    }

    private void writeXML(Document doc) {
        Transformer transformer = null;
        DOMSource src = null;
        FileOutputStream fileOutputStream = null;
        InputStream inputXSL = getClass().getResourceAsStream("/template2.xsl"); //шаблон построения XML step1
        try {
            StreamSource xslStream = new StreamSource(inputXSL); //шаблон построения XML step2
            TransformerFactory factory = TransformerFactory.newInstance();
            transformer = factory.newTransformer(xslStream); // //шаблон построения XML step3
           // transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // перенос
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");

            src = new DOMSource(doc);

            Path firstXML = Paths.get("1.xml");
            fileOutputStream = new FileOutputStream(firstXML.toAbsolutePath().toString());
            StreamResult result = new StreamResult(fileOutputStream);
            transformer.transform(src, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
