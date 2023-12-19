package tebogo.khula.khambola.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tebogo.khula.khambola.services.StorageService;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private StorageService service;

    @PostMapping
    public ResponseEntity <?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException{

        if (file.getContentType() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Unsupported file type. Only 'image/png' is allowed.");
        }

        if (!file.getContentType().equals(MediaType.IMAGE_PNG_VALUE)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Unsupported file type. Only 'image/png' is allowed.");
        }

		String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
        .body(uploadImage);
	}

    @GetMapping("/{fileName}")
    public ResponseEntity <?> downloadImage(@PathVariable String fileName){
        byte[] image = service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(image);
    }
}
