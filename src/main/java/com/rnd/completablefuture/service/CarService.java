package com.rnd.completablefuture.service;

import com.rnd.completablefuture.entity.Car;
import com.rnd.completablefuture.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepository carRepository;

    @Async
    public CompletableFuture<List<Car>> saveCars(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();

        List<Car> carList = parseCsvFile(file);
        LOGGER.info("Saving a list of cars of size {} records", carList.size());

        carList = carRepository.saveAll(carList);
        long finish = System.currentTimeMillis() - start;
        LOGGER.info("Elapsed time: {}", (finish/ 1000) , " seconds");
        return CompletableFuture.completedFuture(carList);
    }

    private List<Car> parseCsvFile(MultipartFile file) throws Exception {
        List<Car> carList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            String[] data;

            while((line = br.readLine()) != null) {
                data = line.split(";");
                Car car = Car.builder()
                        .manufactur(data[0])
                        .model(data[1])
                        .type(data[2])
                        .createdDate(new Date())
                        .build();
                carList.add(car);
            }
            return carList;
        } catch (IOException ioe) {
            LOGGER.error("Failed to parse CSV file {}", ioe);
            throw new Exception("Failed to parse CSV file {}", ioe);
        }
    }

    @Async
    public CompletableFuture<List<Car>> getAllCar() {
        LOGGER.info("Request to get a list of cars");
        long start = System.currentTimeMillis();
        List<Car> carList = carRepository.findAll();
        CompletableFuture<List<Car>> result = CompletableFuture.completedFuture(carList);
        long finish = System.currentTimeMillis() - start;
        LOGGER.info("Elapsed time: {}", (finish/ 1000) , " seconds");
        return result;
    }

}
