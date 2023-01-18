package com.example.weather.repository;

import com.example.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByIpAddress(String addressIp);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM City  WHERE  country_name =?1 AND ip_address =?2", nativeQuery = true)
    void deleteCityByCountryNameAndIpAddress(String countryName, String ipAddress);
}
