package io.genevjov.vgl;

import io.genevjov.vgl.configuration.MongoRepositoryConfiguration;
import io.genevjov.vgl.repository.VehicleLocationRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BaseSpringTest {

    @MockBean
    protected VehicleLocationRepository mockLocationRepository;
    @MockBean
    private MongoRepositoryConfiguration mongoRepositoryConfigurationMock;

}
