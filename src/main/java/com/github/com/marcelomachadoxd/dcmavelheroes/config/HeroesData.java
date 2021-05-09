package com.github.com.marcelomachadoxd.dcmavelheroes.config;


import static com.github.com.marcelomachadoxd.dcmavelheroes.constants.HeroesConstat.ENDPOINT_DYNAMO;
import static com.github.com.marcelomachadoxd.dcmavelheroes.constants.HeroesConstat.REGION_DYNAMO;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;



import java.util.Arrays;



public class HeroesData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
            .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero = new Item()
            .withPrimaryKey("id",1)
            .withString("name","Goku")
            .withString("universe", "Dragon Ball Series")
            .withNumber("Filmsqty",40);

        PutItemOutcome outcome = table.putItem(hero);

        Item hero2 = new Item()
            .withPrimaryKey("id",2)
            .withString("name","Mulher Maravilha")
            .withString("universe", "DC Commics")
            .withNumber("Filmsqty",2);

         outcome = table.putItem(hero2);


        Item hero3 = new Item()
            .withPrimaryKey("id",3)
            .withString("name","Justiceiro")
            .withString("universe", "Marvel Commics")
            .withNumber("Filmsqty",2);

        outcome = table.putItem(hero3);


    }

}
