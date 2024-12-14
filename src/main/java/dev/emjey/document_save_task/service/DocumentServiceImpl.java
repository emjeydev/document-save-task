package dev.emjey.document_save_task.service;

import dev.emjey.document_save_task.dto.DocumentRequestDto;
import dev.emjey.document_save_task.exception.DocumentNotfoundException;
import dev.emjey.document_save_task.model.Document;
import dev.emjey.document_save_task.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: DocumentServiceImpl.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public Document saveDocument(DocumentRequestDto requestDto) {
        Document document = new Document();
        document.setTitle(requestDto.getTitle());
        document.setTranslations(requestDto.getTranslations());
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Long id, DocumentRequestDto requestDto) {
        Optional<Document> document = documentRepository.findById(id);
        Document unwrappedDocument = unwrapDocument(document, id);
        unwrappedDocument.setTitle(requestDto.getTitle());
        unwrappedDocument.setTranslations(requestDto.getTranslations());
        return documentRepository.save(unwrappedDocument);
    }

    @Override
    public Document getDocument(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        return unwrapDocument(document, id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void deleteDocument(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        Document unwrappedDocument = unwrapDocument(document, id);
        documentRepository.delete(unwrappedDocument);
    }

//    @Override
//    public List<Document> searchDocumentsByTranslation(String word) {
//        if (word == null || word.trim().isEmpty()) {
//            throw new IllegalArgumentException("Search word cannot be empty");
//        }
//        return documentRepository.searchDocumentsByTranslation(word);
//    }

    @Override
    public List<Document> searchDocumentsByTranslation(String searchWord) {
        List<Document> documents = documentRepository.findAll();
        return documents.stream()
                .filter(document -> document.getTranslations().values().stream()
                        .anyMatch(translation -> translation.contains(searchWord)))
                .collect(Collectors.toList());
    }

    static Document unwrapDocument(Optional<Document> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new DocumentNotfoundException(id.toString());
    }
}
