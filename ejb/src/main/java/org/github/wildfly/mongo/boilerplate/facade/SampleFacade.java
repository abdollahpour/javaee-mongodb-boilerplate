package org.github.wildfly.mongo.boilerplate.facade;

import org.github.wildfly.mongo.boilerplate.model.Sample;
import org.mongodb.morphia.Datastore;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Stateless
public class SampleFacade {

    @Inject
    private Datastore datastore;

    public Sample get(@NotNull final String name) {
        return this.datastore.find(Sample.class).field(Sample.NAME).equal(name).get();
    }

    public void add(@NotNull @Valid final Sample sample) {
        this.datastore.save(sample);
    }

    public boolean delete(@NotNull final String name) {
        return this.datastore.delete(name).getN() > 0;
    }

}
