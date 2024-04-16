package com.example.farmcollector.service;

import com.example.farmcollector.exception.NotFoundException;
import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dao.Season;
import com.example.farmcollector.model.dto.SeasonRecord;

public interface SeasonService {
    Season createSeason(SeasonRecord seasonRecord);

    Season getSeason(Long seasonId);

    Season updateSeason(Long seasonId, SeasonRecord seasonRecord);

    void deleteSeason(Long seasonId);
}
