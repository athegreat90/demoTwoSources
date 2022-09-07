package net.alexandermora.demotwosources.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException
import net.alexandermora.demotwosources.domain.Movie
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Slf4j
@Component
class ExtraConfig(private val amazonDynamoDB: AmazonDynamoDB)
{
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostConstruct
    private fun init()
    {
        val dynamoDBMapper = DynamoDBMapper(amazonDynamoDB)
        try
        {
            val tableRequest = dynamoDBMapper.generateCreateTableRequest(Movie::class.java)
            tableRequest.provisionedThroughput = ProvisionedThroughput(1L, 1L)
            amazonDynamoDB.createTable(tableRequest)
        }
        catch (ex: ResourceInUseException)
        {
            logger.info("Table created")
        }
        catch (e: Exception)
        {
            logger.error(e.message, e)
        }
    }
}