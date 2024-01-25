package com.apache.kafka.model;


import com.apache.kafka.enums.Color;
import com.apache.kafka.enums.DesignType;
import com.apache.kafka.enums.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InternalProduct {

    private Color color;

    private ProductType type;

    private DesignType designType;

}
