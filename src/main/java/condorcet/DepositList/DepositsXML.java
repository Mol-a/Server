package condorcet.DepositList;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Deposits")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositsXML {
    @XmlElement(name = "DepositList")
    private List<DepositC> deposits = null;

    public List<DepositC> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<DepositC> deposits) {
        this.deposits = deposits;
    }
}
