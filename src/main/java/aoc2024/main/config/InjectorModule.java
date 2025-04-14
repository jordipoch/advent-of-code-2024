package aoc2024.main.config;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.controller.input.annotation.Day1;
import aoc2024.controller.input.annotation.Day2;
import aoc2024.controller.input.annotation.Day3;
import aoc2024.controller.input.annotation.Day4;
import aoc2024.controller.input.supplier.Day1InputSupplier;
import aoc2024.controller.input.supplier.Day2InputSupplier;
import aoc2024.controller.input.supplier.Day3InputSupplier;
import aoc2024.controller.input.supplier.Day4InputSupplier;
import aoc2024.data.InputFileDataLoaderForProd;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.util.List;
import java.util.function.Supplier;

public class InjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        configureInputDataLoaderFactory();
        configureInputSuppliers();
    }

    private void configureInputDataLoaderFactory() {
        install(new FactoryModuleBuilder()
                .implement(InputDataLoader.class, InputFileDataLoaderForProd.class)
                .build(InputDataLoaderFactory.class));
    }

    private void configureInputSuppliers() {
        bind(new TypeLiteral<Supplier<List<String>>>() {})
                .annotatedWith(Day1.class)
                .to(Day1InputSupplier.class);

        bind(new TypeLiteral<Supplier<List<String>>>() {})
                .annotatedWith(Day2.class)
                .to(Day2InputSupplier.class);

        bind(new TypeLiteral<Supplier<List<String>>>() {})
                .annotatedWith(Day3.class)
                .to(Day3InputSupplier.class);

        bind(new TypeLiteral<Supplier<List<String>>>() {})
                .annotatedWith(Day4.class)
                .to(Day4InputSupplier.class);
    }


}
