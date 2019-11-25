package phl.claim.claimsubmition.services.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phl.claim.claimsubmition.models.ClaimSubmition;
import phl.claim.claimsubmition.repository.ClaimSubmitionRespository;
import phl.claim.claimsubmition.services.ClaimsumitionService;

@Service
public class ClaimsumitionServiceImpl implements ClaimsumitionService {
        @Autowired
        private EntityManagerFactory entityManagerFactory;

        private ClaimSubmitionRespository claimSubmitionRespository;

        @Autowired
        public ClaimsumitionServiceImpl(ClaimSubmitionRespository claimSubmitionRespository) {
                this.claimSubmitionRespository = claimSubmitionRespository;
        }

        @Override
        public List<ClaimSubmition> findAll(String poNumber, String laIdNumber) {

                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
                        StringBuilder sql = new StringBuilder();
                        sql.append("SELECT ID, PO_NUMBER, LA_NAME, LA_IDNUMBER, LA_ADDRESS, LA_PHONE, RQ_NAME, RQ_IDNUMBER, RQ_ADDRESS, RQ_PHONE, EVENT_DATE,\n");
                        sql.append(" EVENT_PLACE, EVENT_REASON, BENIFIT_TYPE, HOSPITALIZED_DATE_IN, \n");
                        sql.append(" HOSPITALIZED_DATE_OUT, DIAGONOSTIC, HOSPITAL, DOCTOR, HOSPITAL_HEALTHINS, EVENT_DISCRIPTION, \n");
                        sql.append(" PAYMENT_MOTHOD, ACCOUNT_NAME, ACCOUNT_IDCARD_DATE, ACCOUNT_IDCARD, ACCOUNT_NUMBER, \n");
                        sql.append(" ACCOUNT_HOLDER, ORTHER_INSURANCE, ISR1_NAME, ISR1_EFF_DATE, ISR1_AMOUNT, ISR2_NAME, \n");
                        sql.append(" ISR2_EFF_DATE, ISR2_AMOUNT, DATE_SUBMIT, DATE_UPDATE, DATE_DELETE, BANK, STATUS \n");
                        sql.append(" FROM            Claim_Submition \n");
                        sql.append(" WHERE PO_NUMBER =:poNumber and DATE_DELETE is null \n");
                        sql.append(" Order By DATE_SUBMIT DESC \n");
                        // sql.append(" and LA_IDNUMBER =:laIdNumber and DATE_DELETE is null ");
                        Query<ClaimSubmition> query = session.createNativeQuery(sql.toString(), ClaimSubmition.class);
                        query.setParameter("poNumber", poNumber);
                        // query.setParameter("laIdNumber", laIdNumber);

                        List<ClaimSubmition> rows = query.getResultList();
                        return rows;
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;

        }

        @Override
        public ClaimSubmition findById(Integer id) {

                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
                        StringBuilder sql = new StringBuilder();
                        sql.append("SELECT ID, PO_NUMBER, LA_NAME, LA_IDNUMBER, LA_ADDRESS, LA_PHONE, RQ_NAME, RQ_IDNUMBER, RQ_ADDRESS, RQ_PHONE, EVENT_DATE,\n");
                        sql.append(" EVENT_PLACE, EVENT_REASON, BENIFIT_TYPE, HOSPITALIZED_DATE_IN, \n");
                        sql.append(" HOSPITALIZED_DATE_OUT, DIAGONOSTIC, HOSPITAL, DOCTOR, HOSPITAL_HEALTHINS, EVENT_DISCRIPTION, \n");
                        sql.append(" PAYMENT_MOTHOD, ACCOUNT_NAME, ACCOUNT_IDCARD_DATE, ACCOUNT_IDCARD, ACCOUNT_NUMBER, \n");
                        sql.append(" ACCOUNT_HOLDER, ORTHER_INSURANCE, ISR1_NAME, ISR1_EFF_DATE, ISR1_AMOUNT, ISR2_NAME, \n");
                        sql.append(" ISR2_EFF_DATE, ISR2_AMOUNT,  DATE_SUBMIT, DATE_UPDATE, DATE_DELETE,BANK, STATUS \n");
                        sql.append(" FROM            Claim_Submition \n");
                        sql.append(" WHERE ID =:id and \n");
                        sql.append(" DATE_DELETE is null ");
                        Query<ClaimSubmition> query = session.createNativeQuery(sql.toString(), ClaimSubmition.class);
                        query.setParameter("id", id);

                        List<ClaimSubmition> rows = query.getResultList();
                        if (rows.size() > 0)
                                return rows.get(0);
                } catch (Exception e) {
                        e.printStackTrace();

                }
                return new ClaimSubmition();
        }

        @Override
        public void save(ClaimSubmition claim) {
                claimSubmitionRespository.save(claim);

        }

        @Override
        public void remove(ClaimSubmition claim) {
                claimSubmitionRespository.delete(claim);

        }

}
