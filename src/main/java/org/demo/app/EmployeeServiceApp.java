package org.demo.app;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class EmployeeServiceApp {
    public static void main(String... args) {
        Quarkus.run(args);
    }
}
