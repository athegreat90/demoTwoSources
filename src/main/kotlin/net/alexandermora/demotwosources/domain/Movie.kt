package net.alexandermora.demotwosources.domain

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName = "Movie")
class Movie {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    var id: String? = null

    @DynamoDBAttribute(attributeName = "name")
    var name: String? = null

    @DynamoDBAttribute(attributeName = "genre")
    var genre: String? = null

    @DynamoDBAttribute(attributeName = "year")
    var year: Int? = null
}