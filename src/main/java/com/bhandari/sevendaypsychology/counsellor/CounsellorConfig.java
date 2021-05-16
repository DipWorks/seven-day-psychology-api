package com.bhandari.sevendaypsychology.counsellor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class CounsellorConfig {

    @Bean
    CommandLineRunner commandLineRunner(CounsellorRepository counsellorRepository){
        return args -> {
                Counsellor mariam=new Counsellor(
                        "Mariam Webster",
                        "mariam@gamil.com",
                        LocalDate.of(2000, JULY, 18),
                        "Masters in Human Psychology"
                );
            Counsellor adam=new Counsellor(
                    "Adam Lambert",
                    "adamLambert@gamil.com",
                    LocalDate.of(1994, JULY, 28),
                    "Masters in Human Psychology"
                    );
            counsellorRepository.saveAll(List.of(mariam, adam));
        };
    }
}
