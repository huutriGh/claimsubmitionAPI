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
import phl.claim.claimsubmition.models.PolicyHistory;
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

                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
                        StringBuilder sql = new StringBuilder();
                        sql.append("select distinct P.ID, P.POLICY_NUMBER, P.PO_NAME, P.PO_IDNUMBER, P.PO_NUMBER, P.PO_DOB, P.PRODUCT_CODE, P.RISK_COMMENCEMENT_DATE,\n");
                        sql.append(" P.SUM_ASSURED, P.REINS_DATE, P.FLUP_CODES, P.PAID_TO_DATE, P.POLICY_STATUS, P.LOAN_STATUS,P.LA_NAME, P.LA_IDNUMBER, P.LA_CLIENT_NUMBER,");
                        sql.append(" P.LA_DOB, P.LA_SEX, P.AGENT_CHANNEL, P.AGENT_NUMBER, P.AGENT_NAME, P.SALES_UNIT, P.AREA_NAME, P.BENEF_NAME, P.BENEF_IDNUM,\n");
                        sql.append("P.BENEF_IDDATE, P.BENEF_ADDRESS, i.LIFE_IDNUM, pd.COMPONENT_CODE, pd.LIFE,pd.COVERAGE,pd.RIDER,pd.COMPONENT_NAME, i.LiFE_NAME \n");
                        sql.append("from  policy_info p  inner join life_insured_info i \n");
                        sql.append("on p.POLICY_NUMBER = i.CHDRNUM \n");
                        sql.append("inner join product_details pd on i.CHDRNUM = pd.POLICY_NUMBER and  i.LIFE_NUMBER = pd.LIFE_NUMBER \n");
                        sql.append("where Pd.POLICY_NUMBER =:poNumber \n");
                        sql.append("and p.PO_IDNUMBER =:laIdNumber ");
                        sql.append("and pd.POLICY_NUMBER not in (select  pd.POLICY_NUMBER where pd.POLICY_NUMBER =:poNumber and pd.LIFE = '01' and pd.COVERAGE = '01' \n");
                        sql.append("and pd.RIDER = '00')");

                        Query<PolicyDetail> query = session.createNativeQuery(sql.toString(), PolicyDetail.class);
                        query.setParameter("poNumber", poNumber);
                        query.setParameter("laIdNumber", laIdNumber);

                        List<PolicyDetail> rows = query.getResultList();
                        return rows;
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;

        }

        @Override
        public Policy getPolicy(String poNumber, String poIdNumber) {

                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
                        StringBuilder sql = new StringBuilder();
                        sql.append("SELECT ID, POLICY_NUMBER, PO_NAME, PO_IDNUMBER, PO_NUMBER, PO_DOB, PRODUCT_CODE, RISK_COMMENCEMENT_DATE, SUM_ASSURED,\n");
                        sql.append("REINS_DATE, FLUP_CODES, PAID_TO_DATE, POLICY_STATUS, LOAN_STATUS,\n ");
                        sql.append("LA_NAME, LA_IDNUMBER, LA_CLIENT_NUMBER, LA_DOB, LA_SEX, AGENT_CHANNEL, AGENT_NUMBER, \n");
                        sql.append("AGENT_NAME, SALES_UNIT, AREA_NAME, BENEF_NAME, BENEF_IDNUM, BENEF_IDDATE, BENEF_ADDRESS \n");
                        sql.append("FROM policy_info where POLICY_NUMBER =:poNumber and PO_IDNUMBER =:poIdNumber");
                        Query<Policy> query = session.createNativeQuery(sql.toString(), Policy.class);
                        query.setParameter("poNumber", poNumber);
                        query.setParameter("poIdNumber", poIdNumber);

                        List<Policy> rows = query.getResultList();
                        if (rows.size() > 0) {
                                return rows.get(0);
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }

                return null;
        }

        @Override
        public Policy getPolicyByPoNumber(String poNumber) {
                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
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
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return null;
        }

        @Override
        public List<PolicyHistory> getPolicyHistory(String poNumber) {
                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
                        StringBuilder sql = new StringBuilder();
                        sql.append("select P.POLICY_NUMBER, P.COMPONENT_NAME,CONVERT(varchar(10), C.CLM_SUBMIT_DATE, 105) as CLM_SUBMIT_DATE, CONVERT(varchar(10), C.CLM_OCCUR_DATE, 105) as CLM_OCCUR_DATE  , C.CLM_STATUS, C.TRANNO \n");
                        sql.append("from claim_info C inner join product_details P on C.Policy_Number = P.POLICY_NUMBER \n");
                        sql.append("and C.Component_Code = p.COMPONENT_CODE \n");
                        sql.append("where P.POLICY_NUMBER =:poNumber \n");
                        sql.append("and p.POLICY_NUMBER not in (select  p.POLICY_NUMBER where p.POLICY_NUMBER =:poNumber and p.LIFE = '01' and p.COVERAGE = '01' \n");
                        sql.append("and p.RIDER = '00') order by C.TRANNO ");

                        Query<PolicyHistory> query = session.createNativeQuery(sql.toString(), PolicyHistory.class);
                        query.setParameter("poNumber", poNumber);
                        List<PolicyHistory> rows = query.getResultList();
                        return rows;
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }

}
