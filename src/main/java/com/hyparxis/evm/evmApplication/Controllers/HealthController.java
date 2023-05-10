package com.hyparxis.evm.evmApplication.Controllers;


import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")

public class HealthController {
    private final ApplicationContext context;

    public HealthController(ApplicationContext context) {
        this.context = context;
    }
    @GetMapping("/health/down")

    void down() {
        AvailabilityChangeEvent.publish(this.context , LivenessState.BROKEN);
    }
    @GetMapping("/health/up")

    void up() {
        AvailabilityChangeEvent.publish(this.context , LivenessState.CORRECT);
    }

    @EventListener
    public void isEvmAppAvailable(AvailabilityChangeEvent<?> changeEvent) {

    }
}
