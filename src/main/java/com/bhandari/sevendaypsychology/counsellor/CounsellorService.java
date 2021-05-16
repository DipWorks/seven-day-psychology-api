package com.bhandari.sevendaypsychology.counsellor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CounsellorService {

    private final CounsellorRepository counsellorRepository;

    @Autowired
    public CounsellorService(CounsellorRepository counsellorRepository) {
        this.counsellorRepository = counsellorRepository;
    }

    public List<Counsellor> getCounsellors(){
        return counsellorRepository.findAll();

    }

    public void addNewCounsellor(Counsellor counsellor) {
        Optional<Counsellor> counsellorOptional=
                counsellorRepository.findCounsellorByEmail(counsellor.getEmail());

        if(counsellorOptional.isPresent()){
            throw  new IllegalStateException("Email Already taken");
        }

        counsellorRepository.save(counsellor);
    }

    public void deleteCounsellor(Long counsellorId) {
        Boolean exists=counsellorRepository.existsById(counsellorId);

        if(!exists){
            throw new IllegalStateException("" +
                    "Counsellor with Id: "+counsellorId+" does not exist");
        }

        counsellorRepository.deleteById(counsellorId);
    }

    @Transactional
    public void updateCounsellor(Long counsellorId, String name, String email) {
        Counsellor counsellor = counsellorRepository.findById(counsellorId)
                .orElseThrow(() -> new IllegalStateException("" +
                        "Counsellor with Id: " + counsellorId + " does not exist"));

        if(name!=null&&name.length()>0&&!Objects.equals(counsellor.getName(), name)){
            counsellor.setName(name);
        }

        if(email!=null&&email.length()>0&&
                !Objects.equals(counsellor.getEmail(), email)){
            Optional<Counsellor> optionalCounsellor=
                    counsellorRepository.findCounsellorByEmail(email);
            if(optionalCounsellor.isPresent()){
                throw new IllegalStateException("Email is already taken");
            }
            counsellor.setEmail(email);
        }

    }
}
