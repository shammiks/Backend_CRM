package com.xeno.crm.service;

import com.xeno.crm.entity.*;
import com.xeno.crm.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final CommunicationLogRepository communicationLogRepository;
    private final CustomerRepository customerRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Campaign createCampaign(String name, String rule) {
        Campaign campaign = Campaign.builder()
                .name(name)
                .rule(rule)
                .createdAt(LocalDateTime.now())
                .build();
        campaign = campaignRepository.save(campaign);

        List<Customer> customers = customerRepository.findAll(); // TODO: Apply rule filter
        for (Customer customer : customers) {
            String message = campaign.getId() + "," + customer.getId();
            kafkaTemplate.send("delivery-topic", message);
            System.out.println("🔥 Message sent to Kafka for campaign " + campaign.getId() + " and customer " + customer.getId());

            System.out.println("✅ Kafka message sent: " + message);  // 🔥 LOG for demo
        }

        return campaign;
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
