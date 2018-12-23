package com.iphayao.grpc.server;

import com.iphayao.grpc.HelloRequest;
import com.iphayao.grpc.HelloResponse;
import com.iphayao.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuffer()
                .append("Hello, ")
                .append(request.getFistName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
