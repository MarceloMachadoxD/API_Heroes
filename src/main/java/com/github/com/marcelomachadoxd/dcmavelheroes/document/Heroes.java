package com.github.com.marcelomachadoxd.dcmavelheroes.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Heroes_Table")
public class Heroes {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "universe")
    private String universe;

    @DynamoDBAttribute(attributeName = "Filmsqty")
    private Integer filmsqty;


    public Heroes(String id, String name, String universe, Integer filmsqty) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.filmsqty = filmsqty;
    }
}
