package com.example.demolista.service;

import com.example.demolista.form.CityForm;
import com.example.demolista.model.City;
import com.example.demolista.model.Code;
import com.example.demolista.repository.CityRepository;
import com.example.demolista.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityService {


    final CityRepository cityRepository;
    final CodeRepository codeRepository;

    @Autowired
    public CityService(CityRepository cityRepository, CodeRepository codeRepository) {
        this.cityRepository = cityRepository;
        this.codeRepository = codeRepository;
    }





    public List<City> getCities() {

        List<City> cityList = cityRepository.findAll();
        return cityList;
    }

    public List<Code> getCodes() {

        List<Code> codesList = codeRepository.findAll();
        return codesList;
    }

    public void saveCity(CityForm cityForm) {

        City cityNew = new City();

        cityNew.setName(cityForm.getName());

        Set<Code> codes = new HashSet<Code>();
        String[] stringCodes = cityForm.getCode().split(",");
        for (int i = 0; i < stringCodes.length; i++) {
            Code code = new Code();
            code.setCode(stringCodes[i]);
            codes.add(code);
        }

        cityNew.setCodes(codes);
        System.out.println(codes);
        cityRepository.save(cityNew);
    }


}
