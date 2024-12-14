package dev.emjey.document_save_task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: Document.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(name = "document_translation", joinColumns = @JoinColumn(name = "document_id"))
    @MapKeyColumn(name = "langudage")
    @Column(name = "translation")
    private Map<String, String> translations;
}
