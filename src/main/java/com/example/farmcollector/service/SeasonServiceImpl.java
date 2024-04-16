package com.example.farmcollector.service;

import com.example.farmcollector.exception.NotFoundException;
import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dao.Season;
import com.example.farmcollector.model.dto.SeasonRecord;
import com.example.farmcollector.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;

    public Season createSeason(SeasonRecord seasonRecord) {
        Farm farm = Farm.builder()
                .id(seasonRecord.farmId())
                .build();

        Season season = Season.builder()
                .year(seasonRecord.year())
                .name(seasonRecord.name())
                .farm(farm)
                .build();

        return seasonRepository.save(season);
    }

    public Season getSeason(Long seasonId) {
        return seasonRepository.findById(seasonId)
                .orElseThrow(() -> new NotFoundException("Season not found with id: " + seasonId));
    }

    public Season updateSeason(Long seasonId, SeasonRecord seasonRecord) {
        Farm farm = Farm.builder()
                .id(seasonRecord.farmId())
                .build();

        Season season = getSeason(seasonId);
        season.setYear(seasonRecord.year());
        season.setName(seasonRecord.name());
        season.setFarm(farm);

        return seasonRepository.save(season);
    }

    public void deleteSeason(Long seasonId) {
        Season season = getSeason(seasonId);
        seasonRepository.delete(season);
    }
}
