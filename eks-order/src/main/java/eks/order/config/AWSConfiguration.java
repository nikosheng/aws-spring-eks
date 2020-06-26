package eks.order.config;

import com.amazonaws.auth.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class AWSConfiguration {

    @Value("${aws.awsAccessKeyId:}")
    private String awsAccessKeyId;

    @Value("${aws.awsSecretAccessKey:}")
    private String awsSecretAccessKey;

    @Bean
    public AWSCredentialsProvider amazonAWSCredentialsProviderDevelopment() {
        if (StringUtils.isEmpty(awsAccessKeyId) || StringUtils.isEmpty(awsSecretAccessKey)) {
            return new EnvironmentVariableCredentialsProvider();
        }
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                awsAccessKeyId, awsSecretAccessKey));
    }
}
