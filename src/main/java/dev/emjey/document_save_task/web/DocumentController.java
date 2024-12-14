package dev.emjey.document_save_task.web;

import dev.emjey.document_save_task.dto.DocumentRequestDto;
import dev.emjey.document_save_task.model.Document;
import dev.emjey.document_save_task.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: DocumentController.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


@AllArgsConstructor
@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<Document> createDocument(@RequestBody DocumentRequestDto requestDto) {
        return new ResponseEntity<>(documentService.saveDocument(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody DocumentRequestDto requestDto) {
        return new ResponseEntity<>(documentService.updateDocument(id, requestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        return new ResponseEntity<>(documentService.getDocument(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAllDocuments() {
        return new ResponseEntity<>(documentService.getAllDocuments(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Document> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
