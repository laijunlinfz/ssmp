package com.ssmp.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.common.Result;
import com.ssmp.domain.Business;
import com.ssmp.service.IBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/business")
public class BusinessController extends BaseController<IBusinessService, Business, Integer> {
    @Autowired
    private IBusinessService businessService;

//    @PostMapping("add")
//    public Result<Business> addBusiness(@RequestBody Business business) {
//        return Result.condition(businessService.save(business));
//    }
//    @GetMapping("{id}")
//    public Result<Business> getBusinessById(@PathVariable Integer id) {
//        return Result.data(businessService.getById(id));
//    }
}
