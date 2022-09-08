package net.alexandermora.demotwosources.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.StringUtils
import javax.annotation.PostConstruct


@Configuration
@EnableDynamoDBRepositories(basePackages = ["net.alexandermora.demotwosources.reponosql"])
class DynamoDBConfig {

    @Value("\${amazon.dynamodb.endpoint}")
    private val amazonDynamoDBEndpoint: String? = null

    @Value("\${amazon.aws.accesskey}")
    private val amazonAWSAccessKey: String? = null

    @Value("\${amazon.aws.secretkey}")
    private val amazonAWSSecretKey: String? = null

    @Value("\${amazon.aws.region:us-east-1a}")
    private val amazonAwsRegion: String? = null

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB? {
        val endpoint = EndpointConfiguration(amazonDynamoDBEndpoint, amazonAwsRegion)
        val credentialsProvider = AWSStaticCredentialsProvider(amazonAWSCredentials())
        return AmazonDynamoDBClientBuilder
            .standard()
            .withCredentials(credentialsProvider).withEndpointConfiguration(endpoint).build()
    }

    @Bean
    fun amazonAWSCredentials(): AWSCredentials? {
        return BasicAWSCredentials(
            amazonAWSAccessKey, amazonAWSSecretKey
        )
    }
}
