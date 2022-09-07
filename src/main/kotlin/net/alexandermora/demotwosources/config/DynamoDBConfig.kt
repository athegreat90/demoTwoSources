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

    @PostConstruct
    private fun init()
    {
        println("Endpoint: $amazonDynamoDBEndpoint - Key: $amazonAWSAccessKey - secretKey: $amazonAWSSecretKey")
    }

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB? {
        val amazonDynamoDB: AmazonDynamoDB = AmazonDynamoDBClient(amazonAWSCredentials())
        if (StringUtils.hasText(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint)
        }
        return amazonDynamoDB
    }

    @Bean
    fun amazonAWSCredentials(): AWSCredentials? {
        return BasicAWSCredentials(
            amazonAWSAccessKey, amazonAWSSecretKey
        )
    }
}