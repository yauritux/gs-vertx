package app;

import io.vertx.core.Vertx;

import app.verticles.EventBusSenderVerticle;
import app.verticles.EventBusReceiverVerticle;

public class VertxApp {

  public static void main(String... args) throws InterruptedException {
    Vertx vertx = Vertx.vertx();
  
    vertx.deployVerticle(new EventBusReceiverVerticle("R1"), 
      stringAsyncResult -> System.out.println("R1 deployed completely"));
    vertx.deployVerticle(new EventBusReceiverVerticle("R2"),
      stringAsyncResult -> System.out.println("R2 deployed completely"));
    
    Thread.sleep(3000);

    vertx.deployVerticle(new EventBusSenderVerticle(), 
      stringAsyncResult -> System.out.println("EventBusSenderVerticle deployed completely"));
  }
}
