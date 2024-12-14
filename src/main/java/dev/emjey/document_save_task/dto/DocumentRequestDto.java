package dev.emjey.document_save_task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * This file is made by EmJey
 * Project: Document Save Task
 * FileName: DocumentRequestDto.java
 * Date: 2024/12/14
 * Modified Date: 2024/12/14
 * Email: emjeydev@gmail.com
 * GitHub: emjeydev
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequestDto {

    private String title;
    private Map<String, String> translations;
}
