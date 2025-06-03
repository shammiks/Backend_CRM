package com.xeno.crm.controller;

import com.xeno.crm.entity.Campaign;
import com.xeno.crm.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;

    @PostMapping
    public Campaign create(@RequestParam String name, @RequestParam String rule) {
        return campaignService.createCampaign(name, rule);
    }

    // ✅ Add this GET endpoint
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }
}
