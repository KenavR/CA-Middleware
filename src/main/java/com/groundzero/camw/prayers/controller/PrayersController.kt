package com.groundzero.camw.prayers.controller

import com.groundzero.camw.cachier.CacheRepository
import com.groundzero.camw.network.NetworkResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/prayers")
class PrayersController {

    @Autowired
    lateinit var cacheRepository: CacheRepository

    @GetMapping
    fun getPrayers(): NetworkResponse {
        cacheRepository.readNetworkPrayers()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}