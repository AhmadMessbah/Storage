package com.mftplus.storage;

import com.mftplus.storage.model.entity.Stuff;
import com.mftplus.storage.model.service.StuffService;

public class Test {
    public static void main(String[] args) throws Exception{
        StuffService stuffService = new StuffService();
        stuffService.save(Stuff.builder().name("A21").build());

    }
}
