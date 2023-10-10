package se331.lab.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.util.CloudStorageHelper;
import se331.lab.rest.util.StorageFileDto;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {

        final CloudStorageHelper cloudStorageHelper;
        @PostMapping("/uploadFile")
        public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException, ServletException {
            return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"imageupload-6ee6b.appspot.com"));
        }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image") MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getStorageFileDto(file, "imageupload-6ee6b.appspot.com"));
    }

    @PostMapping("/uploadSingleImage")
    public ResponseEntity<?> uploadSingleImageComponent(@RequestPart(value = "image") MultipartFile file) throws IOException, ServletException {
        if (file == null || file.isEmpty()) {
            return new ResponseEntity<>("No image provided", HttpStatus.BAD_REQUEST);
        }

        StorageFileDto storageFileDto = this.cloudStorageHelper.uploadSingleImage(file, "imageupload-6ee6b.appspot.com");
        if (storageFileDto == null) {
            return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(storageFileDto);
    }




}
