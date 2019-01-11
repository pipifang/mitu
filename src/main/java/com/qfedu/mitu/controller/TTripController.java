package com.qfedu.mitu.controller;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.service.TTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
@RestController
@RequestMapping("/api/t1")
public class TTripController {
    @Autowired
    private TTripService tripService;

    @PostMapping("/listTripById") //根据ID查询trip对象
    public Result listTripById(Integer id){
        return tripService.listTripById(id);
    }

    @PostMapping("/listAllTrip") //查询所有trip对象
    public Result listAllTrip(){

        return tripService.listAllTrip();

    }


    @PostMapping("/listTripByLocation") //根据目的地查询trip对象
    public Result listTripByLocation(String tripLocation){
        return tripService.listTripByLocation(tripLocation);
    }
}
