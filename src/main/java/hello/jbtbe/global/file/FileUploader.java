package hello.jbtbe.global.file;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FileUploader {

    private final S3Properties s3Properties;
    private final S3Client s3Client;

    @SneakyThrows
    public String upload(MultipartFile file) {
        String fileName = Path.join(s3Properties.getFileNamePrefix(), UUID.randomUUID().toString());

        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(s3Properties.getBucketName())
                        .contentType(file.getContentType())
                        .contentLength(file.getSize())
                        .key(fileName)
                        .build(),
                RequestBody.fromInputStream(file.getInputStream(), file.getSize())
        );
        ;

        return Path.join(s3Properties.getBucketUrl(), fileName);
    }
}
