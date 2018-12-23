package com.iphayao.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8080;
        Server server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl()).build();

        server.start();
        System.out.println("Server started listening on " + port);
        server.awaitTermination();

    }
}
