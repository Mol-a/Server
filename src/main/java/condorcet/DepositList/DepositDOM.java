package condorcet.DepositList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DepositDOM {
    public static final String filename = "C:\\Users\\Mila\\IdeaProjects\\Condorcet_Server\\Condorcet_Server\\src\\main\\java\\data\\deposit.xml";

    public List<DepositList> unmarshall() throws JAXBException {
        //List<DepositC> list = new ArrayList<>();

        List<DepositList> list = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(DepositsXML.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        DepositsXML deposits = (DepositsXML) unmarshaller.unmarshal(new File(filename));
        for (DepositC depositC : deposits.getDeposits()) {
            list.add(new DepositList(depositC.getDeposit_number(), depositC.getDeposit_name(), depositC.getstorageTime(), depositC.getinterestRate(), depositC.getrateType(), depositC.getAmount_operation(), depositC.getresponceName()));
            System.out.println(depositC.getClass());

        }
        return list;
    }

}
