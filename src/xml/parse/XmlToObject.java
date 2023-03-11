package xml.parse;

import xml.entity.Answer;
import xml.entity.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * @author Administrator
 */
public class XmlToObject {
    public static void main(String[] args) throws JAXBException {
        File file = new File("src/xml/files/question.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Question que = (Question) jaxbUnmarshaller.unmarshal(file);

        System.out.println(que.getId()+"---"+que.getQuestionName());
        System.out.println("Answer:");
        List<Answer> list = que.getAnswers();
        for (Answer ans: list){
            System.out.println(ans.getId()+"---"+ans.getAnswerName()+"---"+ans.getPostedBy());
        }
    }
}
