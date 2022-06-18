package pl.altkom.scah.ownerservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Getter
@RequiredArgsConstructor
public class TestServiceInstanceListSupplier implements ServiceInstanceListSupplier {
    private final String serviceId;
    private final int port;

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Collections.singletonList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", port, false)));
    }
}