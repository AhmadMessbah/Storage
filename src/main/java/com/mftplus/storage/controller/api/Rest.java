package com.mftplus.storage.controller.api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jdk.dynalink.linker.support.Lookup;
import lombok.extern.java.Log;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@ApplicationPath("/rest")
public class Rest extends Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Rest.class);
    public Rest() {
        LOGGER.info("Rest Uri Started");
    }
}
