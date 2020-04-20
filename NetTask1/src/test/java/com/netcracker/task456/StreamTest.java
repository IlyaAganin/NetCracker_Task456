package com.netcracker.task456;

import org.junit.jupiter.api.Test;

import com.netcracker.repository.Repository;

import ru.vsu.lab.entities.IPerson;

import java.io.IOException;

class StreamTest {

    @Test
    public void stream() throws IOException {
        Repository base = new Repository();
        Stream<IPerson> streamApi = new Stream<>(base);
        streamApi.firstQuery();
        streamApi.secondQuery();
        streamApi.thirdQuery();
    }

}