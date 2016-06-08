package org.github.wildfly.mongo.boilerplate.provider;

import com.mongodb.MongoClient;
import org.github.wildfly.mongo.boilerplate.model.Sample;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class DatastoreProvider {

    @Produces
    @ApplicationScoped
    public Datastore datastore() throws Exception {
        //MongoClientURI uri = new MongoClientURI();
        final MongoClient mongoClient = new MongoClient();

        final Morphia morphia = new Morphia();
        morphia.mapPackage(Sample.class.getPackage().getName());

        final Datastore datastore = morphia.createDatastore(mongoClient, "mss");
        datastore.ensureIndexes();
        return datastore;
    }

}
