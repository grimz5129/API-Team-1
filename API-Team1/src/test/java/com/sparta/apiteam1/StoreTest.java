package com.sparta.apiteam1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiteam1.pojo.StorePOJO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StoreTest {

    private StorePOJO[] stores = new StorePOJO[3];

    @BeforeAll
    public void setUp(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            stores[1] = objectMapper.readValue(new URL("http://localhost:8080/sakila/store?id=1"), StorePOJO.class);
            stores[2] = objectMapper.readValue(new URL("http://localhost:8080/sakila/store?id=2"), StorePOJO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1, Mike, Hillyer",
                "2, 2, 2, Jon, Stephens"}
    )
    @DisplayName("Return store ID, MangerID, MangerFirstName, MangerLastName")
    public void getStoreTest(int ActualID, String StoreID, String ManagerID, String ManagerFirstName, String ManagerLastName){
        assertEquals(stores[ActualID].getId().toString(), StoreID);
        assertEquals(stores[ActualID].getManagerStaff().getId().toString(), ManagerID);
        assertEquals(stores[ActualID].getManagerStaff().getFirstName(), ManagerFirstName);
        assertEquals(stores[ActualID].getManagerStaff().getLastName(), ManagerLastName);
    }
}
