package program.storage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;
    public FileSystemStorageService(StorageProperties properties) {
        rootLocation= Paths.get(properties.getLocation());
    }
    @Override
    public void init() {
        try {
            if(!Files.exists(rootLocation))
                Files.createDirectories(rootLocation);
        }catch(IOException e) {
            throw new StorageException("Помилка створення кателога",e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists()||resource.isReadable())
                return resource;
            throw new StorageException("Проблема читання файлу: "+filename);
        }catch(MalformedURLException e) {
            throw new StorageException("Файл не знайдено: "+filename);
        }
    }

    @Override
    public String save(String base64) {
        try {
            if(base64.isEmpty())
                throw new StorageException("Постий base64");
            UUID uuid = UUID.randomUUID();
            String randomFileName = uuid.toString()+".jpg";
            String [] charArray = base64.split(",");
            Base64.Decoder decoder = Base64.getDecoder();
            byte [] bytes = new byte[0];
            bytes = decoder.decode(charArray[1]);
            String folder = rootLocation.toString()+"/"+randomFileName;
            new FileOutputStream(folder).write(bytes);
            return randomFileName;
        }catch(IOException e) {
            throw new StorageException("Проблема збереження файлу ", e);
        }
    }
}
