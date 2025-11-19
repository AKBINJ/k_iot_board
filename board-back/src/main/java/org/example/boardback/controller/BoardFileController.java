
package org.example.boardback.controller;

import lombok.RequiredArgsConstructor;
import org.example.boardback.common.apis.BoardApi;
import org.example.boardback.dto.board.file.BoardFileListDto;
import org.example.boardback.dto.board.file.BoardFileUpdateRequestDto;
import org.example.boardback.entity.file.FileInfo;
import org.example.boardback.service.impl.BoardFileServiceImpl;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(BoardApi.ROOT)
@RequiredArgsConstructor
public class BoardFileController {
    private final BoardFileServiceImpl boardFileService;

    @PostMapping(BoardApi.ID_ONLY + "/files")
    public ResponseEntity<?> uploadBoardFiles(
            @PathVariable Long boardId,
            @RequestParam("files") List<MultipartFile> files
    ) {
        boardFileService.uploadBoardFiles(boardId, files);
        return ResponseEntity.ok("업로드 성공");
    }

    @GetMapping(BoardApi.ID_ONLY + "/files")
    public ResponseEntity<List<BoardFileListDto>> getFilesByBoard(
            @PathVariable Long boardId
    ) {
        List<BoardFileListDto> files = boardFileService.getFilesByBoard(boardId);

        if (files == null || files.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(files);
    }

    @GetMapping("/file/download/{fileId}")
    public ResponseEntity<Resource> download(@PathVariable Long fileId) {
        FileInfo info = boardFileService.getFileInfo(fileId);

        Path path = boardFileService.loadFile(fileId);

        Resource resource = new PathResource(path);

        HttpHeaders headers = boardFileService.createDownloadHeaders(info, path);

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    @DeleteMapping("/file/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        boardFileService.deleteBoardFile(fileId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = BoardApi.ID_ONLY + "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateBoardFiles(
            @PathVariable Long boardId,
            // ModelAttribute: Java 객체로 바인딩 할 때
            // >> FormData 기반 요청에는 @RequestBody 사용 불가
            //      >> @ModelAttribute가 가장 안정적인 방식
            @ModelAttribute BoardFileUpdateRequestDto dto) {
        boardFileService.updateBoardFiles(boardId, dto);
        return ResponseEntity.noContent().build();
    }
}
