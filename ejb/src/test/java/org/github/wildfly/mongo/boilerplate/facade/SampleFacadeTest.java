package org.github.wildfly.mongo.boilerplate.facade;

import org.github.wildfly.mongo.boilerplate.model.Sample;
import org.github.wildfly.mongo.boilerplate.provider.DatastoreProvider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;


/**
 *
 */
@RunWith(Arquillian.class)
public class SampleFacadeTest {

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackages(false,
                        // All the models
                        Sample.class.getPackage().getName(),
                        // All the facades
                        SampleFacade.class.getPackage().getName()
                )
                .addClass(
                        DatastoreProvider.class.getName()
                )
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsManifestResource("test-MANIFEST.MF", "MANIFEST.MF");
    }

    @Inject
    SampleFacade sampleFacade;

    @Test
    public void create() {
        final Sample sample = new Sample();
        sample.name = "Hamed";
        sample.company = "WPIC";
        sample.age = 10;

        this.sampleFacade.add(sample);
    }

}
