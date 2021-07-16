package com.loose.agendalives.controller;

import com.loose.agendalives.document.LiveDocument;
import com.loose.agendalives.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation. *;
import java.time.LocalDateTime;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class LiveController {

    @Autowired
    LiveService service;

    @GetMapping("/lives")
    public ResponseEntity<Page<LiveDocument>> getAllLives(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable,
                                                          @RequestParam(required = false) String flag){
        Page<LiveDocument> livePage = service.findAll(pageable, flag);
        if (livePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Page<LiveDocument>>(livePage, HttpStatus.OK);
        }
    }

    @GetMapping("/lives/{id}")
    public ResponseEntity<LiveDocument> getOneLive(@PathVariable(value = "id") String id){
        Optional<LiveDocument> live = service.findById(id);
        if (!live.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<LiveDocument>(live.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/live")
    public ResponseEntity<LiveDocument> saveLive(@RequestBody @Valid LiveDocument live){
        live.setRegistrationDate(LocalDateTime.now());
        return new ResponseEntity<LiveDocument>(service.save(live), HttpStatus.CREATED);
    }

    @PutMapping("/lives/{id}")
    public ResponseEntity<LiveDocument> updateLive(@PathVariable(value = "id") String id,
                                                   @RequestBody @Valid LiveDocument liveDocument){
        Optional<LiveDocument> live = service.findById(id);
        if (!live.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            liveDocument.setId(live.get().getId());
            return new ResponseEntity<LiveDocument>(service.save(liveDocument), HttpStatus.OK);
        }
    }

    @DeleteMapping("/lives/{id}")
    public ResponseEntity<?> deleteLive(@PathVariable(value = "id") String id){
        Optional<LiveDocument> live = service.findById(id);
        if (!live.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            service.delete(live.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}