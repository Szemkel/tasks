package pl.tpacuszka.taskone;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pl.tpacuszka.taskone.cli.Start;
import pl.tpacuszka.taskone.core.AppModule;
import pl.tpacuszka.taskone.menu.MenuModule;
import pl.tpacuszka.taskone.menu.MenuService;
import pl.tpacuszka.taskone.ordering.OrderModule;
import pl.tpacuszka.taskone.ordering.OrderingService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule(), new MenuModule(), new OrderModule());
        Start start = injector.getInstance(Start.class);
        start.startOrdering();
    }
}
