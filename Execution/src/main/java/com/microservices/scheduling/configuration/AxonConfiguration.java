package com.microservices.scheduling.configuration;

import com.microservices.scheduling.model.TestCaseResult;
import org.axonframework.commandhandling.AsynchronousCommandBus;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;

import java.io.File;

public class AxonConfiguration {
    private static CommandGateway gateway;

    public static void configure() {
        // let's start with the Command Bus
        CommandBus commandBus = new AsynchronousCommandBus();

        // the CommandGateway provides a friendlier API
        gateway = new DefaultCommandGateway(commandBus);

        // we'll store Events on the FileSystem, in the "events/" folder
        EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("./events")));

        // a Simple Event Bus will do
        EventBus eventBus = new SimpleEventBus();

        // we need to configure the repository
        EventSourcingRepository repository = new EventSourcingRepository(TestCaseResult.class, eventStore);
        repository.setEventBus(eventBus);

        // Axon needs to know that our TestCaseResult Aggregate can handle commands
        AggregateAnnotationCommandHandler.subscribe(TestCaseResult.class, repository, commandBus);
    }

    public static CommandGateway getGateway() {
        return gateway;
    }
}