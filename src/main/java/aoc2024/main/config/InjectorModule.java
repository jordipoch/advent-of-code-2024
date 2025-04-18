package aoc2024.main.config;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.data.InputFileDataLoaderForProd;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class InjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        configureInputDataLoaderFactory();
    }

    private void configureInputDataLoaderFactory() {
        install(new FactoryModuleBuilder()
                .implement(InputDataLoader.class, InputFileDataLoaderForProd.class)
                .build(InputDataLoaderFactory.class));
    }


}
