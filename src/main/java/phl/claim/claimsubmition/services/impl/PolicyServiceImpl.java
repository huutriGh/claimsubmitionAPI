package phl.claim.claimsubmition.services.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phl.claim.claimsubmition.models.Policy;
import phl.claim.claimsubmition.models.PolicyDetail;
import phl.claim.claimsubmition.services.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {
        @Autowired
        private EntityManagerFactory entityManagerFactory;

        // private PolicyRespository policyRepository;

        // @Autowired
        // public PolicyServiceImpl(PolicyRespository policyRepository) {
        // this.policyRepository = policyRepository;
        // }

        @Override
        public List<PolicyDetail> getPolicyDetail(String poNumber, String laIdNumber) {

                Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
                StringBuilder sql = new StringBuilder();
                sql.append("select distinct P.ID, P.POLICY_NUMBER, P.PO_NAME, P.PO_IDNUMBER, P.PO_NUMBER, P.PO_DOB, P.PRODUCT_CODE, P.RISK_COMMENCEMENT_DATE,\n");
                sql.append(" P.SUM_ASSURED, P.REINS_DATE, P.FLUP_CODES, P.PAID_TO_DATE, P.POLICY_STATUS, P.LOAN_STATUS,P.LA_NAME, P.LA_IDNUMBER, P.LA_CLIENT_NUMBER,");
                sql.append(" P.LA_DOB, P.LA_SEX, P.AGENT_CHANNEL, P.AGENT_NUMBER, P.AGENT_NAME, P.SALES_UNIT, P.AREA_NAME, P.BENEF_NAME, P.BENEF_IDNUM,\n");
                sql.append("P.BENEF_IDDATE, P.BENEF_ADDRESS, i.LIFE_IDNUM, pd.COMPONENT_CODE, pd.LIFE,pd.COVERAGE,pd.RIDER,pd.COMPONENT_NAME \n");
                sql.append("from  policy_info p  inner join life_insured_info i \n");
                sql.append("on p.POLICY_NUMBER = i.CHDRNUM \n");
                sql.append("inner join product_details pd on i.CHDRNUM = pd.POLICY_NUMBER and  i.LIFE_NUMBER = pd.LIFE_NUMBER \n");
                sql.append("where Pd.POLICY_NUMBER =:poNumber \n");
                sql.append("and p.LA_IDNUMBER =:laIdNumber ");
                sql.append("and pd.POLICY_NUMBER not in (select  pd.POLICY_NUMBER where pd.POLICY_NUMBER =:poNumber and pd.LIFE = '01' and pd.COVERAGE = '01' \n");
                sql.append("and pd.RIDER = '00')");

                Query<PolicyDetail> query = session.createNativeQuery(sql.toString(), PolicyDetail.class);
                query.setParameter("poNumber", poNumber);
                query.setParameter("laIdNumber", laIdNumber);

                List<PolicyDetail> rows = query.getResultList();
                // session.close();
                return rows;

        }

        @Override
        public Policy getPolicy(String poNumber, String laIdNumber) {

                Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ID, POLICY_NUMBER, PO_NAME, PO_IDNUMBER, PO_NUMBER, PO_DOB, PRODUCT_CODE, RISK_COMMENCEMENT_DATE, SUM_ASSURED,\n");
                sql.append("REINS_DATE, FLUP_CODES, PAID_TO_DATE, POLICY_STATUS, LOAN_STATUS,\n ");
                sql.append("LA_NAME, LA_IDNUMBER, LA_CLIENT_NUMBER, LA_DOB, LA_SEX, AGENT_CHANNEL, AGENT_NUMBER, \n");
                sql.append("AGENT_NAME, SALES_UNIT, AREA_NAME, BENEF_NAME, BENEF_IDNUM, BENEF_IDDATE, BENEF_ADDRESS \n");
                sql.append("FROM policy_info where POLICY_NUMBER =:poNumber and LA_IDNUMBER =:laIdNumber");
                Query<Policy> query = session.createNativeQuery(sql.toString(), Policy.class);
                query.setParameter("poNumber", poNumber);
                query.setParameter("laIdNumber", laIdNumber);

                List<Policy> rows = query.getResultList();
                if (rows.size() > 0) {
                        return rows.get(0);
                }
                // session.close();
                return null;
        }

        @Override
        public Policy getPolicyByPoNumber(String poNumber) {
                Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ID, POLICY_NUMBER, PO_NAME, PO_IDNUMBER, PO_NUMBER, PO_DOB, PRODUCT_CODE, RISK_COMMENCEMENT_DATE, SUM_ASSURED,\n");
                sql.append("REINS_DATE, FLUP_CODES, PAID_TO_DATE, POLICY_STATUS, LOAN_STATUS,\n ");
                sql.append("LA_NAME, LA_IDNUMBER, LA_CLIENT_NUMBER, LA_DOB, LA_SEX, AGENT_CHANNEL, AGENT_NUMBER, \n");
                sql.append("AGENT_NAME, SALES_UNIT, AREA_NAME, BENEF_NAME, BENEF_IDNUM, BENEF_IDDATE, BENEF_ADDRESS \n");
                sql.append("FROM policy_info where POLICY_NUMBER =:poNumber");
                Query<Policy> query = session.createNativeQuery(sql.toString(), Policy.class);
                query.setParameter("poNumber", poNumber);
                List<Policy> rows = query.getResultList();
                if (rows.size() > 0) {
                        return rows.get(0);
                }
                // session.close();
                return null;
        }

}
