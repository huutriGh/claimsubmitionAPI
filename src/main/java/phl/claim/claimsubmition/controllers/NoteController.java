package phl.claim.claimsubmition.controllers;

import java.util.List;

//import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phl.claim.claimsubmition.models.ComponentFile;
import phl.claim.claimsubmition.models.Note;
import phl.claim.claimsubmition.services.NoteService;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/note", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getNote() {

        List<Note> notes = noteService.getNote();
        if (notes == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notes, HttpStatus.OK);

    }

    @RequestMapping(value = "/componentfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getComponentfile() {

        List<ComponentFile> notes = noteService.getComponentFile();
        if (notes == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notes, HttpStatus.OK);

    }

}