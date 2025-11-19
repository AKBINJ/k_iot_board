package org.example.boardback.dto.board.file;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BoardFileUpdateRequestDto {
    private List<Long> keepFileIds;
    private List<MultipartFile> newFiles;
}


