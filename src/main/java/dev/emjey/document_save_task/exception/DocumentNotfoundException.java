package dev.emjey.document_save_task.exception;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: DocumentNotfoundException.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


public class DocumentNotfoundException extends RuntimeException {

    public DocumentNotfoundException(String id) {
        super("The Document with id: '" + id + "' does not exist in our records.");
    }
}
