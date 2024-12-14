package dev.emjey.document_save_task.service;

import dev.emjey.document_save_task.dto.DocumentRequestDto;
import dev.emjey.document_save_task.model.Document;

import java.util.List;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: DocumentService.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


public interface DocumentService {

    Document saveDocument(DocumentRequestDto document);

    Document updateDocument(Long id, DocumentRequestDto document);

    Document getDocument(Long id);

    List<Document> getAllDocuments();

    void deleteDocument(Long id);

    List<Document> searchDocumentsByTranslation(String word);
}
