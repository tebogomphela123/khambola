package tebogo.khula.khambola.services;


import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tebogo.khula.khambola.entity.Image;
import tebogo.khula.khambola.repository.StorageRepository;
import tebogo.khula.khambola.utils.ImageUtils;

@Service
public class StorageService {
    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException{

        Image image = repository.save(Image.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .image(ImageUtils.compressImage(file.getBytes())).build());

        if(image != null){
            return "file uploaded successfully";
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<Image> image = repository.findByName(fileName);
        return ImageUtils.decompressImage(image.get().getImage());
    }
}
