package com.iphayao.grpc.client;

import com.iphayao.grpc.HelloRequest;
import com.iphayao.grpc.HelloResponse;
import com.iphayao.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFistName("Demo")
                .setLastName("gRPC")
                .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
