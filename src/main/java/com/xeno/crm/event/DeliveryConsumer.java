package com.xeno.crm.event;

import com.xeno.crm.entity.CommunicationLog;
import com.xeno.crm.repository.CommunicationLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DeliveryConsumer {
    private final CommunicationLogRepository communicationLogRepository;

    @KafkaListener(topics = "delivery-topic", groupId = "crm-group")
    public void consume(String message) {
        System.out.println("📥 Kafka message received: " + message);  // 🔥 Console log for proof

        String[] parts = message.split(",");
        Long campaignId = Long.parseLong(parts[0]);
        Long customerId = Long.parseLong(parts[1]);

        boolean success = Math.random() < 0.9;

        CommunicationLog log = CommunicationLog.builder()
                .campaignId(campaignId)
                .customerId(customerId)
                .status(success ? "SENT" : "FAILED")
                .sentAt(LocalDateTime.now())
                .build();

        communicationLogRepository.save(log);

        System.out.println("✅ Communication log saved for campaign " + campaignId + " to customer " + customerId);
    }
}
