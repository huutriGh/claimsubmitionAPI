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

                Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
                StringBuilder sql = new StringBuilder();
                sql.append("select N.NoteID as Note_ID,T.NoteDetailId as Note_Detail_Id , N.NoteHeader as Note_Header, T.NoteDetailDesc as Note_Detail_Desc \n");
                sql.append("from Notes N left join NoteDetails T on N.NoteID = T.NodeId \n ");
                sql.append("order by N.NoteOrder, T.NodeDetailOrder \n");

                Query<Note> query = session.createNativeQuery(sql.toString(), Note.class);

                List<Note> rows = query.getResultList();
                if (rows.size() > 0) {
                        return rows;
                }

                return null;
        }

        @Override
        public List<ComponentFile> getComponentFile() {
                Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
                StringBuilder sql = new StringBuilder();
                sql.append("select  CF.Id, C.ComponentCode Component_Code, C.ComponentName Component_Name, C.ColNum Col_Num, F.ComponentFileID as Component_File_ID , F.ComponentFilename Component_Filename, \n");
                sql.append("CF.Accident,cf.Pathological, cf.Missing, Cf.FatalDisease Fatal_Disease \n ");
                sql.append("from ComponentFile CF inner join Components C on CF.ComponentCode = C.ComponentCode \n");
                sql.append("inner join FileDetail F on CF.ComponentFileId = F.ComponentFileID");

                Query<ComponentFile> query = session.createNativeQuery(sql.toString(), ComponentFile.class);

                List<ComponentFile> rows = query.getResultList();
                if (rows.size() > 0) {
                        return rows;
                }

                return null;
        }
}
