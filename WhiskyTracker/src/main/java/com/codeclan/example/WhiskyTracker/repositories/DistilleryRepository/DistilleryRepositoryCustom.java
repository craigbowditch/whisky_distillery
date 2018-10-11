package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;

import java.util.List;

public interface DistilleryRepositoryCustom {


    List<Distillery> getAllDistilleriesByRegion(String region);

    List<Distillery> getAllDistilleriesWith12YearOldWhisky();
}
