package org.launchcode.spaday.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    
    private List<String> polishColors = new ArrayList<>();
    private String skinType;
    private String nailService;
    private List<String> appropriateFacials = new ArrayList<>();
    private Map<String, List<String>> facialOptions = new HashMap<>();

    public Client(String skinType, String nailService) {
        this.skinType = skinType;
        this.nailService = nailService;
    }

    public String getSkinType() {
        return skinType;
    }

    public String getNailService() {
        return nailService;
    }
    
    public void setAppropriateFacials(String skinType) {
        facialOptions = createMap();
        appropriateFacials = facialOptions.get(skinType);
    }

    public List<String> getAppropriateFacials() {
        return appropriateFacials;
    }

    public List<String> getPolishColors() {
        return polishColors;
    }

    public void setPolishColors() {
        polishColors = Arrays.asList("Red", "Purple", "Pink", "Blue", "Turquoise");
    }

    private static Map<String, List<String>> createMap() {
        Map<String, List<String>> facialOptions = new HashMap<>();
        facialOptions.put("oily", Arrays.asList("Microdermabrasion", "Rejuvenating"));
        facialOptions.put("combination", Arrays.asList("Microdermabrasion", "Rejuvenating", "Enzyme Peel"));
        facialOptions.put("normal", Arrays.asList("Microdermabrasion", "Hydrofacial", "Rejuvenating", "Enzyme Peel"));
        facialOptions.put("dry", Arrays.asList("Hydrofacial", "Rejuvenating"));
        return facialOptions;
    }
    
    
}