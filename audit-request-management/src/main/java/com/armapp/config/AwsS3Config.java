package com.armapp.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dibya Prakash Ojha
 * @date : 18-Jul-22
 * @project : audit-request-management
 */
@Configuration
public class AwsS3Config{
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKeyId;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessKeySecret;

    @Value("${cloud.aws.region.static}")
    private String s3RegionName;


    @Bean
    public AmazonS3 getAmazonS3Client() {
        final BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
        // Get Amazon S3 client and return the S3 client object
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                .withRegion(s3RegionName)
                .build();
    }
}
