package hello.jbtbe.global.file;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@RequiredArgsConstructor
@Configuration
public class S3Config {
    private final S3Properties s3Properties;

    @Bean
    public S3Client awsS3Client() {
        return S3Client.builder()
                .credentialsProvider(() ->
                        AwsBasicCredentials.create(
                                s3Properties.getAccessKey(),
                                s3Properties.getSecretKey()
                        )
                ).region(Region.of(s3Properties.getRegion()))
                .build();
    }
}
