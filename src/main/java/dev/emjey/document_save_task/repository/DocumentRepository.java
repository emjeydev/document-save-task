package dev.emjey.document_save_task.repository;

import dev.emjey.document_save_task.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: DocumentRepository.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


public interface DocumentRepository extends JpaRepository<Document, Long> {
}
