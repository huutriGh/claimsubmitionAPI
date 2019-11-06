package phl.claim.claimsubmition.services;

import java.util.List;

import phl.claim.claimsubmition.models.Note;
import phl.claim.claimsubmition.models.ComponentFile;;


public interface NoteService {

    List<Note> getNote();
    List<ComponentFile> getComponentFile();
}