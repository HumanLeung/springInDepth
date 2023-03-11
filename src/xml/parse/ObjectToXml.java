package xml.parse;

import xml.entity.Answer;
import xml.entity.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Administrator
 */
public class ObjectToXml {
    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext contextObj = JAXBContext.newInstance(Question.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        Answer ans1 = new Answer(101,"java is a programming language","ravi");
        Answer ans2=new Answer(102,"java is a platform","john");

        ArrayList<Answer> list=new ArrayList<>();
        list.add(ans1);
        list.add(ans2);

        Question question = new Question(1,"What is java",list);
        marshallerObj.marshal(question, Files.newOutputStream(Paths.get("src/xml/files/questionOutPut.xml")));
    }
}
