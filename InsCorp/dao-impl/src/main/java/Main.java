import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.daoimpl.hb.PolicyDaoImpl;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.policy.GO;

/**
 * Created by ShenaiKabilova
 */
public class Main {
    public static void main(String[] args) {
        PolicyDao dao = new PolicyDaoImpl();
        try {
            if(dao.getPolicaByPolicaNum("000004") instanceof GO) {
                GO go = (GO) dao.getPolicaByPolicaNum("000004");
            } else System.out.println("ne e namerena polica");
        } catch (InsCorpException e) {
            e.printStackTrace();
        }
    }
}
