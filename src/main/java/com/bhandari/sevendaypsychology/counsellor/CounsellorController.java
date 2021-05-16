package com.bhandari.sevendaypsychology.counsellor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/counsellors")
public class CounsellorController {

    private final CounsellorService counsellorService;

    @Autowired
    public CounsellorController(CounsellorService counsellorService) {
        this.counsellorService = counsellorService;
    }

    @GetMapping
    public List<Counsellor> getCounsellors(){
        return counsellorService.getCounsellors();

    }

    @PostMapping
    public void registerNewCounsellor(@RequestBody Counsellor counsellor){
        counsellorService.addNewCounsellor(counsellor);
    }

    @DeleteMapping(path="{counsellorId}")
    public void deleteCounsellor(@PathVariable("counsellorId") Long counsellorId){
        counsellorService.deleteCounsellor(counsellorId);
    }

    @PutMapping(path="{counsellorId}")
    public void updateCounsellor(
            @PathVariable("counsellorId") Long counsellorId,
            @RequestParam(required=false) String name,
            @RequestParam(required = false) String email){
        counsellorService.updateCounsellor(counsellorId, name, email);
    }
}
