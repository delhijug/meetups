package com.iontrading.functional.vavr;


import io.vavr.control.Try;

import java.net.ConnectException;
import java.net.UnknownServiceException;

import static io.vavr.control.Try.of;

interface ClientApi {
    Response executeOrderOnAmazon() throws UnknownServiceException;
    Response executeOrderOnGoogle() throws UnknownServiceException;
}

class ClientApiImpl implements ClientApi {

    @Override
    public Response executeOrderOnAmazon() throws UnknownServiceException {
        return new Response("Amazon order executed");
    }

    @Override
    public Response executeOrderOnGoogle() throws UnknownServiceException {
        return new Response("Google order executed");
    }
}

class Response {
    public final String id;

    public Response(String id) {
        this.id = id;
    }
}


class OldConsumer {

    private final ClientApi clientApi;

    OldConsumer(ClientApi clientApi){
        this.clientApi = clientApi;
    }

    public void executeOrder(){
        try {
            Response response = clientApi.executeOrderOnAmazon();
            System.out.println(response);
        } catch (UnknownServiceException e) {
            try {
                Response response = clientApi.executeOrderOnGoogle();
                System.out.println(response);
            } catch (UnknownServiceException e1) {
                e1.printStackTrace();
            }
        }
    }
}

class VavrConsumer {
    private final ClientApi clientApi;

    VavrConsumer(ClientApi clientApi){
        this.clientApi = clientApi;
    }

    public void executeOrder() {
        Try.of(clientApi::executeOrderOnAmazon)
                .orElse(Try.of(clientApi::executeOrderOnGoogle))
                .onSuccess(System.out::println)
                .onFailure(System.out::print);
    }
}



