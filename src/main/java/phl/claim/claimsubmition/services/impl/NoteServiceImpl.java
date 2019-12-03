package phl.claim.claimsubmition.services.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phl.claim.claimsubmition.models.ComponentFile;
import phl.claim.claimsubmition.models.Note;
import phl.claim.claimsubmition.services.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
        @Autowired
        private EntityManagerFactory entityManagerFactory;

        @Override
        public List<Note> getNote() {
                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {

                        StringBuilder sql = new StringBuilder();
                        sql.append("select N.Note_ID as Note_ID, N.Note_Order, T.Note_Detail_Id , N.Note_Header, T.Note_Detail_Desc \n");
                        sql.append("from R_Notes N left join R_Note_Details T on N.Note_ID = T.Node_Id \n ");
                        sql.append("order by N.Note_Order, T.Node_Detail_Order \n");

                        Query<Note> query = session.createNativeQuery(sql.toString(), Note.class);

                        List<Note> rows = query.getResultList();
                        if (rows.size() > 0) {
                                return rows;
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return null;
        }

        @Override
        public List<ComponentFile> getComponentFile() {
                try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {

                        StringBuilder sql = new StringBuilder();
                        sql.append("select  CF.Id, C.Component_Code, C.Component_Name, C.Col_Num, F.Component_File_ID , F.Component_File_Name, \n");
                        sql.append("CF.Accident, CF.Pathological, CF.Missing, CF.Fatal_Disease \n ");
                        sql.append("from R_Component_File CF inner join R_Components C on CF.Component_Code = C.Component_Code \n");
                        sql.append("inner join R_FileDetail F on CF.Component_File_Id = F.Component_File_Id");

                        Query<ComponentFile> query = session.createNativeQuery(sql.toString(), ComponentFile.class);

                        List<ComponentFile> rows = query.getResultList();
                        if (rows.size() > 0) {
                                return rows;
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return null;
        }
}
